package Demo.Ecommerce.Repository;

import Demo.Ecommerce.Entity.CartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CartRepository extends JpaRepository<CartEntity, UUID> {
}
