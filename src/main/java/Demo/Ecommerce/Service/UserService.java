package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.UserRequestDTO;
import Demo.Ecommerce.DTO.UserResponseDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO request);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO getUserById(UUID id);
    UserResponseDTO updateUser(UUID id, UserRequestDTO request);
    String deleteUser(UUID id);
}
