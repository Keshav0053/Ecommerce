package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.CategoryRequestDTO;
import Demo.Ecommerce.DTO.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {

    CategoryResponseDTO create(CategoryRequestDTO dto) ;
    List<CategoryResponseDTO> getAll();

    CategoryResponseDTO getById(Long id);

    CategoryResponseDTO update(Long id, CategoryRequestDTO dto);

    void delete(Long id);
}
