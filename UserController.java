package engine.controller;

import engine.entity.User;
import engine.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


//A controller class responsible for handling HTTP requests related to users
@RestController
public class UserController {

    //A service layer class containing business logic related to users
    @Autowired
    private UserService userService;

    //Handles an HTTP POST request to the "/api/register" URL.
    //Registers a new user by saving the user object passed in the request body.
    //Returns an HTTP status code of 204 (No Content) when successful.
    @PostMapping("/api/register")
    public void registerUser(@Valid @RequestBody User user) {
        userService.saveUser(user);
    }

}
