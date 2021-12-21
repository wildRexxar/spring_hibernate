package dao;

import by.tms.dao.HibernateUserDAO;
import by.tms.entity.User;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;

class HibernateUserDAOTest {

    @Autowired
    HibernateUserDAO hibernateUserDAO;

    @Before
    public void addTenUsersForDB(){
        for(int i =0; i < 10; i++) {
            hibernateUserDAO.save(new User("username" + i, "password" + i));
        }
    }

    @Test
    void getTenUsers() {
        int numbersOfUsers = hibernateUserDAO.findAll().size();
        assertEquals(10, numbersOfUsers);
    }

    @Test
    void getUserByUsername() {
        User user = hibernateUserDAO.findByUsername("username5");
        assertEquals("password5", user.getPassword());
    }

    @Test
    void getUserById() {
        User user = hibernateUserDAO.findById(0);
        assertEquals("username0", user.getUsername());
        assertEquals("password0", user.getPassword());
    }

    @Test
    void existAndDeleteUser(){
        User user1 = new User("username5", "password5");
        User user2 = new User("username5", "password5");
        hibernateUserDAO.delete(user2);
        assertTrue(hibernateUserDAO.exist(user1));
        assertFalse(hibernateUserDAO.exist(user2));
    }

    @Test
    void existUserByUsername(){
        String username1 = "username3";
        String username2 = "username333";
        assertTrue(hibernateUserDAO.existByUsername(username1));
        assertFalse(hibernateUserDAO.existByUsername(username2));
    }

    @Test
    void existUserById(){
        hibernateUserDAO.deleteById(6);
        assertTrue(hibernateUserDAO.existById(5));
        assertFalse(hibernateUserDAO.existById(6));
    }

    @Test
    void updateUser(){
        User user1 = new User("username3", "password3");
        User user2 = new User ("username99", "password99");
        hibernateUserDAO.update(user1, user2.getUsername(), user2.getPassword());
        assertTrue(hibernateUserDAO.exist(user2));
        assertFalse(hibernateUserDAO.exist(user1));
    }

    @Test
    void updateUserById(){
        String username = "test44";
        hibernateUserDAO.updateUsernameById(4, username);
        User user = hibernateUserDAO.findById(4);
        assertEquals(username, user.getUsername());
    }

}