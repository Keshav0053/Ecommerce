package Demo.Ecommerce.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
public class CartItemResponseDTO {
    private UUID id;
    private UUID cartId;
    private UUID productVariantId;
    private String productName;
    private Integer quantity;
}
