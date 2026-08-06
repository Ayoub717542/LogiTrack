package org.example.logitrack.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.example.logitrack.DTO.CommandeRequestDTO;
import org.example.logitrack.DTO.CommandeResponceDTO;
import org.example.logitrack.Enums.Statuts;
import org.example.logitrack.mapper.CommandeMapper;
import org.example.logitrack.model.Commande;
import org.example.logitrack.repository.ClientRepository;
import org.example.logitrack.repository.CommandeRepository;
import org.example.logitrack.service.interfaces.CommandeInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandeService implements CommandeInterface {

    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;
    private final CommandeMapper commandeMapper;

    public CommandeResponceDTO saveCommande(CommandeRequestDTO commandeRequestDTO) {
        Commande commande = commandeMapper.toEntity(commandeRequestDTO);
        return commandeMapper.toDto(commandeRepository.save(commande));
    }

    public Page<CommandeResponceDTO> getAllCommandes(Pageable pageable) {
        return commandeRepository.findAll(pageable)
                .map(commande -> commandeMapper.toDto(commande));
    }

    public CommandeResponceDTO getCommandeById(Integer id) {
        Commande commande = commandeRepository.findById(id).orElseThrow(() -> new RuntimeException("No commande found with id " + id));
        return commandeMapper.toDto(commande);
    }

    public Page<CommandeResponceDTO> getCommandesByClient(Integer clientId, Pageable pageable) {
        clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("No client found with id " + clientId));
        return commandeRepository.findById(clientId, pageable)
                .map(commande -> commandeMapper.toDto(commande));
    }

    public Boolean deleteCommande(Integer id) {
        commandeRepository.findById(id).orElseThrow(() -> new RuntimeException("No commande found with id " + id));
        commandeRepository.deleteById(id);
        return true;
    }

    public CommandeResponceDTO updateStatus(Integer id, Statuts status) {
    Commande commande = commandeRepository.findById(id).orElseThrow(()-> new RuntimeException("no command by id "+id));
    commande.setStatut(status);
    return commandeMapper.toDto(commandeRepository.save(commande));
    }

}