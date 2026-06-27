package Demo.Ecommerce.Repository;

import Demo.Ecommerce.Entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<PaymentEntity, UUID> {
    Optional<PaymentEntity> findByTransactionId(String transactionId);
}
