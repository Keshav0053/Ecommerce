package Demo.Ecommerce.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponseDTO {
    private boolean success;
    private String message;
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String token;
}