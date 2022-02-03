package chat.service.impl;

import chat.dao.UserDao;
import chat.lib.Inject;
import chat.lib.Service;
import chat.model.User;
import chat.service.UserService;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    @Override
    public Optional<User> findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Override
    public User add(String login) {
        User user = new User();
        user.setName(login);
        return userDao.add(user);
    }
}
