package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.WishlistRequestDTO;
import Demo.Ecommerce.DTO.WishlistResponseDTO;

import java.util.List;
import java.util.UUID;

public interface WishlistService {
    WishlistResponseDTO create(WishlistRequestDTO request);
    WishlistResponseDTO getById(UUID id);
    List<WishlistResponseDTO> getAll();
    WishlistResponseDTO update(UUID id, WishlistRequestDTO request);
    void delete(UUID id);
}
