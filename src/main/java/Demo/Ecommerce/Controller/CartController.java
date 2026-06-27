package Demo.Ecommerce.Controller;

import Demo.Ecommerce.DTO.CartRequestDTO;
import Demo.Ecommerce.DTO.CartResponseDTO;
import Demo.Ecommerce.Service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor
public class CartController {
    @Autowired
    private  CartService service;
    @PostMapping
    public CartResponseDTO create(@RequestBody CartRequestDTO request) {
        return service.create(request);
    }
    @GetMapping("/{id}")
    public CartResponseDTO getById(@PathVariable UUID id) {
        return service.getById(id);
    }
    @GetMapping
    public List<CartResponseDTO> getAll() {
        return service.getAll();
    }
    @PutMapping("/{id}")
    public CartResponseDTO update(@PathVariable UUID id,
                                  @RequestBody CartRequestDTO request) {
        return service.update(id, request);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "Cart Deleted Successfully";
    }
}
