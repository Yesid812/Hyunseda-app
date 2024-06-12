package co.hyunseda.client.Domain.Puerto;

import co.hyunseda.client.Infrastructure.Entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marca esta interfaz como un componente de repositorio de Spring
public interface IClientRepository extends JpaRepository<ClientEntity, Long> {
    // Extiende JpaRepository para tener acceso a operaciones CRUD en la entidad Client con ID de tipo Long

    // Método personalizado para verificar si existe un cliente con el nombre proporcionado
    boolean existsByFirstName(String firstName);
}
