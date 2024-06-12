package co.hyunseda.client.Application.Service;

import co.hyunseda.client.Infrastructure.Entity.ClientEntity;
import co.hyunseda.client.Domain.Puerto.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Anotación que marca esta clase como un servicio de Spring
public class ClientService implements IClientService {

    private final IClientRepository clientRepository; // Repositorio de clientes

    // Constructor que recibe el repositorio de clientes como argumento
    @Autowired
    public ClientService(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Método para guardar un cliente en la base de datos
    @Override
    public boolean save(ClientEntity client) {
        try {
            clientRepository.save(client); // Guarda el cliente utilizando el repositorio
            return true; // Devuelve true si la operación es exitosa
        } catch (Exception e) {
            e.printStackTrace(); // Imprime la traza de la excepción en caso de error
            return false; // Devuelve false si ocurre un error
        }
    }

    // Método para buscar un cliente por su ID
    @Override
    public ClientEntity findById(Long id) {
        return clientRepository.findById(id).orElse(null); // Busca el cliente por su ID en el repositorio
    }

    // Método para obtener todos los clientes
    @Override
    public List<ClientEntity> findAll() {
        return clientRepository.findAll(); // Obtiene todos los clientes del repositorio
    }

    // Método para actualizar un cliente existente
    @Override
    public boolean update(Long id, ClientEntity client) {
        if (clientRepository.existsById(id)) { // Verifica si existe un cliente con el ID proporcionado
            client.setClientId(id); // Establece el ID del cliente en el objeto proporcionado
            clientRepository.save(client); // Guarda el cliente actualizado en el repositorio
            return true; // Devuelve true si la actualización es exitosa
        }
        return false; // Devuelve false si no se encuentra el cliente con el ID proporcionado
    }

    // Método para eliminar un cliente por su ID
    @Override
    public boolean deleteById(Long id) {
        if (clientRepository.existsById(id)) { // Verifica si existe un cliente con el ID proporcionado
            clientRepository.deleteById(id); // Elimina el cliente del repositorio
            return true; // Devuelve true si la eliminación es exitosa
        }
        return false; // Devuelve false si no se encuentra el cliente con el ID proporcionado
    }
}
