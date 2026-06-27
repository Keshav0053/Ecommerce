package Demo.Ecommerce.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressEntity {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID")
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(length = 150)
    private String name;
    @Column(length = 15)
    private String mobile;
    @Column(name = "address_line1", columnDefinition = "TEXT")
    private String addressLine1;
    @Column(name = "address_line2", columnDefinition = "TEXT")
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    @Column(length = 10)
    private String pincode;
    @Column(name = "is_default")
    private Boolean isDefault;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        if (isDefault == null) {
            isDefault = false;
        }
    }
}
