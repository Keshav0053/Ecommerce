package Demo.Ecommerce.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandResponseDTO {
    private Long id;
    private String name;
    private String logoUrl;
}
