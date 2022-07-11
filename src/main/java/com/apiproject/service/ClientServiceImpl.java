package com.apiproject.service;

import com.apiproject.Utils.Utils;
import com.apiproject.data.model.Client;
import com.apiproject.data.payloads.ClientRequest;
import com.apiproject.data.payloads.MessageResponse;
import com.apiproject.data.repository.ClientRepository;
import com.apiproject.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;
    @Override
    public MessageResponse createClient(ClientRequest clientRequest) throws ParseException {
        Client newClient = new Client();
        newClient.setNom(clientRequest.getNom());
        newClient.setPrénom(clientRequest.getPrénom());
        newClient.setDate(Utils.convertStringToDate(clientRequest.getDate()));
        newClient.setProduit(clientRequest.getProduit());
        newClient.setStatut(clientRequest.getStatut());
        newClient.setMontant(clientRequest.getMontant());
        clientRepository.save(newClient);
        return new MessageResponse("New Client created successfully");

    }

    @Override
    public Optional<Client> updateClient(Integer clientId, ClientRequest clientRequest) throws ResourceNotFoundException, ParseException {
        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isEmpty()){
            throw new ResourceNotFoundException("Client", "id", clientId);
        }
        else {
            client.get().setNom(clientRequest.getNom());
            client.get().setPrénom(clientRequest.getPrénom());
            client.get().setDate(Utils.convertStringToDate(clientRequest.getDate()));
            client.get().setProduit(clientRequest.getProduit());
            client.get().setStatut(clientRequest.getStatut());
            client.get().setMontant(clientRequest.getMontant());
        }
        clientRepository.save(client.get());
        return client;
    }

    @Override
    public void deleteClient(Integer clientId) {
        if (clientRepository.getReferenceById(clientId).getId() == clientId){
            clientRepository.deleteById(clientId);
        }
        else throw new ResourceNotFoundException("Client", "id", clientId);
    }

    @Override
    public Client getASingleClient(Integer clientId) throws ResourceNotFoundException{
        return clientRepository.findById(clientId).orElseThrow(() -> new ResourceNotFoundException("Client", "id", clientId));
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
