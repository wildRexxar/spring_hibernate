package by.tms.dao;

import by.tms.entity.User;
import by.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HibernateUserDAO {

    @Autowired
    UserService userService;

    public void save(User user){
        if(userService.contains(user.getLogin())){
            userService.save(user);
        }
    }

    public List<User> findAll () {
        return userService.findAll();
    }

    public User findByLogin(String login) {
        if(userService.contains(login)) {
            return userService.findByLogin(login);
        }
        return null;
    }

    public void update (User user) {
        if(userService.contains(user.getLogin())) {
            userService.update(user);
        }
    }

    public void delete(int id) {
        if(userService.contains(id)) {
            userService.deleteById(id);
        }
    }

    public void deleteByLogin (String login) {
        if(userService.contains(login)) {
            userService.deleteByLogin(login);
        }
    }
}
