package com.financial.api.dto;

import com.financial.api.model.Tipo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record LancamentoRequestDTO(
        String descricao,
        BigDecimal valor,
        Tipo tipo
) {
}
