package app.userman.Controller;

import app.userman.Entity.User;
import app.userman.Repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;

    @ModelAttribute
    private void userDetails(Model m, Principal p) {
        String phone = p.getName();
        User user = userRepository.findByPhone(phone);

        m.addAttribute("user", user);

    }

    @GetMapping("/")
    public String home() {
        return "user/home";
    }
}
