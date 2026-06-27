package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.ProductImageRequestDTO;
import Demo.Ecommerce.DTO.ProductImageResponseDTO;
import Demo.Ecommerce.Entity.ProductEntity;
import Demo.Ecommerce.Entity.ProductImageEntity;
import Demo.Ecommerce.Repository.ProductImageRepository;
import Demo.Ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    private ProductImageRepository repository;
    @Autowired
    private  ProductRepository productRepository;
    @Override
    public ProductImageResponseDTO create(ProductImageRequestDTO request) {
        ProductEntity product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        ProductImageEntity entity = ProductImageEntity.builder()
                .product(product)
                .imageUrl(request.getImageUrl())
                .displayOrder(request.getDisplayOrder())
                .build();
        repository.save(entity);
        return map(entity);
    }
    @Override
    public ProductImageResponseDTO getById(Long id) {
        return map(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found")));
    }
    @Override
    public List<ProductImageResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }
    @Override
    public ProductImageResponseDTO update(Long id, ProductImageRequestDTO request) {
        ProductImageEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found"));
        ProductEntity product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        entity.setProduct(product);
        entity.setImageUrl(request.getImageUrl());
        entity.setDisplayOrder(request.getDisplayOrder());
        repository.save(entity);
        return map(entity);
    }
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
    private ProductImageResponseDTO map(ProductImageEntity entity) {
        return ProductImageResponseDTO.builder()
                .id(entity.getId())
                .productId(entity.getProduct().getId())
                .productName(entity.getProduct().getName())
                .imageUrl(entity.getImageUrl())
                .displayOrder(entity.getDisplayOrder())
                .build();
    }
}
