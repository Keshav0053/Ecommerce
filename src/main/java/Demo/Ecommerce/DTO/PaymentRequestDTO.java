package Demo.Ecommerce.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;
@Data
public class PaymentRequestDTO {
    private UUID orderId;
    private String paymentMethod;
    private String paymentStatus;
    private String transactionId;
    private BigDecimal amount;
}
