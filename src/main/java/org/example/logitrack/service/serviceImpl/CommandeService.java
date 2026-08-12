package org.example.logitrack.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.example.logitrack.DTO.ClientRequestDTO;
import org.example.logitrack.DTO.ClientResponceDTO;
import org.example.logitrack.DTO.CommandeRequestDTO;
import org.example.logitrack.DTO.CommandeResponceDTO;
import org.example.logitrack.Enums.Statuts;
import org.example.logitrack.mapper.CommandeMapper;
import org.example.logitrack.model.Client;
import org.example.logitrack.model.Commande;
import org.example.logitrack.repository.ClientRepository;
import org.example.logitrack.repository.CommandeRepository;
import org.example.logitrack.service.interfaces.CommandeInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandeService implements CommandeInterface {

    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;
    private final CommandeMapper commandeMapper;

    public CommandeResponceDTO saveCommande(CommandeRequestDTO commandeRequestDTO) {
        Commande commande = commandeMapper.toEntity(commandeRequestDTO);
        Client client = clientRepository.findById(commandeRequestDTO.getClientId()).orElseThrow(() -> new RuntimeException("client not found"));
        commande.setClient(client);
        return commandeMapper.toDto(commandeRepository.save(commande));
    }

    public CommandeResponceDTO updateCommande(int id, CommandeRequestDTO commandeRequestDTO){
        Commande commande = commandeRepository.findById(id).orElseThrow(()-> new RuntimeException("commande not found"));
        commande.setDateCommande(commandeRequestDTO.getDateCommande());
        commande.setStatut(commandeRequestDTO.getStatut());
        Client client = clientRepository.findById(commandeRequestDTO.getClientId()).orElseThrow(()-> new RuntimeException("Client not found"));
        commande.setClient(client);
        Commande updatedClient = commandeRepository.save(commande);
        return commandeMapper.toDto(updatedClient);
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

    public long countPending() {
        return commandeRepository.countByStatut(Statuts.PENDING);
    }
    public long countShipped() {
        return commandeRepository.countByStatut(Statuts.SHIPPED);
    }
    public long countDelivered() {
        return commandeRepository.countByStatut(Statuts.DELIVERED);
    }
    public long countCanceled() {
        return commandeRepository.countByStatut(Statuts.CANCELLED);
    }
    public long countCommandes(){
        return commandeRepository.count();
    }

    public Page<CommandeResponceDTO> RecentCommandes(Pageable pageable){
        return commandeRepository.findRecentCommandes(pageable)
                .map(commandeMapper::toDto);
    }


}