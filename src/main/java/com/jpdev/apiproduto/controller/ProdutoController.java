package com.jpdev.apiproduto.controller;

import com.jpdev.apiproduto.business.ProdutoService;
import com.jpdev.apiproduto.business.dto.ProdutoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/produtos")
@Tag(name = "Produtos", description = "Cadatro de Produtos")
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    @Operation(summary = "Cadastro de Produto", description = "Cria um novo produto")
    @ApiResponse(responseCode = "201", description = "Produto criado com sucesso.")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<ProdutoDTO> salvaProduto(@RequestBody ProdutoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvaProduto(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca Produto", description = "Busca produto por id")
    @ApiResponse(responseCode = "200", description = "Produto encontrado com sucesso.")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado.")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<ProdutoDTO> buscaProdutoPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.buscaProdutoPorId(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta Produto", description = "Deleta produto por id")
    @ApiResponse(responseCode = "200", description = "Produto deletado com sucesso.")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado.")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletaProdutoPorId(@PathVariable("id") Long id){
        service.deletaProdutoPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza dados do Produto", description = "Atualiza produto por id")
    @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso.")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado.")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<ProdutoDTO> autualizaProduto(@PathVariable("id") Long id, @RequestBody ProdutoDTO dto){
        return ResponseEntity.ok(service.atualizaProduto(id, dto));
    }
}
