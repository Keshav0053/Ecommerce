package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.CartItemRequestDTO;
import Demo.Ecommerce.DTO.CartItemResponseDTO;
import Demo.Ecommerce.Entity.CartEntity;
import Demo.Ecommerce.Entity.CartItemEntity;
import Demo.Ecommerce.Entity.ProductVariantEntity;
import Demo.Ecommerce.Repository.CartItemRepository;
import Demo.Ecommerce.Repository.CartRepository;
import Demo.Ecommerce.Repository.ProductVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class CartItemServiceImpl implements CartItemService {

@Autowired
    private CartItemRepository repository;
@Autowired
    private CartRepository cartRepository;
@Autowired
    private ProductVariantRepository productVariantRepository;
    @Override
    public CartItemResponseDTO create(CartItemRequestDTO request) {
        CartEntity cart = cartRepository.findById(request.getCartId())
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        ProductVariantEntity variant = productVariantRepository.findById(request.getProductVariantId())
                .orElseThrow(() -> new RuntimeException("Variant not found"));
        CartItemEntity entity = CartItemEntity.builder()
                .cart(cart)
                .productVariant(variant)
                .quantity(request.getQuantity())
                .build();
        repository.save(entity);
        return map(entity);
    }

    @Override
    public CartItemResponseDTO getById(UUID id) {
        return map(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart Item not found")));
    }

    @Override
    public List<CartItemResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    @Override
    public CartItemResponseDTO update(UUID id, CartItemRequestDTO request) {

        CartItemEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart Item not found"));

        CartEntity cart = cartRepository.findById(request.getCartId())
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        ProductVariantEntity variant = productVariantRepository.findById(request.getProductVariantId())
                .orElseThrow(() -> new RuntimeException("Variant not found"));

        entity.setCart(cart);
        entity.setProductVariant(variant);
        entity.setQuantity(request.getQuantity());
        repository.save(entity);
        return map(entity);
    }
    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
    private CartItemResponseDTO map(CartItemEntity entity) {

        return CartItemResponseDTO.builder()
                .id(entity.getId())
                .cartId(entity.getCart().getId())
                .productVariantId(entity.getProductVariant().getId())
                .productName(entity.getProductVariant().getProduct().getName())
                .quantity(entity.getQuantity())
                .build();
    }
}
