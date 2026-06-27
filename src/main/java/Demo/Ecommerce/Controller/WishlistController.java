package Demo.Ecommerce.Controller;

import Demo.Ecommerce.DTO.WishlistRequestDTO;
import Demo.Ecommerce.DTO.WishlistResponseDTO;
import Demo.Ecommerce.Service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/wishlists")
@RequiredArgsConstructor
public class WishlistController {
    @Autowired
    private  WishlistService service;

    @PostMapping
    public WishlistResponseDTO create(@RequestBody WishlistRequestDTO request) {
        return service.create(request);
    }
    @GetMapping("/{id}")
    public WishlistResponseDTO getById(@PathVariable UUID id) {
        return service.getById(id);
    }
    @GetMapping
    public List<WishlistResponseDTO> getAll() {
        return service.getAll();
    }
    @PutMapping("/{id}")
    public WishlistResponseDTO update(@PathVariable UUID id,
                                      @RequestBody WishlistRequestDTO request) {
        return service.update(id, request);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "Wishlist Deleted Successfully";
    }
}
