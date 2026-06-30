package Demo.Ecommerce.Controller;

import Demo.Ecommerce.DTO.OrderRequestDTO;
import Demo.Ecommerce.DTO.OrderResponseDTO;
import Demo.Ecommerce.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping("/createOrder")
    public OrderResponseDTO createOrder(@RequestBody OrderRequestDTO request) {
        return service.create(request);
    }

    @GetMapping("/getOrderById/{id}")
    public OrderResponseDTO getOrderById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping("/getAllOrders")
    public List<OrderResponseDTO> getAllOrders() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public OrderResponseDTO update(@PathVariable UUID id,
                                   @RequestBody OrderRequestDTO request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "Order Deleted Successfully";
    }
}
