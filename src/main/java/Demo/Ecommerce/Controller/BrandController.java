package Demo.Ecommerce.Controller;

import Demo.Ecommerce.DTO.BrandRequestDTO;
import Demo.Ecommerce.DTO.BrandResponseDTO;
import Demo.Ecommerce.Service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping("/createBrand")
    public BrandResponseDTO createBrand(@RequestBody BrandRequestDTO dto) {
        return brandService.create(dto);
    }
    @GetMapping("/getAllBrands")
    public List<BrandResponseDTO> getAllBrands() {
        return brandService.getAll();
    }
    @GetMapping("/getBrandById/{id}")
    public BrandResponseDTO getBrandById(@PathVariable Long id) {
        return brandService.getById(id);
    }
    @PutMapping("/{id}")
    public BrandResponseDTO update(@PathVariable Long id,
                                   @RequestBody BrandRequestDTO dto) {
        return brandService.update(id, dto);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        brandService.delete(id);
        return "Brand Deleted Successfully";
    }
}
