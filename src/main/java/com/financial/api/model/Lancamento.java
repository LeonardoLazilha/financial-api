package com.financial.api.model;

import com.financial.api.dto.LancamentoRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "Lancamento")
@Table(name = "lancamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Lancamento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private BigDecimal valor;
    private LocalDateTime data = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Lancamento (LancamentoRequestDTO dto){
        this.descricao = dto.descricao();
        this.valor = dto.valor();
        this.tipo = dto.tipo();
    }

    @PrePersist
    public void prePersist() {
        if (this.data == null) {
            this.data = LocalDateTime.now();
        }
    }
}