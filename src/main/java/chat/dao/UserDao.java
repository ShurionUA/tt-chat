package chat.dao;

import chat.model.User;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> findByLogin(String login);
}
