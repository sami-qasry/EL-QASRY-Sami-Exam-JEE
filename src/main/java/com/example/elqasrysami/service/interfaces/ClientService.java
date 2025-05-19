package com.example.elqasrysami.service.interfaces;

import com.example.elqasrysami.service.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO saveClient(ClientDTO clientDTO);
    List<ClientDTO> getAllClients();
    ClientDTO getClientById(Long id);
    void deleteClient(Long id);
}
