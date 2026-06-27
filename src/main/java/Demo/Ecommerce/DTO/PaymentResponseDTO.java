package Demo.Ecommerce.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponseDTO {
    private UUID id;
    private UUID orderId;
    private String orderNumber;
    private String paymentMethod;
    private String paymentStatus;
    private String transactionId;
    private BigDecimal amount;
    private LocalDateTime paymentDate;
}
