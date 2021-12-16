package by.tms.dao;

import by.tms.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryUserDAO implements UserDAO {
    private final List<User> users = new ArrayList<>();
    private int count;

    public void save(User user) {
        user.setId(++count);
        users.add(user);
    }

    @Override
    public User findById(int id) {
        return null;
    }

    public User findByLogin(final String login) {
        return users.stream().filter(user -> user.getLogin().equals(login)).findAny().orElse(null);
    }
}
