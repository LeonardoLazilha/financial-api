package com.financial.api.service;

import com.financial.api.dto.LancamentoRequestDTO;
import com.financial.api.dto.LancamentoResponseDTO;
import com.financial.api.model.Lancamento;
import com.financial.api.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    public LancamentoResponseDTO criar (LancamentoRequestDTO dto){
        Lancamento lancamento = new Lancamento(dto);
        Lancamento salvo = repository.save(lancamento);
        return new LancamentoResponseDTO(salvo);
    }

}
