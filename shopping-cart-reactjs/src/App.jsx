import CartHeader from './components/CartHeader.jsx';
import ProductForm from './components/ProductForm.jsx';
import './App.css';
import { useState } from 'react';

function App() {

  const [submittedProduct, setSubmittedProduct] = useState(null);

  function handleProductSubmit(product) {
    setSubmittedProduct(product);
  }

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

      <ProductForm onProductSubmit={handleProductSubmit} />

      {submittedProduct && (
        <section aria-labelledby='submitted-product-heading'>
          <h2 id='submitted-product-heading'>Submitted Product</h2>
          <p>Product ID: {submittedProduct.id}</p>
          <p>Product Name: {submittedProduct.name}</p>
          <p>Unit Price: £{submittedProduct.price}</p>
        </section>
      )}
    </main>
  );
}

export default App;
