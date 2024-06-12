// AuthContext.js
import React, { createContext, useState } from 'react';

const AuthContext = createContext();

const AuthProvider = ({ children }) => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const login = () => {
    // Realizar la lógica de inicio de sesión aquí
    // Por ejemplo, establecer el estado de isLoggedIn como verdadero
    setIsLoggedIn(true);
    // Además, puedes almacenar el estado de autenticación en localStorage
    localStorage.setItem('isLoggedIn', true);
  };

  const logout = () => {
    // Realizar la lógica de cierre de sesión aquí
    // Por ejemplo, establecer el estado de isLoggedIn como falso
    setIsLoggedIn(false);
    // También, limpiar el estado de autenticación en localStorage
    localStorage.removeItem('isLoggedIn');
  };

  return (
    <AuthContext.Provider value={{ isLoggedIn, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

export { AuthContext, AuthProvider };
