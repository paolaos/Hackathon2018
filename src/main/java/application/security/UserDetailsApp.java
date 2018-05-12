package application.security;

import application.core.user.service.UserService;
import application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserDetailsApp implements UserDetailsService {

    @Autowired
    UserService userService;

    // Abstract method of UserDetailsService.
    // We modified it so that it reads an user from our DB and returns a custom implementation of the
    // Spring Security User class.
    @Override
    public AppUser loadUserByUsername(String userId) throws UsernameNotFoundException {

        // We need a User entity to catch the query result.
        User user = userService.findById(userId);

        // If no user owns that id, then we throw an UsernameNotFoundException
        if (user == null) {
            throw new UsernameNotFoundException("User not found.");
        }

        // Get the user role.
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());

        // Returns a new Spring Security User with our DB information.
        return new AppUser(user.getIdUserPk(), user.getPassword(), Arrays.asList(authority), user.getName());
    }
}
