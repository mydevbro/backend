package app.mydevbro.backend.repository;

import app.mydevbro.backend.entity.ShopProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopProjectRepository extends JpaRepository<ShopProject, Long> {
    List<ShopProject> findByUserId(Long userId);
}
