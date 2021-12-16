package by.tms.entity;

import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "not blank")
    @Size(min = 4, message = "login must be min 4 symbols")
    private String login;

    @NotBlank(message = "not blank")
    @Size(min = 4, message = "login must be min 4 symbols")
    private String password;

    @Autowired
    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return id+ " " + login;
    }

}