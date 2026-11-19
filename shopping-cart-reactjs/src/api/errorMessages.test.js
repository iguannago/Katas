import { describe, expect, it, vi } from 'vitest';

vi.mock('../auth/keycloak.js', () => ({
  keycloak: {},
}));

import { ApiError } from './cartApi.js';
import { getErrorMessage } from './errorMessages.js';

describe('getErrorMessage', () => {
  it('asks the user to sign in when authentication fails', () => {
    const error = new ApiError('Token rejected', 401);

    expect(getErrorMessage(error)).toBe(
      'Your session is no longer accepted. Please sign in again.',
    );
  });

  it('hides server details behind a safe message', () => {
    const error = new ApiError('Internal database failure', 503);

    expect(getErrorMessage(error)).toBe(
      'The service is having a problem. Please try again shortly.',
    );
  });

  it('handles unexpected errors safely', () => {
    const error = new Error('Unexpected implementation detail');

    expect(getErrorMessage(error)).toBe(
      'Something went wrong. Please try again.',
    );
  });
});
