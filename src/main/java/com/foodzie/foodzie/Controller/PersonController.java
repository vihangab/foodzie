package com.foodzie.foodzie.Controller;

import com.foodzie.foodzie.DAO.PersonDAO;
import com.foodzie.foodzie.Entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonDAO personDAO;

    @RequestMapping("/welcome")
    public String Welcome() {
        return "Welcome to Foodzie";
    }

    @RequestMapping("/persons")
    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        personDAO.findAll()
                .forEach(persons::add);
        return persons;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/person/{stringId}")
    public Person getPerson(@PathVariable String stringId) {
        int Id = Integer.valueOf(stringId);
        return personDAO.findOne(Id);
    }


}
