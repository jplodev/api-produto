package com.jpdev.apiproduto.business;

import com.jpdev.apiproduto.business.converter.ProdutoConverter;
import com.jpdev.apiproduto.business.dto.ProdutoDTO;
import com.jpdev.apiproduto.infrastructure.entity.Produto;
import com.jpdev.apiproduto.infrastructure.exceptions.ResourceNotFoundException;
import com.jpdev.apiproduto.infrastructure.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
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

    public ProdutoDTO buscaProdutoPorId(Long id){
        try{
            return converter.paraProdutoDTO(repository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException("Id não encontrado" + id)));
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado", e.getCause());
        }
    }

    @Transactional
    public void deletaProdutoPorId(Long id){
        try{
            repository.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado", e.getCause());
        }
    }


    public ProdutoDTO atualizaProduto(Long id, ProdutoDTO dto) {
        Produto entity = repository.getReferenceById(id);
        entity = converter.updateProduto(dto, entity);
        return converter.paraProdutoDTO(repository.save(entity));
    }
}
