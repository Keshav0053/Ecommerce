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
@RequestMapping("/api/logins")
@RequiredArgsConstructor
public class LoginController {
@Autowired
    private LoginService loginService;
    @PostMapping("/socialLogin")
    public ResponseEntity<LoginResponseDTO> socialLogin(
            @Valid @RequestBody LoginRequestDTO request) {
        LoginResponseDTO response = loginService.socialLogin(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}