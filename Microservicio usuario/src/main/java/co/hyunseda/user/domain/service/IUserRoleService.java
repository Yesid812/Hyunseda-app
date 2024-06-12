package co.hyunseda.user.domain.service;

import co.hyunseda.user.domain.entity.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserRoleService {
    List<UserRole> findAllUserRoles();
}
