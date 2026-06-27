package Demo.Ecommerce.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Builder
public class WishlistResponseDTO {
    private UUID id;
    private UUID userId;
    private String userName;
    private UUID productId;
    private String productName;
    private LocalDateTime createdAt;
}
