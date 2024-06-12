import React, { useState, useRef, useEffect } from 'react';
import { Link } from 'react-router-dom'; // Importa Link desde React Router
import icons from '../assets/Icons/icons';
import LoginModal from './LoginModal';
import RegisterModal from './RegisterModal';

const HorizontalMenu = ({ onCartClick, onSearch }) => {
  const [isMenuOpen, setIsMenuOpen] = useState(false);
  const [isLoginModalOpen, setIsLoginModalOpen] = useState(false);
  const [isRegisterModalOpen, setIsRegisterModalOpen] = useState(false);
  const [searchTerm, setSearchTerm] = useState('');
  const userMenuRef = useRef(null);
  

  const handleToggleMenu = () => {
    setIsMenuOpen(!isMenuOpen);
  };

  const handleOpenLoginModal = () => {
    setIsLoginModalOpen(true);
    setIsMenuOpen(false);
  };

  const handleOpenRegisterModal = () => {
    setIsRegisterModalOpen(true);
    setIsMenuOpen(false);
  };

  const handleCloseModal = () => {
    setIsLoginModalOpen(false);
    setIsRegisterModalOpen(false);
  };

  const handleClickOutside = (event) => {
    if (userMenuRef.current && !userMenuRef.current.contains(event.target)) {
      setIsMenuOpen(false);
    }
  };
   // Función para manejar cambios en el término de búsqueda
   const handleChangeSearchTerm = (event) => {
    setSearchTerm(event.target.value);
  };

  // Función para realizar la búsqueda y pasar el término al componente App
  const handleSearch = () => {
    onSearch(searchTerm);
  };
  useEffect(() => {
    if (isMenuOpen) {
      document.addEventListener('mousedown', handleClickOutside);
    } else {
      document.removeEventListener('mousedown', handleClickOutside);
    }
    return () => {
      document.removeEventListener('mousedown', handleClickOutside);
    };
  }, [isMenuOpen]);

  return (
    <div className="horizontal-menu-body">
      <div className="img-input-menu">
        {/* Reemplaza el anchor (<a>) por Link */}
        <Link to="/">
          <div className="image">
            <img
              src="https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/logo_hyun-80px-49e58de0-7991-4b99-ba8e-7e02a9ca95df.png"
              alt="Logo"
            />
          </div>
        </Link>
        <div className="input-menu">
          <input id="search-input" type="text" placeholder="Buscar productos"  value={searchTerm} onChange={handleChangeSearchTerm}/>
          <button id="search-button" type="button" onClick={handleSearch}>
            <img src={icons.search} alt="buscar-productos" />
          </button>
        </div>
      </div>
      <div className="header-buttons">
        <button id="usuario" onClick={handleToggleMenu}>
          <img src={icons.user} alt="Usuario" />
        </button>
        <button id="carrito" onClick={onCartClick}>
          <img src={icons.cart} alt="Carrito de Compras" />
        </button>
        {isMenuOpen && (
          <div className="user-menu" ref={userMenuRef}>
            <button id="user-item">
              <img src={icons.google} alt="Google" />
              <a href="/login">Continuar con Google</a>
            </button>
            <button id="user-item">
              <img src={icons.facebook} alt="Facebook" />
              <a href="/register">Continuar con Facebook</a>
            </button>
            <button id="user-item" onClick={handleOpenLoginModal}>
              Iniciar Sesión
            </button>
            <button id="user-item" onClick={handleOpenRegisterModal} className="last-item">
              Registrarse
            </button>
          </div>
        )}
        {isLoginModalOpen && <LoginModal onClose={handleCloseModal} />}
        {isRegisterModalOpen && <RegisterModal onClose={handleCloseModal} />}
      </div>
    </div>
  );
};

export default HorizontalMenu;
