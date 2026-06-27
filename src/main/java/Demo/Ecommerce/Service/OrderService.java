package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.OrderRequestDTO;
import Demo.Ecommerce.DTO.OrderResponseDTO;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    OrderResponseDTO create(OrderRequestDTO request);
    OrderResponseDTO getById(UUID id);
    List<OrderResponseDTO> getAll();
    OrderResponseDTO update(UUID id, OrderRequestDTO request);
    void delete(UUID id);
}
