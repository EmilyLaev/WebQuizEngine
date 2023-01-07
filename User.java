package engine.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//a class representing a user in the application.
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    //The unique identifier of the user.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //The email address of the user
    @NotNull
    @Email(regexp = ".+@.+\\..+")
    private String email;
    //The password of the user
    @NotNull
    @Size(min = 5)
    private String password;
    //The role of the user (such as "admin", "moderator", etc.)
    private String role;

}
