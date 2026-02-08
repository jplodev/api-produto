package com.jpdev.apiproduto.business.converter;

import com.jpdev.apiproduto.business.dto.CategoriaDTO;
import com.jpdev.apiproduto.business.dto.ProdutoDTO;
import com.jpdev.apiproduto.infrastructure.entity.Categoria;
import com.jpdev.apiproduto.infrastructure.entity.Produto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoConverter {

    public Produto paraProduto(ProdutoDTO dto){
        return Produto.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .preco(dto.getPreco())
                .categorias(paraListaCategoria(dto.getCategorias()))
                .build();
    }

    public List<Categoria> paraListaCategoria(List<CategoriaDTO> categoriaDTOS){
        return categoriaDTOS.stream().map(this::paraCategoria).toList();
    }

    public Categoria paraCategoria(CategoriaDTO dto){
        return Categoria.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .build();
    }

    public ProdutoDTO paraProdutoDTO(Produto entity){
        return ProdutoDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .preco(entity.getPreco())
                .categorias(paraListaCategoriaDTO(entity.getCategorias()))
                .build();
    }

    public List<CategoriaDTO> paraListaCategoriaDTO(List<Categoria> categorias){
        return categorias.stream().map(this::paraCategoriaDTO).toList();
    }

    public CategoriaDTO paraCategoriaDTO(Categoria categoria){
        return CategoriaDTO.builder()
                .id(categoria.getId())
                .nome(categoria.getNome())
                .build();
    }

    public Produto updateProduto(ProdutoDTO dto, Produto entity){
        return Produto.builder()
                .id(entity.getId())
                .nome(dto.getNome() != null ? dto.getNome() : entity.getNome())
                .descricao(dto.getDescricao() != null ? dto.getDescricao() : entity.getDescricao())
                .preco(dto.getPreco() != null ? dto.getPreco() : entity.getPreco())
                .categorias(entity.getCategorias())
                .build();
    }
}
