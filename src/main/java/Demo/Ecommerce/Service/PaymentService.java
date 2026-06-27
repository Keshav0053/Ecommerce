package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.PaymentRequestDTO;
import Demo.Ecommerce.DTO.PaymentResponseDTO;

import java.util.List;
import java.util.UUID;

public interface PaymentService {
    PaymentResponseDTO create(PaymentRequestDTO request);
    PaymentResponseDTO getById(UUID id);
    List<PaymentResponseDTO> getAll();
    PaymentResponseDTO update(UUID id, PaymentRequestDTO request);
    void delete(UUID id);
}
