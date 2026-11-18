import base64
import hashlib
import json
import os
import secrets
import tempfile
import time
import urllib.parse
import urllib.request
import webbrowser
from http.server import BaseHTTPRequestHandler, HTTPServer

issuer = "http://localhost:8081/realms/shopping-cart"
redirect_uri = "http://localhost:8765/callback"
client_id = "shopping-cart-cli"

verifier = secrets.token_urlsafe(64)
challenge = base64.urlsafe_b64encode(
    hashlib.sha256(verifier.encode()).digest()
).rstrip(b"=").decode()
state = secrets.token_urlsafe(32)
result = {}


class Callback(BaseHTTPRequestHandler):
    def log_message(self, *args):
        pass  # Avoid logging the authorization code.

    def do_GET(self):
        url = urllib.parse.urlsplit(self.path)
        params = urllib.parse.parse_qs(url.query)

        valid = (
            url.path == "/callback"
            and secrets.compare_digest(
                params.get("state", [""])[0], state
            )
        )

        if not valid:
            self.send_response(400)
            self.end_headers()
            self.wfile.write(b"Invalid callback.")
            return

        result["code"] = params.get("code", [None])[0]
        result["received"] = True

        self.send_response(200)
        self.send_header("Content-Type", "text/plain")
        self.end_headers()
        self.wfile.write(b"Callback received. Return to your terminal.")


query = urllib.parse.urlencode({
    "client_id": client_id,
    "redirect_uri": redirect_uri,
    "response_type": "code",
    "scope": "openid",
    "state": state,
    "nonce": secrets.token_urlsafe(32),
    "code_challenge": challenge,
    "code_challenge_method": "S256",
    "prompt": "login",
})

with HTTPServer(("127.0.0.1", 8765), Callback) as server:
    server.timeout = 1
    webbrowser.open(f"{issuer}/protocol/openid-connect/auth?{query}")

    deadline = time.monotonic() + 180
    while not result.get("received") and time.monotonic() < deadline:
        server.handle_request()

if not result.get("code"):
    raise SystemExit("Login failed or timed out. Run the helper again.")

data = urllib.parse.urlencode({
    "grant_type": "authorization_code",
    "client_id": client_id,
    "redirect_uri": redirect_uri,
    "code": result["code"],
    "code_verifier": verifier,
}).encode()

request = urllib.request.Request(
    f"{issuer}/protocol/openid-connect/token",
    data=data,
    headers={"Content-Type": "application/x-www-form-urlencoded"},
)

with urllib.request.urlopen(request, timeout=15) as response:
    token = json.load(response)["access_token"]

fd, path = tempfile.mkstemp(prefix="shopping-cart-token-", suffix=".txt")
with os.fdopen(fd, "w") as file:
    file.write(token)

print(f"Access token saved to: {path}")