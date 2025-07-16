package app.mydevbro.backend.service;

import app.mydevbro.backend.entity.Product;
import app.mydevbro.backend.entity.ShopProject;
import app.mydevbro.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(ShopProject project, Product product) {
        product.setShopProject(project);
        return productRepository.save(product);
    }

    public List<Product> findByProject(Long projectId) {
        return productRepository.findByShopProjectId(projectId);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
