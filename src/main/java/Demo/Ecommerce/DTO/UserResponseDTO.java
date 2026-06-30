package Demo.Ecommerce.DTO;

import Demo.Ecommerce.Entity.User;
import Demo.Ecommerce.Entity.UserStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@Builder
public class UserResponseDTO  {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String role;
    private UserStatus status;
    private Boolean emailVerified;
    private Boolean mobileVerified;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
