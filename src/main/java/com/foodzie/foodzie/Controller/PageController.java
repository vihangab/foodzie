package com.foodzie.foodzie.Controller;

import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foodzie.foodzie.Entities.Person;

@Controller
public class PageController
{

    static protected Person person;
    static private PageController pgctrl = null;

    public static Person getPerson() {
        return person;
    }
    public static void setPerson(Person person)
    {
        PageController.person = person;
    }
    public static PageController getPgctrl() {
        return pgctrl;
    }
    public static void setPgctrl(PageController pgctrl) {
        PageController.pgctrl = pgctrl;
    }

    @RequestMapping("/person")
    public @ResponseBody Map<String, Person> getPersonDetails(Model model)
    {
        Map<String, Person> map = new HashMap<String, Person>();
        System.out.println("In getPersonDetails PageController");
        if(PageController.getPerson() == null)
            return null;
        map.put("personDetails", person);
        return map;
    }

}
