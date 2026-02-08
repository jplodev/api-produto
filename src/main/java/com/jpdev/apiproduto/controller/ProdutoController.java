package com.jpdev.apiproduto.controller;

import com.jpdev.apiproduto.business.ProdutoService;
import com.jpdev.apiproduto.business.dto.ProdutoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoDTO> salvaProduto(@RequestBody ProdutoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvaProduto(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscaProdutoPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.buscaProdutoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaProdutoPorId(@PathVariable("id") Long id){
        service.deletaProdutoPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> autualizaProduto(@PathVariable("id") Long id, @RequestBody ProdutoDTO dto){
        return ResponseEntity.ok(service.atualizaProduto(id, dto));
    }
}
