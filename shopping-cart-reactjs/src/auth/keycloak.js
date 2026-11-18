import Keycloak from 'keycloak-js';

export const keycloak = new Keycloak({
  url: 'http://localhost:8081',
  realm: 'shopping-cart',
  clientId: 'shopping-cart-web',
});

let initializationPromise;

export function initializeAuth() {
  if (!initializationPromise) {
    initializationPromise = keycloak.init({
      onLoad: 'check-sso',
      pkceMethod: 'S256',
      redirectUri: `${window.location.origin}/`,
    });
  }

  return initializationPromise;
}
