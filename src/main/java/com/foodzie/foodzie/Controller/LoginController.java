package com.foodzie.foodzie.Controller;

import com.foodzie.foodzie.DAO.PersonDAO;
import com.foodzie.foodzie.Entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    PersonDAO personDAO;

    @RequestMapping(method = RequestMethod.GET, value = "/signup")
    public String showSignup(Model model) {
        model.addAttribute("Person", new Person());
        return "signup-page";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public String addPerson(Model model, @ModelAttribute Person person) {
        personDAO.saveAndFlush(person);
        return  "redirect:/login-page";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String showLogin(Model model) {
        model.addAttribute("Person", new Person());
        return "login-page";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String loginPerson(Model model, @ModelAttribute Person person) {
        Person loginPerson = personDAO.findByUsernameIs(person.getUsername());
        if (loginPerson.getUsername().isEmpty()) {
            return "Failed";
        } else if (loginPerson.getPassword().equals(person.getPassword())) {
            return "Success" + "Account Type : " + String.valueOf(loginPerson.getAccess());
        }
        return "Failed";
    }

}
