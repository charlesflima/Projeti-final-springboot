package com.api.sapatomania.services;


import com.api.sapatomania.dto.VendedorDTO;
import com.api.sapatomania.exception.ResourceNotFoundException;
import com.api.sapatomania.mapper.VendedorMapper;
import com.api.sapatomania.models.Vendedor;
import com.api.sapatomania.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {
    private final VendedorRepository vendedorRepository;

    @Autowired
    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    public List<VendedorDTO> listarVendedores() {
        List<Vendedor> vendedores = vendedorRepository.findAll();
        return VendedorMapper.toDTOList(vendedores);
    }

    public VendedorDTO obterVendedor(Long id) {
        Optional<Vendedor> vendedorOptional = vendedorRepository.findById(id);
        Vendedor vendedor = vendedorOptional.orElseThrow(() -> new ResourceNotFoundException("Vendedor não encontrado"));
        return VendedorMapper.toDTO(vendedor);
    }

    public VendedorDTO criarVendedor(VendedorDTO vendedorDTO) {
        Vendedor vendedor = VendedorMapper.toEntity(vendedorDTO);
        vendedor = vendedorRepository.save(vendedor);
        return VendedorMapper.toDTO(vendedor);
    }

    public VendedorDTO atualizarVendedor(Long id, VendedorDTO vendedorDTO) {
        Optional<Vendedor> vendedorOptional = vendedorRepository.findById(id);
        Vendedor vendedor = vendedorOptional.orElseThrow(() -> new ResourceNotFoundException("Vendedor não encontrado"));

        vendedor.setMatricula(vendedorDTO.getMatricula());
        vendedor.setNome(vendedorDTO.getNome());
        vendedor.setEndereco(vendedorDTO.getEndereco());
        vendedor.setTelefone(vendedorDTO.getTelefone());
        vendedor.setSalarioBase(vendedorDTO.getSalarioBase());
        vendedor.setCpf(vendedorDTO.getCpf());

        vendedor = vendedorRepository.save(vendedor);
        return VendedorMapper.toDTO(vendedor);
    }

    public void excluirVendedor(Long id) {
        vendedorRepository.deleteById(id);
    }
}





