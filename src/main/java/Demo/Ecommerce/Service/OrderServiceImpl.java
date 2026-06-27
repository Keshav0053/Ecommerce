package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.OrderRequestDTO;
import Demo.Ecommerce.DTO.OrderResponseDTO;
import Demo.Ecommerce.Entity.AddressEntity;
import Demo.Ecommerce.Entity.OrderEntity;
import Demo.Ecommerce.Entity.User;
import Demo.Ecommerce.Repository.AddressRepository;
import Demo.Ecommerce.Repository.OrderRepository;
import Demo.Ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public OrderResponseDTO create(OrderRequestDTO request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        AddressEntity address = addressRepository.findById(request.getAddressId())
                .orElseThrow(() -> new RuntimeException("Address not found"));

        OrderEntity entity = OrderEntity.builder()
                .user(user)
                .address(address)
                .orderNumber(request.getOrderNumber())
                .subtotal(request.getSubtotal())
                .discount(request.getDiscount())
                .shippingCharge(request.getShippingCharge())
                .tax(request.getTax())
                .totalAmount(request.getTotalAmount())
                .paymentStatus(request.getPaymentStatus())
                .orderStatus(request.getOrderStatus())
                .paymentMethod(request.getPaymentMethod())
                .build();

        repository.save(entity);

        return map(entity);
    }

    @Override
    public OrderResponseDTO getById(UUID id) {

        return map(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found")));
    }

    @Override
    public List<OrderResponseDTO> getAll() {

        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    @Override
    public OrderResponseDTO update(UUID id, OrderRequestDTO request) {
        OrderEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        AddressEntity address = addressRepository.findById(request.getAddressId())
                .orElseThrow(() -> new RuntimeException("Address not found"));
        entity.setUser(user);
        entity.setAddress(address);
        entity.setOrderNumber(request.getOrderNumber());
        entity.setSubtotal(request.getSubtotal());
        entity.setDiscount(request.getDiscount());
        entity.setShippingCharge(request.getShippingCharge());
        entity.setTax(request.getTax());
        entity.setTotalAmount(request.getTotalAmount());
        entity.setPaymentStatus(request.getPaymentStatus());
        entity.setOrderStatus(request.getOrderStatus());
        entity.setPaymentMethod(request.getPaymentMethod());
        repository.save(entity);
        return map(entity);
    }
    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
    private OrderResponseDTO map(OrderEntity entity) {
        return OrderResponseDTO.builder()
                .id(entity.getId())
                .userId(entity.getUser().getId())
                .userName(entity.getUser().getFirstName() + " " + entity.getUser().getLastName())
                .addressId(entity.getAddress().getId())
                .address(entity.getAddress().getAddressLine1() + ", "
                        + entity.getAddress().getCity() + ", "
                        + entity.getAddress().getState())
                .orderNumber(entity.getOrderNumber())
                .subtotal(entity.getSubtotal())
                .discount(entity.getDiscount())
                .shippingCharge(entity.getShippingCharge())
                .tax(entity.getTax())
                .totalAmount(entity.getTotalAmount())
                .paymentStatus(entity.getPaymentStatus())
                .orderStatus(entity.getOrderStatus())
                .paymentMethod(entity.getPaymentMethod())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
