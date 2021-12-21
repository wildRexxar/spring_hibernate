package by.tms.dao;

import by.tms.entity.User;

import java.util.List;

public interface UserDAO {
    void save(User user);

    User findById(int id);

    User findByUsername(String username);

    List<User> findAll();

    void update(User user, String username, String password);

    void updateUsernameById(int id, String newUsername);

    void deleteById(int id);

    void delete(User user);

    boolean exist(User user);

    boolean existByUsername(String username);

    boolean existById(int id);

}

