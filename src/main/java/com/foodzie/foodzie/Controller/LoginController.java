package com.foodzie.foodzie.Controller;

import com.foodzie.foodzie.DAO.PersonDAO;
import com.foodzie.foodzie.Entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    PersonDAO personDAO;

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public void addPerson(@RequestBody Person person) {
        personDAO.saveAndFlush(person);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String loginPerson(@RequestBody Person person){
        Person loginPerson = personDAO.findByUsernameIs(person.getUsername());
        if (loginPerson.getUsername().isEmpty()){
            return "Failed";
        }
        else if(loginPerson.getPassword().equals(person.getPassword())){
            return "Success" + "Account Type : "  + String.valueOf(loginPerson.getAccess());
        }
        return "Failed - ";
    }

}
