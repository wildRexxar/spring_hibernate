package by.tms.service;

import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserService implements Service{

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public User findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    public User findByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("from User where login like :login", User.class)
                .setParameter("login", login)
                .getSingleResult();
    }

    public List<User> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("from User", User.class)
                .getResultList();
    }

    public List<User> findAllByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("from User where login = :login", User.class)
                .setParameter("login", login)
                .getResultList();
    }

    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        session.delete(user);
    }

    public void deleteByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        session
                .createQuery("delete User where login like :login")
                .setParameter("login", login)
                .executeUpdate();
    }

    public void deleteAll() {
        Session session = sessionFactory.getCurrentSession();
        session
                .createQuery("delete User")
                .executeUpdate();
    }

    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        User userFromDB = session
                .createQuery("from User where login like :login", User.class)
                .setParameter("login", user.getLogin())
                .getSingleResult();
        userFromDB.setLogin(user.getLogin());
        userFromDB.setPassword(user.getPassword());
    }

    public boolean contains(String login) {
        Session currentSession = sessionFactory.getCurrentSession();
        Integer indicator = (Integer) currentSession
                .createQuery("select count(*) from User where login like :login")
                .setParameter("login", login)
                .uniqueResult();
        return indicator > 0;
    }

    public boolean contains(int id) {
        Session session = sessionFactory.getCurrentSession();
        Integer indicator = session
                .createQuery("select count(*) from User where id = :id", Integer.class)
                .setParameter("id", id)
                .uniqueResult();
        return indicator > 0;
    }
}