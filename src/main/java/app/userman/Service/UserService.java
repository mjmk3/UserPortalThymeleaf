package app.userman.Service;

import app.userman.Entity.User;
import org.springframework.stereotype.Service;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

@Service
public interface UserService {
    User createUser(User user);
    boolean checkPhone(String phone);
}
