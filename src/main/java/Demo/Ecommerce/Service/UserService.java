package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.UserDTO;
import Demo.Ecommerce.Entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User createUser(UserDTO request);
    List<User> getAllUsers();
    User getUserById(UUID id);
}
