package engine.repository;

import engine.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//A repository interface for the User entity.
//Used to perform CRUD operations on User objects in the database.
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Retrieves a User object from the database by its email address
    User findByEmail(String email);

}
