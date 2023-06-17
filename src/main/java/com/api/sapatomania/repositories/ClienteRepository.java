package com.api.sapatomania.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.api.sapatomania.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Método personalizado para buscar clientes por nome
    List<Cliente> findByNome(String nome);

    // Método personalizado para buscar clientes por cpf
    Cliente findByCpf(String cpf);

    // Consulta personalizada usando a anotação @Query
    @Query("SELECT c FROM Cliente c WHERE c.endereco = :endereco")
    List<Cliente> findByEndereco(String endereco);
}
