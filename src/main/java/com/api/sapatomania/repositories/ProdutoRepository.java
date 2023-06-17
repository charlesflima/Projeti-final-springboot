package com.api.sapatomania.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.api.sapatomania.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Método personalizado para buscar produtos por descrição
    List<Produto> findByDescricao(String descricao);

    // Método personalizado para buscar produtos por preço menor que um valor específico
    List<Produto> findByPrecoLessThan(double preco);

    // Consulta personalizada usando a anotação @Query
    @Query("SELECT p FROM Produto p WHERE p.quantidadeEstoque > 0")
    List<Produto> findAvailableProducts();
}

