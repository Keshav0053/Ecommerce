package Demo.Ecommerce.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;
@Data
public class OrderRequestDTO {

    private UUID userId;

    private UUID addressId;

    private String orderNumber;

    private BigDecimal subtotal;

    private BigDecimal discount;

    private BigDecimal shippingCharge;

    private BigDecimal tax;

    private BigDecimal totalAmount;

    private String paymentStatus;

    private String orderStatus;

    private String paymentMethod;
}
