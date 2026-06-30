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
    @PostMapping("/createProductImage")
    public ProductImageResponseDTO createProductImage(@RequestBody ProductImageRequestDTO request) {
        return service.create(request);
    }
    @GetMapping("/getProductImageById/{id}")
    public ProductImageResponseDTO getProductImageById(@PathVariable Long id) {
        return service.getById(id);
    }
    @GetMapping("/getAllProductImages")
    public List<ProductImageResponseDTO> getAllProductImages(@RequestParam Integer page, @RequestParam Integer size) {
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
