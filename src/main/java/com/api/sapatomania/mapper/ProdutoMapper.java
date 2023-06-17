package com.api.sapatomania.mapper;
import com.api.sapatomania.dto.ProdutoDTO;
import com.api.sapatomania.models.Produto;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoMapper {
    public static ProdutoDTO toDTO(Produto produto) {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produto.getId());
        produtoDTO.setCodigo(produto.getCodigo());
        produtoDTO.setDescricao(produto.getDescricao());
        produtoDTO.setPreco(produto.getPreco());
        produtoDTO.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        return produtoDTO;
    }

    public static List<ProdutoDTO> toDTOList(List<Produto> produtos) {
        return produtos.stream()
                .map(ProdutoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static Produto toEntity(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setId(produtoDTO.getId());
        produto.setCodigo(produtoDTO.getCodigo());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        produto.setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());
        return produto;
    }
}

