package Gers_Garage.service;

import Gers_Garage.models.Client;
import Gers_Garage.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAllClients() {
        return clientRepository.findAllClients();
    }

    public Client findClientByEmail(String email) {
        return clientRepository.findClientByEmail(email);
    }

    public List<Client> findClientById(Integer clientId) {
        return clientRepository.findClientById(clientId);
    }

    public List<Client> findClientsByFirstName(String firstName) {
        return clientRepository.findClientsByFirstName(firstName); }

    public List<Client> findClientsByLastName(String lastName) {
        return clientRepository.findClientsByLastName(lastName); }

//    public void deleteClientById(Integer clientId) {
//        clientRepository.deleteClientById(clientId);
//    }

//    public void deleteClientByEmail(String email) {
//        clientRepository.deleteClientByEmail(email); }

    /*@Transactional
    public boolean updateClientByEmail(String email, Client updatedClient) {
        Client existingClient = clientRepository.findClientByEmail(email);

        if (existingClient != null) {
            existingClient.setFirst_name(updatedClient.getFirst_name());
            existingClient.setLast_name(updatedClient.getLast_name());
            existingClient.setId_client(updatedClient.getId_client());
            existingClient.setEmail(updatedClient.getEmail());
            existingClient.setPassword(updatedClient.getPassword());
            existingClient.setGender(updatedClient.getGender());
            existingClient.setPhone_number(updatedClient.getPhone_number());
            existingClient.setDob(updatedClient.getDob());

            clientRepository.save(existingClient);
            return true;
        } else {
            return false;
        }
    }*/

}
