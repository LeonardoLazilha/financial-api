package com.financial.api.dto;

import com.financial.api.model.Lancamento;
import com.financial.api.model.Tipo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record LancamentoResponseDTO(
        Long id,
        String descricao,
        BigDecimal valor,
        LocalDateTime data,
        Tipo tipo
) {
    public LancamentoResponseDTO(Lancamento lancamento){
        this(
                lancamento.getId(),
                lancamento.getDescricao(),
                lancamento.getValor(),
                lancamento.getData(),
                lancamento.getTipo()
        );
    }
}
