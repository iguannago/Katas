import { useState } from 'react';

function ProductDetails() {
  const [productName, setProductName] = useState('');

  return (
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
  );
}

export default ProductDetails;
  