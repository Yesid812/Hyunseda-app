package co.hyunseda.user.presentation;


import co.hyunseda.user.domain.entity.Role;
import co.hyunseda.user.domain.entity.User;
import co.hyunseda.user.domain.entity.UserRole;
import co.hyunseda.user.domain.service.IRoleService;
import co.hyunseda.user.domain.service.IUserRoleService;
import co.hyunseda.user.domain.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Configuration
@RestController

@RequestMapping("user")
public class UserController {

    @Autowired
    @Qualifier("userRoleServiceDTO")
    IUserService userService;
    IUserRoleService userRoleService;
    IRoleService roleService;

    /**
     * @return Listar roles
     * @Brief Función que retorna las lista de los roles en json.
     */
    @GetMapping(value = "/roles", produces = "application/json")
    public List<Role> findAllRoles(){return roleService.findAllRoles();}


    /**
     * @return Lista con todos los roles de los usuarios registrados
     * @Brief Función que retorna las lista de roles de todos los usuarios en json.
     */
    @GetMapping(value = "/userroles", produces = "application/json")
    public List<UserRole> findAllUsersRoles(){return userRoleService.findAllUserRoles();}


    /**
     * @Brief Función para guardar un nuevo usuario.
     * @param user Parámetro de tipo usuario.
     * @return Valor booleano true en caso de inserción exitosa o false en caso contrario
     */
    @RequestMapping(method = RequestMethod.POST, produces ="application/json")
    @ResponseBody
    public boolean saveClient(@RequestBody User user)
    {
        return userService.save(user);
    }


    /**
     * @Brief Función que retorna las lista de los usuarios en json.
     * @return Lista con todos los usuarios registrados
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<User> findAllUsers(){return userService.findAll();}


    /**
     * @Brief Función para buscar un usuario mediante su id.
     * @param id Parámetro con la id del usuario a buscar
     * @return El usuario buscado por su id.
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * @Brief Función que actualiza un cliente.
     * @param id Parámetro con la id del usuario a actualizar
     * @param user Parámetro de tipo usuario a actualizar.
     * @return Petición correcta cuando el usuario es encontrado y actualizado en caso contrario se devolverá una petición incorrecta.
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {
        if (userService.update(id, user)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    /**
     * @Brief Función para eliminar un usuario.
     * @param id Parámetro con la id del usuario a eliminar
     * @return  Respuesta correcta en caso de ser eliminado correctamente o fallida en caso contrario.
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) {
        if (userService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
