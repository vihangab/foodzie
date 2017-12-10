package com.foodzie.foodzie.Controller;

import static java.lang.System.*;
import com.foodzie.foodzie.Entities.Person;

    public class PageControllerFactory
    {

        public static String createPageController(Person person)
        {
            String page = "";
            if(person.getAccess() == 4)
            {
                System.out.println("Created UserController");
                PageController.setPgctrl(new UserController());
                page = "/user";
            }
            else if(person.getAccess() == 3)
            {
                System.out.println("Created CriticController");
                PageController.setPgctrl(new CriticController());
                page = "/critic";
            }
            else if(person.getAccess() == 2)
            {
                System.out.println("Created RestraurantOwnerController");
                PageController.setPgctrl(new RestaurantOwnerController());
                page = "/restraurant";
            }
            else if(person.getAccess() == 1)
            {
                System.out.println("Created AdminController");
                PageController.setPgctrl(new AdminController());
                page = "/admin";
            }
            return page;
        }
    }
