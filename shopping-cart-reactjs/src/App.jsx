import CartHeader from './components/CartHeader.jsx';
import ProductDetails from './components/ProductDetails.jsx';
import './App.css';


function App() {

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

      <ProductDetails />  
    </main>
  );
}

export default App;
