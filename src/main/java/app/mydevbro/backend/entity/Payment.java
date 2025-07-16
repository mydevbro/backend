package app.mydevbro.backend.entity;

import jakarta.persistence.*;

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

    public Payment() {
    }

    public Payment(Long id, String paypalPaymentId, String status, Double amount, String currency, ShopProject shopProject) {
        this.id = id;
        this.paypalPaymentId = paypalPaymentId;
        this.status = status;
        this.amount = amount;
        this.currency = currency;
        this.shopProject = shopProject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaypalPaymentId() {
        return paypalPaymentId;
    }

    public void setPaypalPaymentId(String paypalPaymentId) {
        this.paypalPaymentId = paypalPaymentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public ShopProject getShopProject() {
        return shopProject;
    }

    public void setShopProject(ShopProject shopProject) {
        this.shopProject = shopProject;
    }
}
