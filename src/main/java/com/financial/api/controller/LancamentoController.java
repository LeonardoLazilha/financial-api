package com.financial.api.controller;

import com.financial.api.dto.LancamentoRequestDTO;
import com.financial.api.dto.LancamentoResponseDTO;
import com.financial.api.dto.LancamentoUpdateDTO;
import com.financial.api.service.LancamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lancamento")
public class LancamentoController {

    @Autowired
    private LancamentoService service;

    @PostMapping
    public ResponseEntity<LancamentoResponseDTO> criar (@RequestBody @Valid LancamentoRequestDTO dto){
        LancamentoResponseDTO response = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<LancamentoResponseDTO>> listar (){
        List<LancamentoResponseDTO> lista = service.listar();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LancamentoResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid LancamentoUpdateDTO dto){
        LancamentoResponseDTO atualizado = service.atualizar(id, dto.userId(), dto);
        return ResponseEntity.ok(atualizado);
    }

}
