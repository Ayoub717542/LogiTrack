package org.example.logitrack.service.interfaces;

import org.example.logitrack.DTO.ClientRequestDTO;
import org.example.logitrack.DTO.ClientResponceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientInterface {
    ClientResponceDTO saveClient(ClientRequestDTO clientRequestDTO);
    Page<ClientResponceDTO> getAllClients(Pageable pageable);
    ClientResponceDTO getClientById(Integer id);
    Boolean deleteClient(Integer id);

}
