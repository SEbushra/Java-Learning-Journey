import main.java.com.acmw.model.User;
import java.util.Optional;

public interface UserRepository {
    void save(User user);

    boolean existsByEmail(String email);

    Optional<User> findById(int id);

    Optional<User> findByEmail(String email);

    boolean existsByEmailAndIdNot(String email, int id);
}
