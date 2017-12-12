package com.foodzie.foodzie.Controller;


import com.foodzie.foodzie.DAO.OutletDAO;
import com.foodzie.foodzie.DAO.ReviewDAO;
import com.foodzie.foodzie.Entities.Outlet;
import com.foodzie.foodzie.Entities.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OutletController {

    private static final Logger log = LoggerFactory.getLogger(OutletController.class);

    @Autowired
    private OutletDAO outletDAO;

    @Autowired
    private ReviewDAO reviewDAO;

    @RequestMapping(method = RequestMethod.GET, value = "/outlet/{id}")
    public String getOutletById(Model model, @PathVariable String id) {
        Outlet outlet = outletDAO.findOne(Long.parseLong(id));
        outletDAO.outlet.setId(outlet.getId());
        List<Review> reviews = reviewDAO.findByOutletOrderByRatingDesc(outlet);
        model.addAttribute("name", new String(outlet.getName()));
        model.addAttribute("address", new String(outlet.getAddress()));
        model.addAttribute("cuisine", new String(outlet.getCuisine()));
        model.addAttribute("rating", new String(String.valueOf(outlet.getRating())));
        model.addAttribute("reviews", reviews);
        model.addAttribute(outlet);
        return "outlet-page";

    }

    @RequestMapping(method = RequestMethod.GET, value = "outlet/all")
    public String getAllOutlets(Model model) {
        List<Outlet> outlets = outletDAO.findAll(new Sort(Sort.Direction.DESC, "rating"));
        model.addAttribute("outlets", outlets);
        return "alloutlets-page";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/outlet/add")
    public String viewAddOutlet(Model model) {
        model.addAttribute(new Outlet());
        return "add-outlet-page";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/outlet/add")
    public String createOutlet(Model model, @ModelAttribute Outlet outlet) {
        outletDAO.saveAndFlush(outlet);
        return "redirect:/outlet/all";
    }

    @RequestMapping(method = RequestMethod.GET, value = "outlet/delete")
    public String deleteOutlet(@RequestParam("delete_id") Long id) {
        Outlet outlet = outletDAO.findById(id);
        outletDAO.delete(id);
        return "redirect:/outlet/all";
    }

    @RequestMapping(method = RequestMethod.GET, value = "outlet/search")
    public String searchOutlet(Model model, @RequestParam("keyword") String search) {
        List<Outlet> outlets = outletDAO.findOutletByNameContainsOrAddressContainsOrCuisineContainsOrderByRatingDesc(search, search, search);
        model.addAttribute("outlets", outlets);
        return "alloutlets-page";
    }

}
