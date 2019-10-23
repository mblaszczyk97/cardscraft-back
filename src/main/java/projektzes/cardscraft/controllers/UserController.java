package projektzes.cardscraft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projektzes.cardscraft.models.RoleEnum;
import projektzes.cardscraft.models.User;
import projektzes.cardscraft.services.RoleService;
import projektzes.cardscraft.services.UserService;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final RoleService roleService;
    private final UserService userService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Map> login(@RequestBody User user) {
        user.setPassword(user.getPassword());
        if(userService.authorize(user))
            return ResponseEntity.ok(Collections.singletonMap("token", userService.generateToken(user)));
           // return ResponseEntity.ok( JSON(userService.generateToken(user));//return new ResponseEntity<>(,HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping("/register")
    ResponseEntity<String> register(@RequestBody User user) {
        user.setPassword(userService.hashPassword(user.getPassword()));
        user.setRole(roleService.getRole(RoleEnum.USER));
        user.setLvl(0);
        user.setDecks(new HashSet<>());
        userService.register(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/check")
    ResponseEntity<User> check(@RequestHeader("Authorization") String token) {
        User user = userService.getUserByToken(token);
        if(user == null) return new ResponseEntity<> (HttpStatus.FORBIDDEN);
        else return new ResponseEntity<User> (user, HttpStatus.OK);
    }

}

