package by.tms.controller;

import by.tms.dao.HibernateUserDAO;
import by.tms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    private final HibernateUserDAO hibernateUserDAO;

    @Autowired
    public UserController(HibernateUserDAO hibernateUserDAO) {
        this.hibernateUserDAO = hibernateUserDAO;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        System.out.println("before validation");
        if (hibernateUserDAO.existByUsername(user.getUsername()) == false) {
            hibernateUserDAO.save(user);
            return "redirect:/";
        } else {
            model.addAttribute("message", "Such a user exist");
            return "registration";
        }
    }


    @GetMapping("/authorization")
    public String authorization(Model model) {
        model.addAttribute("user", new User());
        return "authorization";
    }

    @PostMapping("/authorization")
    public String authorization(@ModelAttribute("user") User user, Model model, HttpSession session) {
        if(hibernateUserDAO.existByUsername(user.getUsername())) {
            User userFromDB = hibernateUserDAO.findByUsername(user.getUsername());
            if(userFromDB.getPassword().equals(user.getPassword())) {
                session.setAttribute("authUser", user);
                return "redirect:/";
            } else {
                model.addAttribute("message", "Wrong password");
                return "authorization";
            }
        } else {
            model.addAttribute("message", "User does not exist");
            return "authorization";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
