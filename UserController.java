package engine.controller;

import engine.entity.User;
import engine.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/register")
    public void registerUser(@Valid @RequestBody User user) {
        userService.saveUser(user);
    }

}