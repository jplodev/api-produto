package com.jpdev.apiproduto.infrastructure.repository;

import com.jpdev.apiproduto.infrastructure.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
