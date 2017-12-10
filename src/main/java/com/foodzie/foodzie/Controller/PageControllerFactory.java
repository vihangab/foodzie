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
                PageController.setpgctrl(new UserController());
                page = "/user";
            }
            else if(user.getAccess() == 3)
            {
                System.out.println("Created CriticController");
                PageController.setpgctrl(new CriticController());
                page = "/critic";
            }
            else if(user.getAccess() == 2)
            {
                System.out.println("Created RestraurantOwnerController");
                PageController.setpgctrl(new RestraurantOwnerController());
                page = "/restraurant";
            }
            else if(user.getAccess() == 1)
            {
                System.out.println("Created AdminController");
                PageController.setpgctrl(new AdminController());
                page = "/admin";
            }
            return page;
        }
    }
