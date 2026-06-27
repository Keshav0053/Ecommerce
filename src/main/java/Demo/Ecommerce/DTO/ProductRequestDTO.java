package Demo.Ecommerce.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDTO {
    @NotNull(message = "Brand Id is required")
    private Long brandId;
    @NotNull(message = "Category Id is required")
    private Long categoryId;
    @NotBlank(message = "SKU is required")
    private String sku;
    @NotBlank(message = "Product name is required")
    private String name;
    private String description;
    private String shortDescription;
    private String status;
}
