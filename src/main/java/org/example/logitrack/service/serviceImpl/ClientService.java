package org.example.logitrack.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.example.logitrack.DTO.ClientRequestDTO;
import org.example.logitrack.DTO.ClientResponceDTO;
import org.example.logitrack.mapper.ClientMapper;
import org.example.logitrack.model.Client;
import org.example.logitrack.repository.ClientRepository;
import org.example.logitrack.service.interfaces.ClientInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ClientService implements ClientInterface {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;


    public ClientResponceDTO saveClient(ClientRequestDTO clientRequestDTO) {
        if(clientRepository.findByEmail(clientRequestDTO.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists!");
        }
        Client client = new Client();
        client.setEmail(clientRequestDTO.getEmail());
        client.setNom(clientRequestDTO.getNom());
        client.setTelephone(clientRequestDTO.getTelephone());

        return clientMapper.toDto(clientRepository.save(client));
    }

    public Page<ClientResponceDTO> getAllClients(Pageable pageable) {
       return clientRepository.findAll(pageable)
        .map(client -> clientMapper.toDto(client));
    }

    public ClientResponceDTO getClientById(Integer id) {
        Client client =clientRepository.findById(id).orElseThrow(()->new RuntimeException("no client by id "+id));
        return clientMapper.toDto(client);
    }

    public Boolean deleteClient(Integer id) {
        Client client = clientRepository.findById(id).orElseThrow(()-> new RuntimeException("no client by id "+id));
        clientRepository.deleteById(id);
        return true;
    }
}