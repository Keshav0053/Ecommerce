package Demo.Ecommerce.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parentCategory;
    @Column(nullable = false)
    private String name;
    @Column(unique = true)
    private String slug;
    private String description;

}
