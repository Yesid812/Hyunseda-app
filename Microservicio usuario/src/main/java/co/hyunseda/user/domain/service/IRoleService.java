package co.hyunseda.user.domain.service;

import co.hyunseda.user.domain.entity.Role;
import co.hyunseda.user.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRoleService {
    List<Role> findAllRoles();

}
