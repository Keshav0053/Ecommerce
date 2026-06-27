package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.WishlistRequestDTO;
import Demo.Ecommerce.DTO.WishlistResponseDTO;
import Demo.Ecommerce.Entity.ProductEntity;
import Demo.Ecommerce.Entity.User;
import Demo.Ecommerce.Entity.WishlistEntity;
import Demo.Ecommerce.Repository.ProductRepository;
import Demo.Ecommerce.Repository.UserRepository;
import Demo.Ecommerce.Repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class WishlistServiceImpl implements WishlistService {
@Autowired
    private WishlistRepository repository;
@Autowired
    private UserRepository userRepository;
@Autowired
    private ProductRepository productRepository;

    @Override
    public WishlistResponseDTO create(WishlistRequestDTO request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        ProductEntity product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        WishlistEntity entity = WishlistEntity.builder()
                .user(user)
                .product(product)
                .build();

        repository.save(entity);

        return map(entity);
    }

    @Override
    public WishlistResponseDTO getById(UUID id) {
        return map(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wishlist not found")));
    }

    @Override
    public List<WishlistResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    @Override
    public WishlistResponseDTO update(UUID id, WishlistRequestDTO request) {

        WishlistEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wishlist not found"));

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        ProductEntity product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        entity.setUser(user);
        entity.setProduct(product);

        repository.save(entity);

        return map(entity);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private WishlistResponseDTO map(WishlistEntity entity) {

        return WishlistResponseDTO.builder()
                .id(entity.getId())
                .userId(entity.getUser().getId())
                .userName(entity.getUser().getFirstName() + " " + entity.getUser().getLastName())
                .productId(entity.getProduct().getId())
                .productName(entity.getProduct().getName())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
