package com.financial.api.dto;

import com.financial.api.model.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record LancamentoUpdateDTO(
        @NotBlank(message = "A descrição é obrigatória")
        String descricao,

        @NotNull(message = "O valor é obrigatório")
        @Positive(message = "O valor deve ser positivo")
        BigDecimal valor,

        @NotNull(message = "O TIPO é obrigatório: RECEITA/DESPESA")
        Tipo tipo,

        @NotNull
        Long userId
) {
}
