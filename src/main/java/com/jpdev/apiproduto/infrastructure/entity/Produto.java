package com.jpdev.apiproduto.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", length = 100)
    private String nome;
    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;
    @Column(name = "preco")
    private Double preco;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categorias;
}
