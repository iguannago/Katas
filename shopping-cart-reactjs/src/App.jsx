import CartHeader from './components/CartHeader.jsx';
import './App.css';

import { useState } from 'react';

function App() {
  const [productName, setProductName] = useState('');

  return (
    <main>
      <CartHeader
        title='Shopping cart'
        description='Manage your cart and view your receipt.'
      />

      <section aria-labelledby='cart-heading'>
        <h2 id='cart-heading'>Your cart</h2>
        <p>No cart selected.</p>
      </section>

      <section aria-labelledby='product-heading'>
        <h2 id='product-heading'>Product details</h2>

        <label htmlFor='product-name'>Product name</label>
        <input
          id='product-name'
          type='text'
          value={productName}
          onChange={(event) => setProductName(event.target.value)}
        />

        <p>
          {productName.trim()
            ? `Draft product: ${productName}`
            : 'Enter a product name.'}
        </p>
      </section>
    </main>
  );
}

export default App;
