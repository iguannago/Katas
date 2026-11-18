import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import './index.css';
import App from './App.jsx';
import { initializeAuth } from './auth/keycloak.js';

const root = createRoot(document.getElementById('root'));

root.render(
  <main>
    <p role='status'>Checking your sign-in status…</p>
  </main>,
);

async function startApp() {
  try {
    const authenticated = await initializeAuth();

    root.render(
      <StrictMode>
        <App initialAuthenticated={authenticated} />
      </StrictMode>,
    );
  } catch {
    root.render(
      <main>
        <h1>Shopping cart</h1>
        <p role='alert'>
          Sign-in could not be initialised. Check that Keycloak is running, then
          try again.
        </p>
        <button type='button' onClick={() => window.location.reload()}>
          Retry
        </button>
      </main>,
    );
  }
}

startApp();
