package Demo.Ecommerce.Controller;

import Demo.Ecommerce.DTO.CartItemRequestDTO;
import Demo.Ecommerce.DTO.CartItemResponseDTO;
import Demo.Ecommerce.Service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/cart-items")
@RequiredArgsConstructor
public class CartItemController {
@Autowired
    private CartItemService service;
    @PostMapping("/createCartItem")
    public CartItemResponseDTO createCartItem(@RequestBody CartItemRequestDTO request) {
        return service.create(request);
    }
    @GetMapping("/getCartItemById/{id}")
    public CartItemResponseDTO getCartItemById(@PathVariable UUID id) {
        return service.getById(id);
    }
    @GetMapping("/getAllCartItems")
    public List<CartItemResponseDTO> getAllCartItems() {
        return service.getAll();
    }
    @PutMapping("/{id}")
    public CartItemResponseDTO update(@PathVariable UUID id,
                                      @RequestBody CartItemRequestDTO request) {
        return service.update(id, request);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "Cart Item Deleted Successfully";
    }
}
