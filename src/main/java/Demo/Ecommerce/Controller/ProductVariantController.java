package Demo.Ecommerce.Controller;

import Demo.Ecommerce.DTO.ProductVariantRequestDTO;
import Demo.Ecommerce.DTO.ProductVariantResponseDTO;
import Demo.Ecommerce.Service.ProductVariantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/product_variants")
@RequiredArgsConstructor
public class ProductVariantController {
    @Autowired
    private ProductVariantService service;
    @PostMapping
    public ProductVariantResponseDTO create(@RequestBody ProductVariantRequestDTO request) {
        return service.create(request);
    }
    @GetMapping("/{id}")
    public ProductVariantResponseDTO getById(@PathVariable UUID id) {
        return service.getById(id);
    }
    @GetMapping
    public List<ProductVariantResponseDTO> getAll() {
        return service.getAll();
    }
    @PutMapping("/{id}")
    public ProductVariantResponseDTO update(@PathVariable UUID id,
                                            @RequestBody ProductVariantRequestDTO request) {
        return service.update(id, request);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "Product Variant Deleted Successfully";
    }

}
