package Demo.Ecommerce.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class LoginResponseDTO {

    private UUID id;

    private UUID userId;

    private String provider;

    private String providerUserId;

    private String token;

    private LocalDateTime createdAt;

    private String message;
}