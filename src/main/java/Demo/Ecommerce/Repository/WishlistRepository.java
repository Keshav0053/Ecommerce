package Demo.Ecommerce.Repository;

import Demo.Ecommerce.Entity.WishlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WishlistRepository extends JpaRepository<WishlistEntity, UUID> {
}
