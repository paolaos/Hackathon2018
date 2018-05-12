package application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsApp userDetails;

    public WebSecurityConfig() {
        super();
    }

    // Read users from the our implementation of UserDetailsService.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        try {
            auth.userDetailsService(userDetails)
                    .passwordEncoder(new BCryptPasswordEncoder());
        } catch (UsernameNotFoundException e) {
            throw new Exception(e.getMessage());
        }
    }

    // Set up Spring Security behavior. Here we decide our security rules,
    // like which role is capable of executing what actions.
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests().anyRequest().authenticated()
                // We need to allow anyone to enter our login page.
                .and().formLogin().loginPage("/login").permitAll()
                .and().httpBasic()
                // Logout configuration.
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").deleteCookies("auth_code", "JSESSIONID").invalidateHttpSession(true)
                // Allow the application to remember logged users.
                .and().rememberMe().key("uniqueAndSecret")
                .and().csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) {
        web
                // Disable cache and allow anyone to access the resource files.
                .debug(false)
                .ignoring()
                .antMatchers("/resources/**","/static/**", "/css/**", "/js/**", "/images/**", "/fonts/**");
    }

}
