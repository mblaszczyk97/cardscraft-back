package projektzes.cardscraft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projektzes.cardscraft.services.RoleService;
import projektzes.cardscraft.services.UserService;

@RestController
@RequestMapping("/api")
public class GameController {
    @Autowired
    public GameController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    private final RoleService roleService;
    private final UserService userService;

    @PostMapping("/test")
    String test() {
        return "API TEST";
    }
}
