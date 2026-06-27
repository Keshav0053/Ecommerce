package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.PaymentRequestDTO;
import Demo.Ecommerce.DTO.PaymentResponseDTO;
import Demo.Ecommerce.Entity.OrderEntity;
import Demo.Ecommerce.Entity.PaymentEntity;
import Demo.Ecommerce.Repository.OrderRepository;
import Demo.Ecommerce.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class PaymentServiceImpl implements PaymentService {
@Autowired
    private PaymentRepository repository;
@Autowired
    private OrderRepository orderRepository;

    @Override
    public PaymentResponseDTO create(PaymentRequestDTO request) {

        OrderEntity order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        PaymentEntity entity = PaymentEntity.builder()
                .order(order)
                .paymentMethod(request.getPaymentMethod())
                .paymentStatus(request.getPaymentStatus())
                .transactionId(request.getTransactionId())
                .amount(request.getAmount())
                .build();

        repository.save(entity);

        return map(entity);
    }

    @Override
    public PaymentResponseDTO getById(UUID id) {

        return map(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found")));
    }

    @Override
    public List<PaymentResponseDTO> getAll() {

        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    @Override
    public PaymentResponseDTO update(UUID id, PaymentRequestDTO request) {

        PaymentEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        OrderEntity order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        entity.setOrder(order);
        entity.setPaymentMethod(request.getPaymentMethod());
        entity.setPaymentStatus(request.getPaymentStatus());
        entity.setTransactionId(request.getTransactionId());
        entity.setAmount(request.getAmount());

        repository.save(entity);

        return map(entity);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private PaymentResponseDTO map(PaymentEntity entity) {

        return PaymentResponseDTO.builder()
                .id(entity.getId())
                .orderId(entity.getOrder().getId())
                .orderNumber(entity.getOrder().getOrderNumber())
                .paymentMethod(entity.getPaymentMethod())
                .paymentStatus(entity.getPaymentStatus())
                .transactionId(entity.getTransactionId())
                .amount(entity.getAmount())
                .paymentDate(entity.getPaymentDate())
                .build();
    }
}
