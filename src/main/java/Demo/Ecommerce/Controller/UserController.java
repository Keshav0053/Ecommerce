package Demo.Ecommerce.Controller;

import Demo.Ecommerce.DTO.ApiResponse;
import Demo.Ecommerce.DTO.UserRequestDTO;
import Demo.Ecommerce.DTO.UserResponseDTO;
import Demo.Ecommerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/createUser")
    public ApiResponse<UserResponseDTO> createUser(@RequestBody UserRequestDTO request) {
        UserResponseDTO response = userService.createUser(request);
        return ApiResponse.<UserResponseDTO>builder()
                .success(true)
                .message("User created successfully.")
                .data(response)
                .build();
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
