package engine.services;

import engine.entity.User;

//A service interface for the User entity
//Saves a User object to the database
public interface UserService {

    void saveUser(User user);
}
