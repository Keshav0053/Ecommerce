package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.AddressRequestDTO;
import Demo.Ecommerce.DTO.AddressResponseDTO;
import Demo.Ecommerce.Entity.AddressEntity;
import Demo.Ecommerce.Entity.User;
import Demo.Ecommerce.Repository.AddressRepository;
import Demo.Ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public AddressResponseDTO create(AddressRequestDTO request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        AddressEntity entity = AddressEntity.builder()
                .user(user)
                .name(request.getName())
                .mobile(request.getMobile())
                .addressLine1(request.getAddressLine1())
                .addressLine2(request.getAddressLine2())
                .city(request.getCity())
                .state(request.getState())
                .country(request.getCountry())
                .pincode(request.getPincode())
                .isDefault(request.getIsDefault())
                .build();
        repository.save(entity);

        return map(entity);
    }

    @Override
    public AddressResponseDTO getById(UUID id) {
        return map(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found")));
    }
    @Override
    public List<AddressResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }
    @Override
    public AddressResponseDTO update(UUID id, AddressRequestDTO request) {
        AddressEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        entity.setUser(user);
        entity.setName(request.getName());
        entity.setMobile(request.getMobile());
        entity.setAddressLine1(request.getAddressLine1());
        entity.setAddressLine2(request.getAddressLine2());
        entity.setCity(request.getCity());
        entity.setState(request.getState());
        entity.setCountry(request.getCountry());
        entity.setPincode(request.getPincode());
        entity.setIsDefault(request.getIsDefault());
        repository.save(entity);
        return map(entity);
    }
    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
    private AddressResponseDTO map(AddressEntity entity) {
        return AddressResponseDTO.builder()
                .id(entity.getId())
                .userId(entity.getUser().getId())
                .userName(entity.getUser().getFirstName() + " " + entity.getUser().getLastName())
                .name(entity.getName())
                .mobile(entity.getMobile())
                .addressLine1(entity.getAddressLine1())
                .addressLine2(entity.getAddressLine2())
                .city(entity.getCity())
                .state(entity.getState())
                .country(entity.getCountry())
                .pincode(entity.getPincode())
                .isDefault(entity.getIsDefault())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
