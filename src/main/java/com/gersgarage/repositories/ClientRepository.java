package com.gersgarage.repositories;

import com.gersgarage.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT c FROM Client c")
    List<Client> findAllClients();

    @Query("SELECT c FROM Client c WHERE c.email = :email")
    Client findClientByEmail(@Param("email") String email);

    @Query("SELECT c FROM Client c WHERE c.id_client = :clientId")
    List<Client> findClientById(@Param("clientId") Integer clientId);

    @Query("SELECT c FROM Client c WHERE c.first_name = :firstName")
    List<Client> findClientsByFirstName(@Param("firstName") String firstName);

    @Query("SELECT c FROM Client c WHERE c.last_name = :lastName")
    List<Client> findClientsByLastName(@Param("lastName") String lastName);

    @Modifying
    @Query("DELETE FROM Client c WHERE c.id_client = :clientId")
    void deleteClientById(@Param("clientId") Integer clientId);

    @Modifying
    @Query("DELETE FROM Client c WHERE c.email = :email")
    void deleteClientByEmail(@Param("email") String email);

}
