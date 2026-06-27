package Demo.Ecommerce.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class WishlistRequestDTO {
    private UUID userId;
    private UUID productId;
}
