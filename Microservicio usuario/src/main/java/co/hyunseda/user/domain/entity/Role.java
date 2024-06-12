package co.hyunseda.user.domain.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {
    @Id
    @Enumerated(EnumType.STRING)
    private RoleName name;

    public static enum RoleName
    {
        SUPERADMIN, ADMIN, EDITOR, VISITANTE
    }
}
