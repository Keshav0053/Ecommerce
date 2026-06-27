package Demo.Ecommerce.DTO;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDTO {
    private UUID id;
    private Long brandId;
    private Long categoryId;
    private String sku;
    private String name;
    private String description;
    private String shortDescription;
    private String status;
    private LocalDateTime createdAt;
}
