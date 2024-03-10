package app.userman.Repository;

import app.userman.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public boolean existsByPhone(String phone);
    public User findByPhone(String phone);
    public boolean existsByEmail(String email);
    public User findByEmail(String email);
}
