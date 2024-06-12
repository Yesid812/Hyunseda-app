package co.hyunseda.user.domain.service;

import co.hyunseda.user.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    boolean save(User user);
    List<User> findAll();
    User findById(Long id);
    boolean update(Long id, User user);
    boolean deleteById(Long id);
}
