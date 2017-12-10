package com.foodzie.foodzie.Controller;

import com.foodzie.foodzie.DAO.OutletDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.foodzie.foodzie.Entities.Person;

@Controller
public class RestaurantOwnerController extends PageController
{

    public RestaurantOwnerController()
    {
        outletdao = new OutletDAO();
        //initialise database element here
    }

    public Person getPerson(Model model)
    {
        System.out.println("In name user AdminController");
        Person person = outletdao.getUserDetails(PageController.getPerson().getUsername(),
                PageController.getPerson().getPassword());
        return person;	// name of the jsp file
    }

}