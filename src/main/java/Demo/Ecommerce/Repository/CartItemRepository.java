package Demo.Ecommerce.Repository;

import Demo.Ecommerce.Entity.CartEntity;
import Demo.Ecommerce.Entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface  CartItemRepository  extends JpaRepository<CartItemEntity, UUID> {
}
