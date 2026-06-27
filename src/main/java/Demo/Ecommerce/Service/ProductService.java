package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.ProductRequestDTO;
import Demo.Ecommerce.DTO.ProductResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductResponseDTO createProduct(ProductRequestDTO request);
    ProductResponseDTO getProductById(UUID id);
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO updateProduct(UUID id, ProductRequestDTO request);
    String deleteProduct(UUID id);
}