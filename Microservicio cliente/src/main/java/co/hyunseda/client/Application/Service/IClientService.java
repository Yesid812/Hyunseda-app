package co.hyunseda.client.Application.Service;

import co.hyunseda.client.Infrastructure.Entity.ClientEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Anotación que marca esta interfaz como un servicio de Spring
public interface IClientService {

    // Método para guardar un cliente en la base de datos
    boolean save(ClientEntity client);

    // Método para buscar un cliente por su ID
    ClientEntity findById(Long id);

    // Método para obtener todos los clientes
    List<ClientEntity> findAll();

    // Método para actualizar un cliente existente
    boolean update(Long id, ClientEntity client);

    // Método para eliminar un cliente por su ID
    boolean deleteById(Long id);
}
