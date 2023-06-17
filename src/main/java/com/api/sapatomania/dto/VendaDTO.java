package com.api.sapatomania.dto;

import com.api.sapatomania.models.Vendedor;
import com.api.sapatomania.models.Cliente;
import com.api.sapatomania.models.Produto;

import java.util.List;

public class VendaDTO {
    private Long id;
    private String data;
    private Vendedor vendedor;
    private Cliente cliente;
    private List<Produto> produtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    // Outros métodos, se necessário
}
