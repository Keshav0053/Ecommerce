package Demo.Ecommerce.DTO;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LoginRequestDTO {

    @Email(message = "Invalid email")
    private String email;

    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Mobile number must be a valid 10-digit Indian mobile number"
    )
    private String mobileNumber;

    @NotBlank(message = "Password is required")
    private String password;

    @AssertTrue(message = "Either email or mobile number is required")
    public boolean isEmailOrMobilePresent() {
        return (email != null && !email.trim().isEmpty()) ||
                (mobileNumber != null && !mobileNumber.trim().isEmpty());
    }
}