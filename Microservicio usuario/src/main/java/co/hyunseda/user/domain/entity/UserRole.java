package co.hyunseda.user.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="UserRole")
@IdClass(UserRolePk.class)
public class UserRole {
    @Id
    @Column(name = "client_id")
    private Long client_id;

    @Id
    @Column(name = "role_name")
    String roleName;
}
