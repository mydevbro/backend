package app.mydevbro.backend.controller;

import app.mydevbro.backend.entity.ShopProject;
import app.mydevbro.backend.entity.User;
import app.mydevbro.backend.service.ShopProjectService;
import app.mydevbro.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ShopProjectController {

    private final ShopProjectService shopProjectService;
    private final UserService userService;

    public ShopProjectController(ShopProjectService shopProjectService, UserService userService) {
        this.shopProjectService = shopProjectService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ShopProject> create(Authentication authentication,
                                              @RequestBody ShopProject project) {
        User user = userService.findByEmail(authentication.getName()).orElseThrow();
        return ResponseEntity.ok(shopProjectService.create(user, project));
    }

    @GetMapping
    public List<ShopProject> list(Authentication authentication) {
        User user = userService.findByEmail(authentication.getName()).orElseThrow();
        return shopProjectService.findByUser(user);
    }
}
