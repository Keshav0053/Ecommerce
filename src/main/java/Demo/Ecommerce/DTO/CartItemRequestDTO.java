package Demo.Ecommerce.DTO;

import lombok.Data;

import java.util.UUID;
@Data
public class CartItemRequestDTO {
    private UUID cartId;
    private UUID productVariantId;
    private Integer quantity;
}
