package engine.services;

import engine.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

//Custom implementation of the UserDetails interface from Spring Security.
@Getter
@Setter
public class CustomUserDetails implements UserDetails {
    //The User entity represented by this UserDetails object
    private final User user;

    //Constructs a CustomUserDetails object with the given User entity.
    public CustomUserDetails(User user) {
        super();
        this.user = user;
    }

    //Returns the authorities (i.e. roles) of the user.
    //@return a collection of GrantedAuthority objects representing the user's roles
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
    }

    //Returns the password of the user.
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    //Returns the email of the user.
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    //Shows if user's account is not expired
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //Shows that user's account is not locked
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //Shows that user's credentials are not expired
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    //Returns user's Id
    public Long getId() {
        return user.getId();
    }

}
