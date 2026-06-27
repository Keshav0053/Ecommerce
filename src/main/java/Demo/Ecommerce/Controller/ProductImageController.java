package Demo.Ecommerce.Controller;

import Demo.Ecommerce.DTO.ProductImageRequestDTO;
import Demo.Ecommerce.DTO.ProductImageResponseDTO;
import Demo.Ecommerce.Service.ProductImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/product-images")
@RequiredArgsConstructor
public class ProductImageController {
    @Autowired
    private  ProductImageService service;
    @PostMapping
    public ProductImageResponseDTO create(@RequestBody ProductImageRequestDTO request) {
        return service.create(request);
    }
    @GetMapping("/{id}")
    public ProductImageResponseDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }
    @GetMapping
    public List<ProductImageResponseDTO> getAll() {
        return service.getAll();
    }
    @PutMapping("/{id}")
    public ProductImageResponseDTO update(@PathVariable Long id,
                                          @RequestBody ProductImageRequestDTO request) {
        return service.update(id, request);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Product Image Deleted Successfully";
    }
}
