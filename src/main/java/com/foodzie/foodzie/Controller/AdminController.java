package com.foodzie.foodzie.Controller;


import com.foodzie.foodzie.DAO.PersonDAO;
import com.foodzie.foodzie.Entities.Outlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private PersonDAO adminDAO;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String showAdminPage(Model model){
        model.addAttribute("name",new String(adminDAO.person.getName()));
        return "admin-page";
    }
}
