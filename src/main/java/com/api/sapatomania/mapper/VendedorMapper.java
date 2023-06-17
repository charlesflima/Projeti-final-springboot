package com.api.sapatomania.mapper;

import com.api.sapatomania.dto.VendedorDTO;
import com.api.sapatomania.models.Vendedor;

import java.util.List;
import java.util.stream.Collectors;

public class VendedorMapper {
    public static VendedorDTO toDTO(Vendedor vendedor) {
        VendedorDTO vendedorDTO = new VendedorDTO();
        vendedorDTO.setId(vendedor.getId());
        vendedorDTO.setMatricula(vendedor.getMatricula());
        vendedorDTO.setNome(vendedor.getNome());
        vendedorDTO.setEndereco(vendedor.getEndereco());
        vendedorDTO.setTelefone(vendedor.getTelefone());
        vendedorDTO.setSalarioBase(vendedor.getSalarioBase());
        vendedorDTO.setCpf(vendedor.getCpf());
        return vendedorDTO;
    }

    public static List<VendedorDTO> toDTOList(List<Vendedor> vendedores) {
        return vendedores.stream()
                .map(VendedorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static Vendedor toEntity(VendedorDTO vendedorDTO) {
        Vendedor vendedor = new Vendedor();
        vendedor.setId(vendedorDTO.getId());
        vendedor.setMatricula(vendedorDTO.getMatricula());
        vendedor.setNome(vendedorDTO.getNome());
        vendedor.setEndereco(vendedorDTO.getEndereco());
        vendedor.setTelefone(vendedorDTO.getTelefone());
        vendedor.setSalarioBase(vendedorDTO.getSalarioBase());
        vendedor.setCpf(vendedorDTO.getCpf());
        return vendedor;
    }
}
