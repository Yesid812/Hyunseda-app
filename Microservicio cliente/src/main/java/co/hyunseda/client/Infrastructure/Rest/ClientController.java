package co.hyunseda.client.Infrastructure.Rest;

import co.hyunseda.client.Infrastructure.Entity.ClientEntity;
import co.hyunseda.client.Application.Service.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {

    // Definición del logger para registrar mensajes de depuración
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    // Inyección de dependencia del servicio de cliente
    @Autowired
    private IClientService clientService;

    // Endpoint para guardar un cliente mediante una solicitud POST
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public boolean saveClient(@RequestBody ClientEntity client) {
        // Registro de un mensaje de depuración para el cliente recibido en la solicitud POST
        logger.debug("Cliente recibido en la solicitud POST: {}", client);

        // Llamada al método del servicio para guardar el cliente
        return clientService.save(client);
    }

    // Endpoint para obtener un cliente por su ID mediante una solicitud GET
    @GetMapping("/{id}")
    public ResponseEntity<ClientEntity> getClientById(@PathVariable Long id) {
        // Llamada al método del servicio para encontrar un cliente por su ID
        ClientEntity client = clientService.findById(id);
        if (client != null) {
            // Si se encuentra el cliente, se devuelve una respuesta exitosa con el cliente como cuerpo
            return ResponseEntity.ok(client);
        } else {
            // Si no se encuentra el cliente, se devuelve una respuesta de 'no encontrado'
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para obtener todos los clientes mediante una solicitud GET
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<ClientEntity> findAllClients() {
        // Llamada al método del servicio para encontrar todos los clientes
        return clientService.findAll();
    }

    // Endpoint para actualizar un cliente mediante una solicitud PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@PathVariable Long id, @RequestBody ClientEntity client) {
        // Llamada al método del servicio para actualizar el cliente con el ID proporcionado
        if (clientService.update(id, client)) {
            // Si la actualización es exitosa, se devuelve una respuesta exitosa sin contenido
            return ResponseEntity.ok().build();
        } else {
            // Si la actualización falla, se devuelve una respuesta de 'solicitud incorrecta'
            return ResponseEntity.badRequest().build();
        }
    }

    // Endpoint para eliminar un cliente por su ID mediante una solicitud DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClientById(@PathVariable Long id) {
        // Llamada al método del servicio para eliminar el cliente con el ID proporcionado
        if (clientService.deleteById(id)) {
            // Si la eliminación es exitosa, se devuelve una respuesta exitosa sin contenido
            return ResponseEntity.ok().build();
        } else {
            // Si no se encuentra el cliente para eliminar, se devuelve una respuesta de 'no encontrado'
            return ResponseEntity.notFound().build();
        }
    }
}
