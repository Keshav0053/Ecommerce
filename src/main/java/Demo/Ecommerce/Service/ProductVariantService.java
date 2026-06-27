package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.ProductVariantRequestDTO;
import Demo.Ecommerce.DTO.ProductVariantResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ProductVariantService {
    ProductVariantResponseDTO create(ProductVariantRequestDTO request);
    ProductVariantResponseDTO getById(UUID id);
    List<ProductVariantResponseDTO> getAll();
    ProductVariantResponseDTO update(UUID id, ProductVariantRequestDTO request);
    void delete(UUID id);
}
