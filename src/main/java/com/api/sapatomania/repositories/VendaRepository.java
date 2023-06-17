package com.api.sapatomania.repositories;
import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.api.sapatomania.models.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    // Método personalizado para buscar vendas por data
    List<Venda> findByData(Date data);

    // Consulta personalizada usando a anotação @Query
    @Query("SELECT v FROM Venda v WHERE v.valorTotal > :valor")
    List<Venda> findByValorTotalGreaterThan(double valor);
}
