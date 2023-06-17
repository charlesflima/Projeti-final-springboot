package com.api.sapatomania.services;

import com.api.sapatomania.dto.ProdutoDTO;
import com.api.sapatomania.exception.ResourceNotFoundException;
import com.api.sapatomania.mapper.ProdutoMapper;
import com.api.sapatomania.models.Produto;
import com.api.sapatomania.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoDTO> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return ProdutoMapper.toDTOList(produtos);
    }

    public ProdutoDTO obterProduto(Long id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        Produto produto = produtoOptional.orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
        return ProdutoMapper.toDTO(produto);
    }

    public ProdutoDTO criarProduto(ProdutoDTO produtoDTO) {
        Produto produto = ProdutoMapper.toEntity(produtoDTO);
        produto = produtoRepository.save(produto);
        return ProdutoMapper.toDTO(produto);
    }

    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        Produto produto = produtoOptional.orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        produto.setCodigo(produtoDTO.getCodigo());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        produto.setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());

        produto = produtoRepository.save(produto);
        return ProdutoMapper.toDTO(produto);
    }
    public void excluirProduto(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }
        produtoRepository.deleteById(id);
    }
    // Outros métodos, se necessário
}






