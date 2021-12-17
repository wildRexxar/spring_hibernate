package by.tms.service;

import by.tms.entity.User;
import java.util.List;

public interface Service {

    public abstract void save(User user);

    public abstract User findById(int id);

    public abstract User findByLogin(String login);

    public abstract List<User> findAll();

    public abstract List<User> findAllByLogin(String login);

    public abstract void deleteById(int id);

    public abstract void deleteByLogin(String login);

    public abstract void deleteAll();

    public abstract void update(User user);

    public abstract boolean contains(String login);

    public abstract boolean contains(int id);
}
