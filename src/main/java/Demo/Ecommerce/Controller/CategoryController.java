package Demo.Ecommerce.Controller;

import Demo.Ecommerce.DTO.CategoryRequestDTO;
import Demo.Ecommerce.DTO.CategoryResponseDTO;
import Demo.Ecommerce.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
@Autowired
    private CategoryService categoryService;
    @PostMapping
    public CategoryResponseDTO create(@RequestBody CategoryRequestDTO dto) {
        return categoryService.create(dto);
    }
    @GetMapping
    public List<CategoryResponseDTO> getAll() {
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public CategoryResponseDTO getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }
    @PutMapping("/{id}")
    public CategoryResponseDTO update(
            @PathVariable Long id,
            @RequestBody CategoryRequestDTO dto) {
        return categoryService.update(id, dto);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        categoryService.delete(id);

        return "Category Deleted Successfully";
    }
}
