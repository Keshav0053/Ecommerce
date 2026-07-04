package Demo.Ecommerce.DTO;

import Demo.Ecommerce.Entity.UserStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String password;
    private String role;
    private UserStatus status;

}
