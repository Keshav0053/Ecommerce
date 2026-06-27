package Demo.Ecommerce.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "product_variants")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductVariantEntity {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID")
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;
    @Column(length = 50)
    private String size;
    @Column(length = 50)
    private String color;
    @Column(unique = true, length = 100)
    private String barcode;
    @Column(precision = 12, scale = 2)
    private BigDecimal price;
    @Column(name = "sale_price", precision = 12, scale = 2)
    private BigDecimal salePrice;
    @Column(name = "stock_quantity")
    private Integer stockQuantity;
    @Column(precision = 10, scale = 2)
    private BigDecimal weight;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
