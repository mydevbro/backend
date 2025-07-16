package app.mydevbro.backend.controller;

import app.mydevbro.backend.entity.ShopProject;
import app.mydevbro.backend.service.CodeGenerationService;
import app.mydevbro.backend.service.ShopProjectService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/api/download")
public class DownloadController {

    private final ShopProjectService shopProjectService;
    private final CodeGenerationService codeGenerationService;

    public DownloadController(ShopProjectService shopProjectService,
                              CodeGenerationService codeGenerationService) {
        this.shopProjectService = shopProjectService;
        this.codeGenerationService = codeGenerationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FileSystemResource> download(@PathVariable Long id, Authentication authentication) {
        ShopProject project = shopProjectService.findById(id).orElseThrow();
        // TODO: check payment status before allowing download
        File file = codeGenerationService.generateShopCode(project.getId());
        return ResponseEntity.ok(new FileSystemResource(file));
    }
}
