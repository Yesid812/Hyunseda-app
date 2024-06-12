import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router } from 'react-router-dom'; // Importa BrowserRouter
import CategoryContainer from './components/CategorySection';
import HorizontalMenu from './components/HorizontalMenu';
import { NewProductsSection } from './components/newProductsSection';
import { AretesSection } from './components/AretesSection';
import { CartProvider } from './components/CartContext';
import Cart from './components/Cart';
import { AuthProvider } from './components/AuthContext';

function App() {
  const [cart, setCart] = useState([]);
  const [view, setView] = useState('products'); // 'products' or 'cart'
  const [products, setProducts] = useState([]); // Estado para almacenar los productos
  const [filteredProducts, setFilteredProducts] = useState([]); // Estado para almacenar los productos filtrados por búsqueda
  const [showNewProducts, setShowNewProducts] = useState(true);

  // Cargar el carrito desde localStorage al cargar la página
  useEffect(() => {
    const savedCart = localStorage.getItem('cart');
    if (savedCart) {
      setCart(JSON.parse(savedCart));
    }
  }, []);

  // Guardar el carrito en localStorage cada vez que cambie
  useEffect(() => {
    localStorage.setItem('cart', JSON.stringify(cart));
  }, [cart]);

  // Cargar los productos desde el API al cargar la página
  useEffect(() => {
    fetch('http://localhost:8080/products')
      .then(response => response.json())
      .then(data => setProducts(data))
      .catch(error => console.error('Error fetching products:', error));
  }, []);

  // Función para manejar la búsqueda de productos
  const handleSearch = (searchTerm) => {
    // Filtrar los productos cuyo nombre incluya el término de búsqueda
    const filtered = products.filter((product) =>
      product.name.toLowerCase().includes(searchTerm.toLowerCase())
    );
    setFilteredProducts(filtered);
    // Cambiar la vista a 'search' para mostrar los resultados de la búsqueda
    setView('search');
    setShowNewProducts(false);
  };

  // Restaurar la visibilidad de NewProductsSection al volver a la vista de productos
  const handleReturnToProducts = () => {
    setShowNewProducts(true);
  };
  const handleAddToCart = (product) => {
    // Verificar si el producto ya está en el carrito
    const existingProductIndex = cart.findIndex((item) => item.productId === product.productId);
  
    if (existingProductIndex !== -1) {
      // Mostrar alerta indicando que el producto ya está en el carrito
      alert("Este producto ya está en el carrito");
      return; // Salir de la función sin agregar el producto al carrito
    }
  
    // Verificar el stock disponible
    if (product.cantidad < 1) {
      // Mostrar alerta indicando que no hay stock disponible
      alert("No hay stock disponible para este producto");
      return; // Salir de la función sin agregar el producto al carrito
    }
  
    // Si el producto no está en el carrito y hay stock disponible, agregarlo al carrito
    setCart([...cart, { ...product, quantity: 1 }]);
  };

  const handleIncreaseQuantity = (productId) => {
    const updatedCart = cart.map((item) => {
      if (item.id === productId) {
        return { ...item, quantity: item.quantity + 1 };
      }
      return item;
    });
    setCart(updatedCart);
  };

  const handleDecreaseQuantity = (productId) => {
    const updatedCart = cart.map((item) => {
      if (item.id === productId && item.quantity > 1) {
        return { ...item, quantity: item.quantity - 1 };
      }
      return item;
    });
    setCart(updatedCart.filter((item) => item.quantity > 0));
  };

  const handleRemoveItem = (productToRemove) => {
    setCart(cart.filter((item) => item.productId !== productToRemove.productId));
  };

  return (
    <AuthProvider>
    <Router>
      <CartProvider>
        <div className="app">
          <HorizontalMenu onCartClick={() => setView('cart')} onSearch={handleSearch} />
          {view === 'products' ? (
            <>
              <CategoryContainer />
              <NewProductsSection products={products} onAddToCart={handleAddToCart} />
              <AretesSection products={products} onAddToCart={handleAddToCart} />
            </>
          ) : view === 'search' ? (
            // Mostrar los resultados de la búsqueda
            <NewProductsSection products={filteredProducts} onAddToCart={handleAddToCart} />
          ) : (
            // Mostrar el carrito
            <Cart
              cart={cart}
              onIncreaseQuantity={handleIncreaseQuantity}
              onDecreaseQuantity={handleDecreaseQuantity}
              onRemoveItem={handleRemoveItem}
            />
          )}
        </div>
      </CartProvider>
    </Router>
    </AuthProvider>
  );
}

export default App;
