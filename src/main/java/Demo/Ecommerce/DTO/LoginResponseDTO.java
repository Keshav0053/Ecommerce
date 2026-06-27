package Demo.Ecommerce.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTOResponse {
    private UUID id;
    private UUID userId;
    private String provider;
    private String providerUserId;
    private LocalDateTime createdAt;
}
