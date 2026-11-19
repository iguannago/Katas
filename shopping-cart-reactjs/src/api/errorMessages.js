import { ApiError } from './cartApi.js';

export function getErrorMessage(error) {
  if (!(error instanceof ApiError)) {
    return 'Something went wrong. Please try again.';
  }

  if (error.status === 0) {
    return 'Could not contact the API. Check your connection and try again.';
  }

  if (error.status === 401) {
    return 'Your session is no longer accepted. Please sign in again.';
  }

  if (error.status === 404) {
    return 'This cart is unavailable or you do not have access to it.';
  }

  if (error.status >= 500) {
    return 'The service is having a problem. Please try again shortly.';
  }

  return error.message;
}
