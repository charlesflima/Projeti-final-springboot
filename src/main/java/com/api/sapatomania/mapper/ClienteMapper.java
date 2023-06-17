package com.api.sapatomania.mapper;

import com.api.sapatomania.dto.ClienteDTO;
import com.api.sapatomania.models.Cliente;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteMapper {
    public static ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setCpf(cliente.getCpf());
        clienteDTO.setIdentidade(cliente.getIdentidade());
        clienteDTO.setEndereco(cliente.getEndereco());
        clienteDTO.setTelefone(cliente.getTelefone());
        // Defina outros atributos conforme necessário
        return clienteDTO;
    }

    public static List<ClienteDTO> toDTOList(List<Cliente> clientes) {
        return clientes.stream()
                .map(ClienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static Cliente toEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setIdentidade(clienteDTO.getIdentidade());
        cliente.setEndereco(clienteDTO.getEndereco());
        cliente.setTelefone(clienteDTO.getTelefone());
        // Defina outros atributos conforme necessário
        return cliente;
    }
}



