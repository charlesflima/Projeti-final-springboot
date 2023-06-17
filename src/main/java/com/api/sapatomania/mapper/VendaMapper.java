package com.api.sapatomania.mapper;

import com.api.sapatomania.dto.VendaDTO;
import com.api.sapatomania.models.Venda;

import java.util.List;
import java.util.stream.Collectors;

public class VendaMapper {
    public static VendaDTO toDTO(Venda venda) {
        VendaDTO vendaDTO = new VendaDTO();
        vendaDTO.setId(venda.getId());
        vendaDTO.setData(venda.getData());
        vendaDTO.setVendedor(venda.getVendedor());
        vendaDTO.setCliente(venda.getCliente());
        vendaDTO.setProdutos(venda.getProdutos());
        // Defina outros atributos conforme necessário
        return vendaDTO;
    }

    public static List<VendaDTO> toDTOList(List<Venda> vendas) {
        return vendas.stream()
                .map(VendaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static Venda toEntity(VendaDTO vendaDTO) {
        Venda venda = new Venda();
        venda.setId(vendaDTO.getId());
        venda.setData(vendaDTO.getData());
        venda.setVendedor(vendaDTO.getVendedor());
        venda.setCliente(vendaDTO.getCliente());
        venda.setProdutos(vendaDTO.getProdutos());
        // Defina outros atributos conforme necessário
        return venda;
    }
}
