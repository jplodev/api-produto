package com.jpdev.apiproduto.controller;

import com.jpdev.apiproduto.business.ProdutoService;
import com.jpdev.apiproduto.business.dto.ProdutoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoDTO> salvaProduto(@RequestBody ProdutoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvaProduto(dto));
    }
}
