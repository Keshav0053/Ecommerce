package Demo.Ecommerce.JWTUtil;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    public String generateToken(String email) {
        return "DummyToken_" + email;
    }
}
