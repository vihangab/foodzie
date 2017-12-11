package com.foodzie.foodzie.Controller;


import com.foodzie.foodzie.DAO.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private PersonDAO adminDAO;


}
