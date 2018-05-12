package application.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * In order to use extra fields from our database in our security context,
 * we need to extends the
 */
public class AppUser extends User {

    // Here we add the extra fields of our users.
    private final String realName;
    private static final long serialVersionUID = 1L;

    public AppUser(String username, String password, Collection<GrantedAuthority> authorities, String realName) {
        super(username, password, authorities);
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }
}
