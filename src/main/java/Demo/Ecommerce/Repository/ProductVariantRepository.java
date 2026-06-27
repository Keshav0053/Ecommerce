package Demo.Ecommerce.Repository;

import Demo.Ecommerce.Entity.ProductVariantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ProductVariantRepository extends JpaRepository<ProductVariantEntity, UUID> {
    boolean existsByBarcode(String barcode);
}
