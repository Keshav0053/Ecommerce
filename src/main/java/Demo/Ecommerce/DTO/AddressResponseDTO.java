package Demo.Ecommerce.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Builder
public class AddressResponseDTO {
    private UUID id;
    private UUID userId;
    private String userName;
    private String name;
    private String mobile;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private Boolean isDefault;
    private LocalDateTime createdAt;
}
