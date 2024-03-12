package app.userman.Filter;

import app.userman.Entity.User;
import app.userman.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

@Service
public class CustomerUserDetails implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public CustomerUserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        User user = userRepository.findByPhone(phone);
        if (user != null) {
            return new UserPrincipal(user);
        }
        throw new UsernameNotFoundException("user not available");
    }
}
