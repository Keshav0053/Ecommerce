package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.CartRequestDTO;
import Demo.Ecommerce.DTO.CartResponseDTO;
import Demo.Ecommerce.Entity.CartEntity;
import Demo.Ecommerce.Entity.User;
import Demo.Ecommerce.Repository.CartRepository;
import Demo.Ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class CartServiceImpl implements CartService {
@Autowired
    private CartRepository repository;
@Autowired
    private UserRepository userRepository;
    @Override
    public CartResponseDTO create(CartRequestDTO request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        CartEntity entity = CartEntity.builder()
                .user(user)
                .build();
        repository.save(entity);
        return map(entity);
    }
    @Override
    public CartResponseDTO getById(UUID id) {
        return map(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found")));
    }
    @Override
    public List<CartResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }
    @Override
    public CartResponseDTO update(UUID id, CartRequestDTO request) {

        CartEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        entity.setUser(user);
        repository.save(entity);
        return map(entity);
    }
    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
    private CartResponseDTO map(CartEntity entity) {
        return CartResponseDTO.builder()
                .id(entity.getId())
                .userId(entity.getUser().getId())
                .userName(entity.getUser().getFirstName() + " " + entity.getUser().getLastName())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
