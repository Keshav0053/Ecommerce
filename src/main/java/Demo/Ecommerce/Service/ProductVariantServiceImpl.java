package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.ProductVariantRequestDTO;
import Demo.Ecommerce.DTO.ProductVariantResponseDTO;
import Demo.Ecommerce.Entity.ProductEntity;
import Demo.Ecommerce.Entity.ProductVariantEntity;
import Demo.Ecommerce.Repository.ProductRepository;
import Demo.Ecommerce.Repository.ProductVariantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class ProductVariantServiceImpl implements ProductVariantService {
    @Autowired
    private  ProductVariantRepository repository;
    @Autowired
    private  ProductRepository productRepository;
    @Override
    public ProductVariantResponseDTO create(ProductVariantRequestDTO request) {
        ProductEntity product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        ProductVariantEntity entity = ProductVariantEntity.builder()
                .product(product)
                .size(request.getSize())
                .color(request.getColor())
                .barcode(request.getBarcode())
                .price(request.getPrice())
                .salePrice(request.getSalePrice())
                .stockQuantity(request.getStockQuantity())
                .weight(request.getWeight())
                .build();
        repository.save(entity);
        return map(entity);
    }
    @Override
    public ProductVariantResponseDTO getById(UUID id) {
        return map(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Variant not found")));
    }
    @Override
    public List<ProductVariantResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }
    @Override
    public ProductVariantResponseDTO update(UUID id, ProductVariantRequestDTO request) {
        ProductVariantEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Variant not found"));
        ProductEntity product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        entity.setProduct(product);
        entity.setSize(request.getSize());
        entity.setColor(request.getColor());
        entity.setBarcode(request.getBarcode());
        entity.setPrice(request.getPrice());
        entity.setSalePrice(request.getSalePrice());
        entity.setStockQuantity(request.getStockQuantity());
        entity.setWeight(request.getWeight());
        repository.save(entity);
        return map(entity);
    }
    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
    private ProductVariantResponseDTO map(ProductVariantEntity entity) {
        return ProductVariantResponseDTO.builder()
                .id(entity.getId())
                .productId(entity.getProduct().getId())
                .productName(entity.getProduct().getName())
                .size(entity.getSize())
                .color(entity.getColor())
                .barcode(entity.getBarcode())
                .price(entity.getPrice())
                .salePrice(entity.getSalePrice())
                .stockQuantity(entity.getStockQuantity())
                .weight(entity.getWeight())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
