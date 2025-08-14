package com.sebastianmatallana.ecommerce.backend.infrastructure.rest;

import com.sebastianmatallana.ecommerce.backend.application.UserService;
import com.sebastianmatallana.ecommerce.backend.domain.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
//http://localhost:8080
@RequestMapping("/api/v1/users")
//http://localhost:8080/api/v1/users
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return this.userService.save(user);
    }

    //http://localhost:8080/api/v1/users/id
    @GetMapping("/{id}")
    public User findUserById (@PathVariable Integer id) {
        return this.userService.findById(id);
    }
}
