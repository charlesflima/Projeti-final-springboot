package com.api.sapatomania.dto;
import java.math.BigDecimal;


public class VendedorDTO {
    private Long id;
    private String matricula;
    private String nome;
    private String endereco;
    private String telefone;
    private Double salarioBase;
    private String cpf;

    // Construtor padrão
    public VendedorDTO() {
    }

    // Construtor com todos os atributos
    public VendedorDTO(Long id, String matricula, String nome, String endereco, String telefone, Double salarioBase, String cpf) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.salarioBase = salarioBase;
        this.cpf = cpf;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}


