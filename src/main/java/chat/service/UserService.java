package chat.service;

import chat.model.User;
import java.util.Optional;

public interface UserService {
    Optional<User> findByLogin(String login);

    User add(String login);
}
