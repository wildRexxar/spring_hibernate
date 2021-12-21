package by.tms.dao;

import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HibernateUserDAO implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.save(user);
        }
    }

    @Override
    public User findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("from User where id = :id", User.class)
                    .setParameter("id", id)
                    .uniqueResult();
        }
    }

    @Override
    public User findByUsername(String username) {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("from User where username like :um", User.class)
                    .setParameter("um", username)
                    .uniqueResult();
        }
    }

    @Override
    public List<User> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("from User", User.class)
                    .getResultList();
        }
    }


    @Override
    public void update(User user, String username, String password) {
        try(Session session = sessionFactory.openSession()) {
            User userFromDB = session
                    .createQuery("from User where username like :un", User.class)
                    .setParameter("un", user.getUsername())
                    .getSingleResult();
            userFromDB.setUsername(username);
            userFromDB.setPassword(password);
        }
    }

    @Override
    public void updateUsernameById(int id, String newUsername) {
        try(Session session = sessionFactory.openSession()) {
            User userFromDB = session
                    .createQuery("from User where id =:id", User.class)
                    .setParameter("id", id)
                    .getSingleResult();
            userFromDB.setUsername(newUsername);
        }
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(User user) {
        try(Session session = sessionFactory.openSession()) {
            session
                    .createQuery("delete User where username like :un")
                    .setParameter("un", user.getUsername())
                    .executeUpdate();
        }
    }

    @Override
    public boolean exist(User user) {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("from User where username like :um and password like :pass")
                    .setParameter("um", user.getUsername())
                    .setParameter("pass", user.getPassword())
                    .uniqueResult() != null;
        }
    }

    @Override
    public boolean existByUsername(String username) {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("from User where username like :um", User.class)
                    .setParameter("um", username)
                    .uniqueResult() != null;
        }
    }

    @Override
    public boolean existById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("from User where id = :id", User.class)
                    .setParameter("id", id).uniqueResult() == null;
        }
    }
}