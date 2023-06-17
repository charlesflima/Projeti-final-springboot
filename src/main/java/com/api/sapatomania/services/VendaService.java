package com.api.sapatomania.services;

import com.api.sapatomania.dto.VendaDTO;
import com.api.sapatomania.exception.ResourceNotFoundException;
import com.api.sapatomania.mapper.VendaMapper;
import com.api.sapatomania.models.Venda;
import com.api.sapatomania.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {
    private final VendaRepository vendaRepository;

    @Autowired
    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public List<VendaDTO> listarVendas() {
        List<Venda> vendas = vendaRepository.findAll();
        return VendaMapper.toDTOList(vendas);
    }

    public VendaDTO obterVenda(Long id) {
        Optional<Venda> vendaOptional = vendaRepository.findById(id);
        Venda venda = vendaOptional.orElseThrow(() -> new ResourceNotFoundException("Venda não encontrada"));
        return VendaMapper.toDTO(venda);
    }

    public VendaDTO criarVenda(VendaDTO vendaDTO) {
        Venda venda = VendaMapper.toEntity(vendaDTO);
        venda = vendaRepository.save(venda);
        return VendaMapper.toDTO(venda);
    }

    public VendaDTO atualizarVenda(Long id, VendaDTO vendaDTO) {
        Optional<Venda> vendaOptional = vendaRepository.findById(id);
        Venda venda = vendaOptional.orElseThrow(() -> new ResourceNotFoundException("Venda não encontrada"));

        venda.setData(vendaDTO.getData());
        venda.setVendedor(vendaDTO.getVendedor());
        venda.setCliente(vendaDTO.getCliente());
        venda.setProdutos(vendaDTO.getProdutos());

        venda = vendaRepository.save(venda);
        return VendaMapper.toDTO(venda);
    }

    public void excluirVenda(Long id) {
        Optional<Venda> vendaOptional = vendaRepository.findById(id);
        Venda venda = vendaOptional.orElseThrow(() -> new ResourceNotFoundException("Venda não encontrada"));

        vendaRepository.delete(venda);
    }
}




