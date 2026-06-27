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
public class OrderResponseDTO {
    private UUID id;
    private UUID userId;
    private String userName;
    private UUID addressId;
    private String address;
    private String orderNumber;
    private BigDecimal subtotal;
    private BigDecimal discount;
    private BigDecimal shippingCharge;
    private BigDecimal tax;
    private BigDecimal totalAmount;
    private String paymentStatus;
    private String orderStatus;
    private String paymentMethod;
    private LocalDateTime createdAt;
}
