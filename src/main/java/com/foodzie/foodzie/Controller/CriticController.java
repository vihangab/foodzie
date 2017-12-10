package com.foodzie.foodzie.Controller;

import com.foodzie.foodzie.DAO.ReviewDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.foodzie.foodzie.Entities.Person;

@Controller
public class CriticController extends PageController
{


    public CriticController()
    {
        reviewdao = new ReviewDAO();
        //initialise database element here
    }

    public Person getPerson(Model model)
    {
        System.out.println("In name user CriticController");
        Person person = reviewdao.getUserDetails(PageController.getPerson().getUsername(),
                PageController.getPerson().getPassword());
        return person;	// name of the jsp file
    }

}
