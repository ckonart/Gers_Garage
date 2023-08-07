package Gers_Garage.mapper;

import Gers_Garage.dto.ClientDTO;
import Gers_Garage.models.Client;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ClientMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static ClientDTO toDTO(Client client) {
        return modelMapper.map(client, ClientDTO.class);
    }

    public static Client toEntity(ClientDTO clientDTO) {
        return modelMapper.map(clientDTO, Client.class);
    }

    public List<ClientDTO> toDTOList(List<Client> clientsList) {
        return clientsList.stream()
                .map(entity -> toDTO(entity))
                .collect(Collectors.toList());
    }

    public List<Client> toEntityList(List<ClientDTO> clientDTOS) {
        return clientDTOS.stream()
                .map(dto -> toEntity(dto))
                .collect(Collectors.toList());
    }
}
