package co.hyunseda.user.domain.service;

import co.hyunseda.user.access.IRoleRepository;
import co.hyunseda.user.access.IUserRepository;
import co.hyunseda.user.access.IUserRoleRepository;
import co.hyunseda.user.domain.entity.Role;
import co.hyunseda.user.domain.entity.User;
import co.hyunseda.user.domain.entity.UserRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserRoleServiceDTO implements IUserService, IRoleService, IUserRoleService{

    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final IUserRoleRepository userRoleRepository;

    public UserRoleServiceDTO(IUserRepository userRepository, IRoleRepository roleRepository, IUserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
    }

    /**
     * @Brief Listar todos roles
     * @return Lista de todos los roles
     */
    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }


    /**
     * @Brief Listar todos roles de los usuarios
     * @return Lista de todos los roles de los usuarios
     */
    @Override
    public List<UserRole> findAllUserRoles() {
        return userRoleRepository.findAll();
    }


    /**
     * @Brief Agregar un nuevo usuario
     * @param user Parámetro de tipo usuario
     * @return Boleano true en caso de ser agregado false en caso contrario
     */
    @Override
    public boolean save(User user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * @Brief Listar usuarios
     * @return Una lista de todos los usuarios
     */
    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }


    /**
     * @Brief Encontrar usuario por su id
     * @param id Id del usuario a buscar
     * @return Usuario encontrado o null en caso contrario
     */
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * @Brief Actualizar un usuario
     * @param id Id del usuario a actualizar
     * @param user Parámetro de tipo usuario
     * @return Boleando true cuando se actualizo correctamente o false en caso contrario
     */
    @Override
    public boolean update(Long id, User user) {
        return false;
    }

    /**
     * @Brief Eliminar un usuario
     * @param id Id del usuario a eliminar
     * @return Boleano true en caso de ser eliminado y false en caso contrario
     */
    @Override
    public boolean deleteById(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
