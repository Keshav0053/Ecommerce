package Demo.Ecommerce.Controller;

import Demo.Ecommerce.DTO.LoginRequestDTO;
import Demo.Ecommerce.DTO.LoginResponseDTO;
import Demo.Ecommerce.Service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class LoginController {
@Autowired
private  LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @Valid @RequestBody LoginRequestDTO request) {

        return ResponseEntity.ok(loginService.login(request));
    }
}