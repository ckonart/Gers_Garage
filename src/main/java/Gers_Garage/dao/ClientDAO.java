package Gers_Garage.dao;

import Gers_Garage.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDAO extends JpaRepository<Client, Integer> {

}
