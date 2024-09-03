package star.bucks.framework.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CustomUserDetailManager implements UserDetailsManager {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        String password = new BCryptPasswordEncoder().encode("password");
        if("admin".equals(userName)){
            return new User("admin",password,true,true,true,true, Arrays.asList(new SimpleGrantedAuthority("ADMIN")));

        }
        return new User("admin",password,true,true,true,true, Arrays.asList(new SimpleGrantedAuthority("USER")));
    }

    @Override
    public void createUser(UserDetails userDetails) {

    }

    @Override
    public void updateUser(UserDetails userDetails) {

    }

    @Override
    public void deleteUser(String s) {

    }

    @Override
    public void changePassword(String s, String s1) {

    }

    @Override
    public boolean userExists(String s) {
        return false;
    }
}
