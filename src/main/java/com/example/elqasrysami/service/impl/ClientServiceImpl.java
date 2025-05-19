package com.example.elqasrysami.service.impl;

import com.example.elqasrysami.dao.entities.Client;
import com.example.elqasrysami.dao.repositories.ClientRepository;
import com.example.elqasrysami.service.dto.ClientDTO;
import com.example.elqasrysami.service.interfaces.ClientService;
import com.example.elqasrysami.service.mapper.ClientMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = ClientMapper.toEntity(clientDTO);
        return ClientMapper.toDTO(clientRepository.save(client));
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(ClientMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClientById(Long id) {
        return clientRepository.findById(id)
                .map(ClientMapper::toDTO)
                .orElse(null);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
