import React from 'react';
import { useCart } from './CartContext';

const ProductCard = ({ products }) => {
  const { dispatch } = useCart();

  const addToCart = () => {
    dispatch({ type: 'ADD_TO_CART', products });
  };

  return (
    <div className="product-card">
      <img src={products.thumbnail} alt={products.name} />
      <h3>{products.title}</h3>
      <p>${products.price}</p>
      <button onClick={addToCart}>Agregar al carrito</button>
    </div>
  );
};

export default ProductCard;
