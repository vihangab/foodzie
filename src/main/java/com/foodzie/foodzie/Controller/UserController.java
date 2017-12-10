package com.foodzie.foodzie.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.foodzie.foodzie.Entities.Person;

@Controller
public class UserController extends PageController
{


    public UserController()
    {
        persondao = new PersonDAO();
    }

    public Person getPerson(Model model)
    {
        System.out.println("In name user UserController");
        Person person = persondao.getUserDetails(PageController.getPerson().getUsername(),
                PageController.getPerson().getPassword());
        return person;	// name of the jsp file
    }

}
