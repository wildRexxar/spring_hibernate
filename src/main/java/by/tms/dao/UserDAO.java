package by.tms.dao;

import by.tms.entity.User;

public interface UserDAO {
    void save(User user);
    User findById(int id);
    User findByLogin(String login);
}
