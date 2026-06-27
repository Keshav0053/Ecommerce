package Demo.Ecommerce.Repository;

import Demo.Ecommerce.Entity.ProductImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductImageRepository extends JpaRepository<ProductImageEntity, Long> {
}
