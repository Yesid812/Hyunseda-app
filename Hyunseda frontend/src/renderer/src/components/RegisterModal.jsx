import React, { useState } from 'react';
import './RegisterModal.css';
import './ModalLogin.css';

const RegisterModal = ({ onClose }) => {
  const [formData, setFormData] = useState({
    name: '',
    lastname: '',
    email: '',
    password: '',
    confirmPassword: ''
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch('http://localhost:8087/client', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
      });

      if (response.ok) {
        // Registro exitoso, puedes realizar alguna acción, como cerrar el modal
        onClose();
      } else {
        // Manejar errores de registro, por ejemplo, mostrar un mensaje de error al usuario
        console.error('Error al registrar el cliente');
      }
    } catch (error) {
      console.error('Error de red:', error);
    }
  };

  return (
    <div className="modal-register-overlay">
      <div className="modal-register">
        <button className="close-button" onClick={onClose}>X</button>
        <h2 className="title">Crear Nuevo Contacto</h2>
        <form onSubmit={handleSubmit}>
          <div className='info-client'>
            <div className='name-lastname-section'>
              <label htmlFor="name">Nombre</label>
              <input type="text" id="name" name="name" className='input' placeholder='Nombre:' onChange={handleChange} />
            </div>
            <div className='name-lastname-section'>
              <label htmlFor="lastname">Apellido</label>
              <input type="text" id="lastname" name="lastname" className='input' placeholder='Apellido:' onChange={handleChange} />
            </div>
          </div>
          <label htmlFor="email">Correo Electrónico</label>
          <input type="email" id="email" name="email" className='input' placeholder='Correo Electrónico' onChange={handleChange} />
          <div className='password-section'>
            <div className='password-section-input'>
              <label htmlFor="password">Contraseña</label>
              <input type="password" id="password" name="password" className='input' placeholder='Contraseña' onChange={handleChange} />
            </div>
            <div className='password-section-input'>
              <label htmlFor="confirm-password">Repetir Contraseña</label>
              <input type="password" id="confirm-password" name="confirmPassword" className='input' placeholder='Repetir Contraseña' onChange={handleChange} />
            </div>
          </div>
          <div className='buttons'>
            <button type="button" id="cancel-button" onClick={onClose}>Cancelar</button>
            <button type="submit" id="register-button">Registrarme</button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default RegisterModal;
