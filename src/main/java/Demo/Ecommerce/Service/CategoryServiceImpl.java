package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.CategoryRequestDTO;
import Demo.Ecommerce.DTO.CategoryResponseDTO;
import Demo.Ecommerce.Entity.Category;
import Demo.Ecommerce.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private  CategoryRepository categoryRepository;
    @Override
    public CategoryResponseDTO create(CategoryRequestDTO dto) {
        Category parent = null;
        if (dto.getParentId() != null) {
            parent = categoryRepository.findById(dto.getParentId())
                    .orElseThrow(() -> new RuntimeException("Parent Category Not Found"));
        }
        Category category = Category.builder()
                .parentCategory(parent)
                .name(dto.getName())
                .slug(dto.getSlug())
                .description(dto.getDescription())
                .build();
        category = categoryRepository.save(category);
        return mapToDTO(category);
    }
    @Override
    public List<CategoryResponseDTO> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }
    @Override
    public CategoryResponseDTO getById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category Not Found"));
        return mapToDTO(category);
    }
    @Override
    public CategoryResponseDTO update(Long id, CategoryRequestDTO dto) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category Not Found"));

        Category parent = null;

        if (dto.getParentId() != null) {
            parent = categoryRepository.findById(dto.getParentId())
                    .orElseThrow(() -> new RuntimeException("Parent Category Not Found"));
        }
        category.setParentCategory(parent);
        category.setName(dto.getName());
        category.setSlug(dto.getSlug());
        category.setDescription(dto.getDescription());
        category = categoryRepository.save(category);
        return mapToDTO(category);
    }
    @Override
    public void delete(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category Not Found"));
        categoryRepository.delete(category);
    }
    private CategoryResponseDTO mapToDTO(Category category) {

        return CategoryResponseDTO.builder()
                .id(category.getId())
                .parentId(category.getParentCategory() != null
                        ? category.getParentCategory().getId()
                        : null)
                .name(category.getName())
                .slug(category.getSlug())
                .description(category.getDescription())
                .build();
    }
}
