package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.AddressRequestDTO;
import Demo.Ecommerce.DTO.AddressResponseDTO;

import java.util.List;
import java.util.UUID;

public interface AddressService {
    AddressResponseDTO create(AddressRequestDTO request);
    AddressResponseDTO getById(UUID id);
    List<AddressResponseDTO> getAll();
    AddressResponseDTO update(UUID id, AddressRequestDTO request);
    void delete(UUID id);
}
