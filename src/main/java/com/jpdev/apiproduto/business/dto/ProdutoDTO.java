package com.jpdev.apiproduto.business.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private List<CategoriaDTO> categorias;
}
