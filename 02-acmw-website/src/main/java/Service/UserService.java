import java.util.Optional;

import main.jUserServicew.model.User;

public class UserService {
    private UserRepository userRepository;
    private final PasswordHasher passwordHasher;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        passwordHasher = new PasswordHasher();
    }

    public User registerUser(String fullName, String email, String password) {

        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already exists.");
        }

        String hashedPassword = passwordHasher.hashPassword(password);

        User user = new User(fullName, email, hashedPassword);

        userRepository.save(user);

        return user;
    }

    public User loginUser(String email, String password) {
        Optional<User> result = userRepository.findByEmail(email);

        if (result.isEmpty()) {
            throw new IllegalArgumentException("Invalid email ");
        }

        User user = result.get();

        if (!passwordHasher.verifyPassword(password, user.getHashedPassword())) {
            throw new IllegalArgumentException("Invalid password.");
        }

        return user;
    }

    public User updateProfile(User user, String email, String name) {
        if (userRepository.existsByEmailAndIdNot(email, user.getId())) {
            throw new IllegalArgumentException("Email already exists.");
        }
        user.setEmail(email);
        user.setFullName(name);

        userRepository.save(user);

        return user;
    }

    public User changePassword(User user, String password) {
        String hashedPassword = passwordHasher.hashPassword(password);

        User.setPassword(hashedPassword);

        userRepository.save(User);

        return user;
    }

    getUserById(){

    }

}
