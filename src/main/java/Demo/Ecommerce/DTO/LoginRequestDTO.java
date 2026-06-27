package Demo.Ecommerce.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data

public class LoginRequestDTO {

    @NotNull(message = "User Id is required")
    private UUID userId;

    @NotBlank(message = "Provider is required")
    private String provider;

    @NotBlank(message = "Provider User Id is required")
    private String providerUserId;
}
