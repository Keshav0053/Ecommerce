package Demo.Ecommerce.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
public class ProductImageResponseDTO {
    private Long id;
    private UUID productId;
    private String productName;
    private String imageUrl;
    private Integer displayOrder;
}
