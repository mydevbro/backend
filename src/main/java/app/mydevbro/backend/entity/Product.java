package app.mydevbro.backend.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "shop_project_id")
    private ShopProject shopProject;

    public Product() {
    }

    public Product(Long id, String name, String description, BigDecimal price, String imageUrl, ShopProject shopProject) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.shopProject = shopProject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ShopProject getShopProject() {
        return shopProject;
    }

    public void setShopProject(ShopProject shopProject) {
        this.shopProject = shopProject;
    }
}
