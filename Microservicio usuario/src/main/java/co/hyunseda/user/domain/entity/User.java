package co.hyunseda.user.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Table(name = "Users")

public class User {

    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientID;
    private String username;
    private String email;
    private String  password;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = UserRole.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "UserRole",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "role_name"))
    private Set<UserRole> roles;
}
