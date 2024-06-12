package co.hyunseda.client.Infrastructure.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Marca esta clase como una entidad JPA
@Table(name="Client") // Especifica el nombre de la tabla en la base de datos
@Data // Anotación de Lombok para generar automáticamente getters, setters, toString, etc.
@AllArgsConstructor // Constructor que incluye todos los campos como argumentos
@NoArgsConstructor // Constructor sin argumentos
@Builder // Patrón de diseño para construir objetos de manera más concisa
public class ClientEntity {

    private static final long serialVersionUID = 1L;

    @Id // Indica que este campo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación de valor automático para la clave primaria
    private Long clientId; // Identificador único del cliente

    private String firstName; // Nombre del cliente
    private String lastName; // Apellido del cliente
}
