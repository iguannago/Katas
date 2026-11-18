import { useState } from 'react';

function ProductForm() {
  const [productId, setProductId] = useState('');
  const [productName, setProductName] = useState('');
  const [price, setPrice] = useState('');

  function handleSubmit(event) {
    event.preventDefault();
  }

  return (
    <section aria-labelledby='product-heading'>
      <h2 id='product-heading'>Product details</h2>

      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor='product-id'>Product ID</label>
          <input
            id='product-id'
            type='text'
            value={productId}
            onChange={(event) => setProductId(event.target.value)}
            required
          />
        </div>

        <div>
          <label htmlFor='product-name'>Product name</label>
          <input
            id='product-name'
            type='text'
            value={productName}
            onChange={(event) => setProductName(event.target.value)}
            required
          />
        </div>

        <div>
          <label htmlFor='product-price'>Unit price (£)</label>
          <input
            id='product-price'
            type='number'
            min='0'
            step='any'
            value={price}
            onChange={(event) => setPrice(event.target.value)}
            required
          />
        </div>

        <button type='submit'>Add one unit</button>
      </form>
    </section>
  );
}

export default ProductForm;
