package com.apiproject.web;

import com.apiproject.data.model.Client;
import com.apiproject.data.payloads.ClientRequest;
import com.apiproject.data.payloads.MessageResponse;
import com.apiproject.service.ClientService;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

//@RestController
@RequestMapping("/clients")
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
}
)
@Controller
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping()
    public ResponseEntity<List<Client>> getAllClients () {

        List<Client> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById (@PathVariable("id") Integer id) {
        Client client = clientService.getASingleClient(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<MessageResponse> addClient(@RequestBody ClientRequest client) throws ParseException {
        MessageResponse newClient = clientService.createClient(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public Optional<Client> updateClient(@PathVariable Integer id, @RequestBody ClientRequest client) throws ParseException {
        return clientService.updateClient(id, client);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable("id") Integer id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}