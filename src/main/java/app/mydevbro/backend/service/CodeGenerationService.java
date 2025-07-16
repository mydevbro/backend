package app.mydevbro.backend.service;

import org.springframework.stereotype.Service;
import java.io.File;

@Service
public class CodeGenerationService {
    public File generateShopCode(Long projectId) {
        // TODO: implement code generation logic
        return new File("shop-" + projectId + ".zip");
    }
}
