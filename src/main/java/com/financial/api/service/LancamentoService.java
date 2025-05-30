package com.financial.api.service;

import com.financial.api.dto.LancamentoRequestDTO;
import com.financial.api.dto.LancamentoResponseDTO;
import com.financial.api.dto.LancamentoUpdateDTO;
import com.financial.api.exception.NotFoundException;
import com.financial.api.model.Lancamento;
import com.financial.api.model.User;
import com.financial.api.repository.LancamentoRepository;
import com.financial.api.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public LancamentoResponseDTO criar (LancamentoRequestDTO dto){
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new NotFoundException("User não encontrado"));

        Lancamento lancamento = new Lancamento(dto);
        lancamento.setUser(user);
        Lancamento salvo = repository.save(lancamento);

        return new LancamentoResponseDTO(salvo);
    }

    public void delete (Long id){
        if (!repository.existsById(id)){
            throw new NotFoundException("Lançamento não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
    }
    public List<LancamentoResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(LancamentoResponseDTO::new)
                .toList();
    }

    @Transactional
    public LancamentoResponseDTO atualizar(Long id, Long userId, LancamentoUpdateDTO dto){
        Lancamento lancamento = repository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new NotFoundException("Lançamento não encontrado com o ID: " + id));

        lancamento.setDescricao(dto.descricao());
        lancamento.setValor(dto.valor());
        lancamento.setTipo(dto.tipo());
        lancamento.setData(LocalDateTime.now());

        return new LancamentoResponseDTO(lancamento);
    }

}
