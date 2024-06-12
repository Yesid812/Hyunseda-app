import React from 'react';
import './Cart.css';
import icons from '../assets/Icons/icons';

const Cart = ({ cart, onIncreaseQuantity, onDecreaseQuantity, onRemoveItem }) => {
  const renderCartItems = () => {
    if (cart.length === 0) {
      return (
        <div className="empty-cart">
          <div className='empty-cart-image'>
          <img src={icons.buy} alt="image" />  
          </div>  
          <p>Tu carrito está vacío</p>
          <p>Explora nuestro catálogo de productos</p>
          <button>Explorar Productos</button>
        </div>
      );
    } else {
      return (
        <div className="cart-items">
          <h2 className="products-title">Productos</h2>
          <ul>
            {cart.map((item) => (
              <li key={item.productId}>
                <div className="item-details">
                  <img src={item.productPhoto} alt={item.title} />
                  <div>
                    <p>{item.name}</p>
                    <p>{formatCurrency(item.price * item.quantity)}</p>
                  </div>
                </div>
                <div className="item-quantity">
                  <button onClick={() => onRemoveItem(item)}  id="remove-button">
                    <img src={icons.remove} alt="" />
                  </button>
                  <div className="quantity-controls">
                    <button>-</button>
                    <p>{item.quantity}</p>
                    <button >+</button>
                  </div>
                </div>
              </li>
            ))}
          </ul>
        </div>
      );
    }
  };

  const calculateSubtotal = () => {
    if (cart.length === 0) return 0;
    return cart.reduce((acc, item) => acc + item.price * item.quantity, 0);
  };

  const calculateTotal = () => {
    return calculateSubtotal();
  };

  const formatCurrency = (value) => {
    return new Intl.NumberFormat('es-CO', {
      style: 'currency',
      currency: 'COP',
    }).format(value);
  };

  return (
    <div className="cart-section">
      <div className="cart">
        {renderCartItems()}
        <div className="cart-summary">
          <h2 className="products-title">Resumen</h2>
          <div className="summary-item">
            <p>Subtotal:</p> <span>{formatCurrency(calculateSubtotal())}</span>
          </div>
          <div className="summary-item">
            <p>Descuento:</p> <span>{formatCurrency(0)}</span>
          </div>
          <div className="summary-item">
            <p>Total:</p> <span>{formatCurrency(calculateTotal())}</span>
          </div>
          <button className="continue-button">Continuar Compra</button>
        </div>
      </div>
    </div>
  );
};

export default Cart;
