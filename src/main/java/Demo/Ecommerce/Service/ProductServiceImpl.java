package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.ProductRequestDTO;
import Demo.Ecommerce.DTO.ProductResponseDTO;
import Demo.Ecommerce.Entity.ProductEntity;
import Demo.Ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class ProductServiceImpl implements ProductService {
@Autowired
    private ProductRepository productRepository;
    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO request) {

        if (productRepository.existsBySku(request.getSku())) {
            throw new RuntimeException("SKU already exists.");
        }
        ProductEntity product = ProductEntity.builder()
                .brandId(request.getBrandId())
                .categoryId(request.getCategoryId())
                .sku(request.getSku())
                .name(request.getName())
                .description(request.getDescription())
                .shortDescription(request.getShortDescription())
                .status(
                        request.getStatus() == null || request.getStatus().isBlank()
                                ? "ACTIVE"
                                : request.getStatus()
                )
                .build();
        ProductEntity savedProduct = productRepository.save(product);
        return mapToResponse(savedProduct);
    }
    @Override
    public ProductResponseDTO getProductById(UUID id) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found."));
        return mapToResponse(product);
    }
    @Override
    public List<ProductResponseDTO> getAllProducts() {

        return productRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    @Override
    public ProductResponseDTO updateProduct(UUID id, ProductRequestDTO request) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found."));
        product.setBrandId(request.getBrandId());
        product.setCategoryId(request.getCategoryId());
        product.setSku(request.getSku());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setShortDescription(request.getShortDescription());
        product.setStatus(request.getStatus());

        ProductEntity updatedProduct = productRepository.save(product);

        return mapToResponse(updatedProduct);
    }
    @Override
    public String deleteProduct(UUID id) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found."));
        productRepository.delete(product);
        return "Product deleted successfully.";
    }
    private ProductResponseDTO mapToResponse(ProductEntity product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .brandId(product.getBrandId())
                .categoryId(product.getCategoryId())
                .sku(product.getSku())
                .name(product.getName())
                .description(product.getDescription())
                .shortDescription(product.getShortDescription())
                .status(product.getStatus())
                .createdAt(product.getCreatedAt())
                .build();
    }
    }

