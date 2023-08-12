package com.gersgarage.controllers;

import com.gersgarage.models.Client;
import com.gersgarage.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.findAllClients();
    }

    @GetMapping("/email/{email}")
    public Client getClientByEmail(@PathVariable String email) {
        return clientService.findClientByEmail(email);
    }

    @GetMapping("/id/{clientId}")
    public List<Client> getClientById(@PathVariable Integer clientId) {
        return clientService.findClientById(clientId);
    }

    @GetMapping("/first-name/{firstName}")
    public ResponseEntity<List<Client>> getClientsByFirstName(@PathVariable String firstName) {
        List<Client> clients = clientService.findClientsByFirstName(firstName);

        if (clients.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        } else {
            return ResponseEntity.ok(clients); // 200 OK with the list of clients
        }
    }

    @GetMapping("last-name/{lastName}")
    public List<Client> getClientsByLastName(@PathVariable String lastName) {
        return clientService.findClientsByLastName(lastName);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deleteClient(@PathVariable Integer clientId) {
        clientService.deleteClientById(clientId);
        return ResponseEntity.ok("Client deleted successfully");
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteClient(@PathVariable String email) {
        clientService.deleteClientByEmail(email);
        return ResponseEntity.ok("Client deleted successfully");
    }

    @PutMapping("/email/{email}")
    public ResponseEntity<String> updateClientByEmail(@PathVariable String email, @RequestBody Client updatedClient) {
        boolean updated = clientService.updateClientByEmail(email, updatedClient);

        if (updated) {
            return ResponseEntity.ok("Client updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
