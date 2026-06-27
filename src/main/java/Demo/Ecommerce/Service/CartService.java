package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.CartRequestDTO;
import Demo.Ecommerce.DTO.CartResponseDTO;

import java.util.List;
import java.util.UUID;

public interface CartService {
    CartResponseDTO create(CartRequestDTO request);
    CartResponseDTO getById(UUID id);
    List<CartResponseDTO> getAll();
    CartResponseDTO update(UUID id, CartRequestDTO request);
    void delete(UUID id);
}
