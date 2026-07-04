package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.LoginRequestDTO;
import Demo.Ecommerce.DTO.LoginResponseDTO;
import Demo.Ecommerce.Entity.User;
import Demo.Ecommerce.Util.JwtUtil;
import Demo.Ecommerce.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImp implements LoginService {
    @Autowired
    private  UserRepository userRepository;
@Autowired
    private  PasswordEncoder passwordEncoder;
@Autowired
    private JwtUtil jwtUtil;
    @Override
    public LoginResponseDTO login(LoginRequestDTO request) {

        User user = null;

        // Login using Email
        if (request.getEmail() != null && !request.getEmail().trim().isEmpty()) {
            user = userRepository.findByEmail(request.getEmail()).orElse(null);
        }
        // Login using Mobile Number
        else if (request.getMobileNumber() != null && !request.getMobileNumber().trim().isEmpty()) {
            user = userRepository.findByMobile(request.getMobileNumber()).orElse(null);
        }
        // Neither Email nor Mobile provided
        else {
            return LoginResponseDTO.builder()
                    .success(false)
                    .message("Email or Mobile Number is required")
                    .build();
        }

        // User not found
        if (user == null) {
            return LoginResponseDTO.builder()
                    .success(false)
                    .message("Invalid Email or Mobile Number")
                    .build();
        }

        // Password mismatch
        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            return LoginResponseDTO.builder()
                    .success(false)
                    .message("Invalid Password")
                    .build();
        }

        // Generate JWT
        String token = jwtUtil.generateToken(user.getEmail());

        return LoginResponseDTO.builder()
                .success(true)
                .message("Login Successful")
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .mobileNumber(user.getMobile())
                .token(token)
                .build();
    }
}