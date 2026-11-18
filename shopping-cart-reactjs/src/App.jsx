import CartHeader from './components/CartHeader.jsx';
import ProductForm from './components/ProductForm.jsx';
import './App.css';
import { useState } from 'react';
import { keycloak } from './auth/keycloak.js';
import { createCart, getReceipt } from './api/cartApi.js';

function App({ initialAuthenticated }) {
  const [submittedProduct, setSubmittedProduct] = useState(null);

  const [signInError, setSignInError] = useState('');
  const [isSigningIn, setIsSigningIn] = useState(false);

  const [cartId, setCartId] = useState(null);

  const [isCreatingCart, setIsCreatingCart] = useState(false);
  const [cartError, setCartError] = useState('');

  const [receipt, setReceipt] = useState(null);
  const [isLoadingReceipt, setIsLoadingReceipt] = useState(false);
  const [receiptError, setReceiptError] = useState('');

  function handleProductSubmit(product) {
    setSubmittedProduct(product);
  }

  async function handleSignIn() {
    setSignInError('');
    setIsSigningIn(true);

    try {
      await keycloak.login({
        redirectUri: `${window.location.origin}/`,
      });
    } catch {
      setSignInError('Sign-in could not be started. Please try again.');
      setIsSigningIn(false);
    }
  }

  async function handleCreateCart() {
    setCartError('');
    setIsCreatingCart(true);

    try {
      const cart = await createCart();
      setCartId(cart.id);
    } catch (error) {
      setCartError(
        error instanceof Error
          ? error.message
          : 'The cart could not be created.',
      );
    } finally {
      setIsCreatingCart(false);
    }
  }

  async function handleLoadReceipt() {
    setReceiptError('');
    setIsLoadingReceipt(true);

    try {
      const updatedReceipt = await getReceipt(cartId);
      setReceipt(updatedReceipt);
    } catch (error) {
      setReceiptError(
        error instanceof Error
          ? error.message
          : 'The receipt could not be loaded.',
      );
    } finally {
      setIsLoadingReceipt(false);
    }
  }

  return (
    <main>
      <CartHeader
        title='Shopping cart'
        description='Manage your cart and view your receipt.'
      />

      <section aria-label='Sign-in status'>
        {initialAuthenticated ? (
          <p>
            Signed in as{' '}
            {keycloak.tokenParsed?.preferred_username ?? 'authenticated user'}
          </p>
        ) : (
          <>
            <p>Sign in to manage your shopping cart.</p>
            <button type='button' onClick={handleSignIn} disabled={isSigningIn}>
              {isSigningIn ? 'Redirecting…' : 'Sign in'}
            </button>
          </>
        )}

        {signInError && <p role='alert'>{signInError}</p>}
      </section>

      {initialAuthenticated && (
        <>
          <section aria-labelledby='cart-heading'>
            <h2 id='cart-heading'>Your cart</h2>

            {cartId ? <p>Cart ID: {cartId}</p> : <p>No cart selected.</p>}

            <button
              type='button'
              onClick={handleCreateCart}
              disabled={isCreatingCart || cartId !== null}
            >
              {isCreatingCart ? 'Creating cart…' : 'Create cart'}
            </button>

            {cartError && <p role='alert'>{cartError}</p>}
          </section>

          {cartId && (
            <section aria-labelledby='receipt-heading'>
              <h2 id='receipt-heading'>Receipt</h2>

              <button
                type='button'
                onClick={handleLoadReceipt}
                disabled={isLoadingReceipt}
              >
                {isLoadingReceipt ? 'Loading receipt…' : 'Refresh receipt'}
              </button>

              {receiptError && <p role='alert'>{receiptError}</p>}

              {receipt && (
                <>
                  {receipt.lines.length === 0 ? (
                    <p>Your cart is empty.</p>
                  ) : (
                    <table>
                      <caption>Products in your cart</caption>
                      <thead>
                        <tr>
                          <th scope='col'>Product</th>
                          <th scope='col'>Quantity</th>
                          <th scope='col'>Unit price</th>
                        </tr>
                      </thead>
                      <tbody>
                        {receipt.lines.map((line) => (
                          <tr key={line.product.id}>
                            <td>{line.product.name}</td>
                            <td>{line.quantity}</td>
                            <td>£{line.product.price}</td>
                          </tr>
                        ))}
                      </tbody>
                    </table>
                  )}
                </>
              )}
            </section>
          )}

          <ProductForm onProductSubmit={handleProductSubmit} />

          {submittedProduct && (
            <section aria-labelledby='submitted-product-heading'>
              <h2 id='submitted-product-heading'>Submitted Product</h2>
              <p>Product ID: {submittedProduct.id}</p>
              <p>Product Name: {submittedProduct.name}</p>
              <p>Unit Price: £{submittedProduct.price}</p>
            </section>
          )}
        </>
      )}
    </main>
  );
}

export default App;
