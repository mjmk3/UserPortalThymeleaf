package app.userman.Impl;

import app.userman.Entity.User;
import app.userman.Repository.UserRepository;
import app.userman.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncode;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncode) {
        this.userRepository = userRepository;
        this.passwordEncode = passwordEncode;
    }

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncode.encode(user.getPassword()));
        user.setRole("USER");

        return userRepository.save(user);
    }

    @Override
    public boolean checkPhone(String phone) {
        return userRepository.existsByPhone(phone);
    }
}
