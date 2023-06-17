package com.api.sapatomania.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.api.sapatomania.models.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
    // Método personalizado para buscar vendedores por nome
    List<Vendedor> findByNome(String nome);

    // Método personalizado para buscar vendedores por cpf
    Vendedor findByCpf(String cpf);

    // Consulta personalizada usando a anotação @Query
    @Query("SELECT v FROM Vendedor v WHERE v.endereco = :endereco")
    List<Vendedor> findByEndereco(String endereco);
}

