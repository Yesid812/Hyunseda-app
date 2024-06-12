package co.hyunseda.client.Domain.Model;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Client implements Serializable {
    private Long clientId; // Identificador único del cliente

    private String firstName; // Nombre del cliente
    private String lastName; // Apellido del cliente
}
