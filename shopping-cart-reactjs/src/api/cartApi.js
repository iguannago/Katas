import { keycloak } from '../auth/keycloak.js';

export class ApiError extends Error {
  constructor(message, status) {
    super(message);
    this.name = 'ApiError';
    this.status = status;
  }
}

async function apiRequest(path, options = {}) {
  if (!keycloak.authenticated) {
    throw new ApiError('Please sign in before using your cart.', 401);
  }

  try {
    await keycloak.updateToken(30);
  } catch {
    throw new ApiError(
      'Your session could not be refreshed. Please sign in again.',
      401,
    );
  }

  if (!keycloak.token) {
    throw new ApiError(
      'No access token is available. Please sign in again.',
      401,
    );
  }

  const headers = new Headers(options.headers);
  headers.set('Authorization', `Bearer ${keycloak.token}`);
  headers.set('Accept', 'application/json');

  let response;

  try {
    response = await fetch(`/api${path}`, {
      ...options,
      headers,
    });
  } catch (error) {
    if (error.name === 'AbortError') {
      throw error;
    }

    throw new ApiError('The API could not be reached.', 0);
  }

  if (!response.ok) {
    const problem = await response.json().catch(() => null);

    const message =
      response.status === 401
        ? 'Your session is not accepted. Please sign in again.'
        : (problem?.detail ?? `Request failed (${response.status}).`);

    throw new ApiError(message, response.status);
  }

  return response;
}

export async function createCart() {
  const response = await apiRequest('/carts', {
    method: 'POST',
  });

  return response.json();
}

export async function getReceipt(cartId) {
  const response = await apiRequest(
    `/carts/${encodeURIComponent(cartId)}/receipt`,
  );

  return response.json();
}
