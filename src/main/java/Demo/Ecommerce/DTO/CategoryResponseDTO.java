package Demo.Ecommerce.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponseDTO {
    private Long id;
    private Long parentId;
    private String name;
    private String slug;
    private String description;
}
