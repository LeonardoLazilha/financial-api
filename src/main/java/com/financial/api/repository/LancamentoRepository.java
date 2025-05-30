package com.financial.api.repository;

import com.financial.api.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
    Optional<Lancamento> findByIdAndUserId(Long id, Long userId);
}
