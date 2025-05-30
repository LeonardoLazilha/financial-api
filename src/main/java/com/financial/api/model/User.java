package com.financial.api.model;

import com.financial.api.dto.UserRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.scheduling.annotation.Scheduled;

@Entity(name = "User")
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;

    private Boolean admin = false;

    public User(UserRequestDTO dto){
        this.nome = dto.nome();
        this.email = dto.email();
        this.senha = dto.senha();
        this.admin = dto.admin();
    }

}
