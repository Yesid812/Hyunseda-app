import React from 'react';
import './aretes.css';
import icons from '../assets/Icons/icons';

export function AretesSection({ products, onAddToCart }) {
  return (
    <div className="aretes-section">
      <div className="title">
        <h2>Aretes</h2>
        <button>
          <img src={icons.arrow} alt="" />Explorar
        </button>
      </div>
      <div className="products">
        <ul>
          {products.slice(0, 10).map((product) => (
            <li key={product.productId}>
              <img src={product.productPhoto} alt={product.name} />
              <div>
                <p>{product.name}</p>
                <p>{product.price}</p>
              </div>
              <button className="add-to-cart" onClick={() => onAddToCart(product)}>
                <img src={icons.cart} alt="" /> Agregar
              </button>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}