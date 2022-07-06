package com.apiproject.service;

import com.apiproject.data.Client;
import com.apiproject.data.payloads.ClientRequest;
import com.apiproject.data.payloads.MessageResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Component
public interface ClientService {
    MessageResponse createClient(ClientRequest clientRequest) throws ParseException;
    Optional<Client> updateClient(Integer clientId, ClientRequest clientRequest) throws ParseException;
    void deleteClient(Integer clientId);
    Client getASingleClient(Integer clientId);
    List<Client> getAllClients();
}