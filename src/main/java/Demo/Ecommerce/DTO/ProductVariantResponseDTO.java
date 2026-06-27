package Demo.Ecommerce.DTO;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariantResponseDTO {
    private UUID id;
    private UUID productId;
    private String productName;
    private String size;
    private String color;
    private String barcode;
    private BigDecimal price;
    private BigDecimal salePrice;
    private Integer stockQuantity;
    private BigDecimal weight;
    private LocalDateTime createdAt;
}
