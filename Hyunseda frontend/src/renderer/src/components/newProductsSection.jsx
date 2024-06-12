import React from 'react';
import './newProductsSection.css';
import icons from '../assets/Icons/icons';

export function NewProductsSection({ products, onAddToCart, isSearching }) {
  return (
    <div className="new-products-section">
      {!isSearching && ( // Verificar si no se está realizando una búsqueda
        <div className="title">
          <h2>Nuevos productos</h2>
          <button>
            <img src={icons.arrow} alt="" />Ver más
          </button>
        </div>
      )}
      <div className="products">
        <ul>
          {products.map((product) => (
            <li key={product.productId}>
              <img src={product.productPhoto} alt={product.name} />
              <div>
                <p>{product.name}</p>
                <p>{product.price}</p>
              </div>
              <button className="add-to-cart" onClick={() => onAddToCart(product)}>
                <img src={icons.cart} alt="" />Agregar
              </button>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}