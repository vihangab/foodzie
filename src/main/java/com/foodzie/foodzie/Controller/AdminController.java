package com.foodzie.foodzie.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.foodzie.foodzie.Entities.Person;

@Controller
public class AdminController extends PageController
{


    public AdminController()
    {
        admindao = new AdminDAO();
        //initialise database element here
    }

    public Person getPerson(Model model)
    {
        System.out.println("In name user AdminController");
        Person person = admindao.getUserDetails(PageController.getPerson().getUsername(),
                PageController.getPerson().getPassword());
        return person;	// name of the jsp file
    }

}