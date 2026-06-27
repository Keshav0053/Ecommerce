package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.CartItemRequestDTO;
import Demo.Ecommerce.DTO.CartItemResponseDTO;

import java.util.List;
import java.util.UUID;

public interface CartItemService {
    CartItemResponseDTO create(CartItemRequestDTO request);
    CartItemResponseDTO getById(UUID id);
    List<CartItemResponseDTO> getAll();
    CartItemResponseDTO update(UUID id, CartItemRequestDTO request);
    void delete(UUID id);
}
