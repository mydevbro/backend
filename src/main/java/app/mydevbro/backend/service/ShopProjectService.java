package app.mydevbro.backend.service;

import app.mydevbro.backend.entity.ShopProject;
import app.mydevbro.backend.entity.User;
import app.mydevbro.backend.repository.ShopProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopProjectService {
    private final ShopProjectRepository shopProjectRepository;

    public ShopProjectService(ShopProjectRepository shopProjectRepository) {
        this.shopProjectRepository = shopProjectRepository;
    }

    public ShopProject create(User user, ShopProject project) {
        project.setUser(user);
        return shopProjectRepository.save(project);
    }

    public List<ShopProject> findByUser(User user) {
        return shopProjectRepository.findByUserId(user.getId());
    }

    public Optional<ShopProject> findById(Long id) {
        return shopProjectRepository.findById(id);
    }

    public void delete(Long id) {
        shopProjectRepository.deleteById(id);
    }
}
