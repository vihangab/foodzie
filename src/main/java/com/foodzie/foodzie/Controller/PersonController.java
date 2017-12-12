package com.foodzie.foodzie.Controller;

import com.foodzie.foodzie.DAO.PersonDAO;
import com.foodzie.foodzie.DAO.ReviewDAO;
import com.foodzie.foodzie.Entities.Person;
import com.foodzie.foodzie.Entities.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonDAO personDAO;

    @Autowired
    private ReviewDAO reviewDAO;

    @RequestMapping("/welcome")
    public String Welcome() {
        return "Welcome to Foodzie";
    }

    @RequestMapping("/person/all")
    public String getPersons(Model model) {
        List<Person> persons = new ArrayList<>();
        personDAO.findAll()
                .forEach(persons::add);
        model.addAttribute("persons", persons);
        return "allperson-page";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/person/{stringId}")
    public String getPerson(Model model,@PathVariable String stringId) {
        int Id = Integer.valueOf(stringId);
        Person person = personDAO.findOne(Id);
        model.addAttribute(person);
        List<Review> reviews = reviewDAO.findByPerson(person);
        model.addAttribute("reviews",reviews);
        return "person-page";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/person/delete")
    public String deletePerson(Model model, @RequestParam ("person_id") Integer id){
        Person person = personDAO.findByIdIs(id);
        personDAO.delete(person);
        return "redirect:/admin";
    }

}
