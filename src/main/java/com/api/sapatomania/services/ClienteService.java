package com.api.sapatomania.services;


import com.api.sapatomania.dto.ClienteDTO;
import com.api.sapatomania.exception.ResourceNotFoundException;
import com.api.sapatomania.mapper.ClienteMapper;
import com.api.sapatomania.models.Cliente;
import com.api.sapatomania.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteDTO> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ClienteMapper.toDTOList(clientes);
    }

    public ClienteDTO obterCliente(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        Cliente cliente = clienteOptional.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        return ClienteMapper.toDTO(cliente);
    }

    public ClienteDTO criarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = ClienteMapper.toEntity(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return ClienteMapper.toDTO(cliente);
    }

    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        Cliente cliente = clienteOptional.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        cliente.setEndereco(clienteDTO.getEndereco());
        cliente.setTelefone(clienteDTO.getTelefone());

        cliente = clienteRepository.save(cliente);
        return ClienteMapper.toDTO(cliente);
    }

    public void excluirCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }
}
