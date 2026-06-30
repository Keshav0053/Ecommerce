package Demo.Ecommerce.Controller;

import Demo.Ecommerce.DTO.PaymentRequestDTO;
import Demo.Ecommerce.DTO.PaymentResponseDTO;
import Demo.Ecommerce.Service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    @Autowired
    private  PaymentService service;
    @PostMapping("/createPayment")
    public PaymentResponseDTO createPayment(@RequestBody PaymentRequestDTO request) {
        return service.create(request);
    }
    @GetMapping("/getPaymentById/{id}")
    public PaymentResponseDTO getPaymentById(@PathVariable UUID id) {
        return service.getById(id);
    }
    @GetMapping("/getAllPayments")
    public List<PaymentResponseDTO> getAllPayments() {
        return service.getAll();
    }
    @PutMapping("/{id}")
    public PaymentResponseDTO update(@PathVariable UUID id,
                                     @RequestBody PaymentRequestDTO request) {
        return service.update(id, request);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "Payment Deleted Successfully";
    }
}
