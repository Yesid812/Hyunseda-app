package co.hyunseda.user.access;

import co.hyunseda.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query (value = "SELECT * FROM User WHERE username = ?1", nativeQuery = true)
    Optional<Object> findByUsername(String username);
}
