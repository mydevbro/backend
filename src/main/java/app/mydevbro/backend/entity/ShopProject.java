package app.mydevbro.backend.entity;

import jakarta.persistence.*;
import java.util.List;


@Entity
public class ShopProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shopName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "shopProject", cascade = CascadeType.ALL)
    private List<Product> products;

    @OneToOne(mappedBy = "shopProject", cascade = CascadeType.ALL)
    private Payment payment;

    public ShopProject() {
    }

    public ShopProject(Long id, String shopName, User user, List<Product> products, Payment payment) {
        this.id = id;
        this.shopName = shopName;
        this.user = user;
        this.products = products;
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
