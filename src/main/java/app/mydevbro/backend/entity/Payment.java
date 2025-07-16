package app.mydevbro.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paypalPaymentId;
    private String status;
    private Double amount;
    private String currency;

    @OneToOne
    @JoinColumn(name = "shop_project_id")
    private ShopProject shopProject;
}
