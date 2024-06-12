import React, { useState } from 'react';
import './ModalLogin.css';
import users from '../mocks/user.json';

const LoginModal = ({ onClose }) => {
  const [credentials, setCredentials] = useState({
    email: '',
    password: ''
  });

  const handleChange = (event) => {
    const { name, value } = event.target;
    setCredentials({ ...credentials, [name]: value });
  };

  const handleLogin = (event) => {
    event.preventDefault();
    const { email, password } = credentials;

    const user = users.find(user => user.email === email && user.password === password);

    if (user) {
      if (user.role === 'admin') {
        alert('¡Te has autenticado como administrador!');
      }
      // Aquí podrías manejar otros roles, si es necesario
      onClose(); // Cierra el modal de inicio de sesión
    } else {
      alert('Credenciales inválidas');
    }
  };

  return (
    <div className="modal-overlay">
      <div className="modal">
        <button className="close-button" onClick={onClose}>X</button>
        <h1 className='title'>Iniciar Sesión</h1>
        <form onSubmit={handleLogin}>
          <label htmlFor="email">Correo Electrónico:</label>
          <input type="email" id="email" name="email" className='input' placeholder='Correo electrónico' value={credentials.email} onChange={handleChange} />
          <label htmlFor="password">Contraseña:</label>
          <input type="password" id="password" name="password" className='input' placeholder='Contraseña' value={credentials.password} onChange={handleChange} />
          <div className="buttons">
            <button id="cancel-button" type="button" onClick={onClose}>Cancelar</button>
            <button type="submit" id="login-button">Iniciar Sesión</button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default LoginModal;
