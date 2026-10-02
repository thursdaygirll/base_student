package com.base_student.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.base_student.dto.ClientDto;
import com.base_student.model.ClientModel;
import com.base_student.respository.ClientRepository;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream().map(ClientModel::toDto).toList();
    }

    public ClientDto findById(Long id) {
        return clientRepository.findById(id)
                .map(ClientModel::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Client not found with id: " + id));
    }

    public ClientDto save(ClientDto dto) {
        ClientModel saved = clientRepository.save(dto.toModel());
        return saved.toDto();
    }

    public ClientDto update(Long id, ClientDto dto) {
        clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Client not found with id: " + id));
        dto.setId(id);
        ClientModel updated = clientRepository.save(dto.toModel());
        return updated.toDto();
    }

    public void delete(Long id) {
        clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Client not found with id: " + id));
        clientRepository.deleteById(id);
    }
}
