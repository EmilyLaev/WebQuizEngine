package engine.services;

import engine.entity.User;
import engine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

//A service implementation class for the User entity.
//Implements the UserService and UserDetailsService interfaces.
@Service
public class UserServiceInp implements UserService, UserDetailsService {

    //a repository interface for the User entity
    @Autowired
    private UserRepository userRepository;
    //An object that can be used to encode passwords
    @Autowired
    private PasswordEncoder passwordEncoder;

    //Saves the user's data to the main database
    @Override
    public void saveUser(User user) {
        if (user == null || userRepository.findByEmail(user.getEmail()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        User current = new User();
        current.setEmail(user.getEmail());
        current.setPassword(passwordEncoder.encode(user.getPassword()));
        current.setRole("USER");
        userRepository.save(current);
    }

    //A method to retrive user data by entering the username
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return new CustomUserDetails(user);
    }
}
