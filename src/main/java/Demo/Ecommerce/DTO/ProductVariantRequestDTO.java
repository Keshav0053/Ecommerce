package Demo.Ecommerce.DTO;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariantRequestDTO {

    private UUID productId;
    private String size;
    private String color;
    private String barcode;
    private BigDecimal price;
    private BigDecimal salePrice;
    private Integer stockQuantity;
    private BigDecimal weight;
}
