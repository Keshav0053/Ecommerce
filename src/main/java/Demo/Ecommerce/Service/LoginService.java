package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.LoginRequestDTO;
import Demo.Ecommerce.DTO.LoginResponseDTO;

public interface LoginService {

    LoginResponseDTO socialLogin(LoginRequestDTO request);

}