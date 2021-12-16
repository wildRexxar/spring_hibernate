package by.tms.dao;

import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class HibernateUserDAO implements UserDAO {


    @Autowired
    private SessionFactory sessionFactory;

    private Session session;

    public void save(User user) {
        try {
            sessionFactory.openSession();
            session.save(user);
        } finally {

        }
    }

    public User findById(int id) {
        try {
            Session session = sessionFactory.openSession();
            User user = session.find(User.class, id);
            return user;
        } finally {
            session.close();
        }
    }

    public User findByLogin(String login) {
        try {
            Session session = sessionFactory.openSession();
            Query<User> query = session.createQuery("FROM User WHERE login = :login", User.class);
            query.setParameter("login", login);
            return query.getSingleResult();
        } finally {
            session.close();
        }
    }
}
