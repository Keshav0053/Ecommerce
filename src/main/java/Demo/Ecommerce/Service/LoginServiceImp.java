package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.LoginRequestDTO;
import Demo.Ecommerce.DTO.LoginResponseDTO;
import Demo.Ecommerce.Entity.LoginEntity;
import Demo.Ecommerce.Repository.LoginRepository;
import Demo.Ecommerce.Repository.UserRepository;
import Demo.Ecommerce.JWTUtil.JwtService;
import Demo.Ecommerce.Service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImp implements LoginService {
@Autowired
    private  LoginRepository loginRepository;
@Autowired
    private UserRepository userRepository;
@Autowired
    private  JwtService jwtService;
    @Override
    public LoginResponseDTO socialLogin(LoginRequestDTO request) {
        // User Exists?
        if (!userRepository.existsById(request.getUserId())) {
            throw new RuntimeException("User not found.");
        }
        // Save Login
        LoginEntity login = LoginEntity.builder()
                .userId(request.getUserId())
                .provider(request.getProvider())
                .providerUserId(request.getProviderUserId())
                .build();
        LoginEntity savedLogin = loginRepository.save(login);
        // Generate JWT
        String token = jwtService.generateToken(savedLogin.getUserId());
        // Response
        return LoginResponseDTO.builder()
                .id(savedLogin.getId())
                .userId(savedLogin.getUserId())
                .provider(savedLogin.getProvider())
                .providerUserId(savedLogin.getProviderUserId())
                .createdAt(savedLogin.getCreatedAt())
                .token(token)
                .message("Login Successful")
                .build();
    }
}