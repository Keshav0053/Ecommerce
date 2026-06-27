package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.ProductImageRequestDTO;
import Demo.Ecommerce.DTO.ProductImageResponseDTO;

import java.util.List;

public interface ProductImageService {
    ProductImageResponseDTO create(ProductImageRequestDTO request);
    ProductImageResponseDTO getById(Long id);
    List<ProductImageResponseDTO> getAll();
    ProductImageResponseDTO update(Long id, ProductImageRequestDTO request);
    void delete(Long id);
}
