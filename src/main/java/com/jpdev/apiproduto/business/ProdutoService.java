package com.jpdev.apiproduto.business;

import com.jpdev.apiproduto.business.converter.ProdutoConverter;
import com.jpdev.apiproduto.business.dto.ProdutoDTO;
import com.jpdev.apiproduto.infrastructure.entity.Produto;
import com.jpdev.apiproduto.infrastructure.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoConverter converter;

    public ProdutoDTO salvaProduto(ProdutoDTO dto){
        Produto entity = converter.paraProduto(dto);
        return converter.paraProdutoDTO(repository.save(entity));
    }
}
