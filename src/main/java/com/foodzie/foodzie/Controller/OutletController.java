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
    public String getOutletById(Model model,@PathVariable String id) {
        Outlet outlet = outletDAO.findOne(Long.parseLong(id));
        List<Review> reviews = reviewDAO.findByOutlet(outlet);
        model.addAttribute("name",new String(outlet.getName()));
        model.addAttribute("address",new String(outlet.getAddress()));
        model.addAttribute("cuisine",new String(outlet.getCuisine()));
        model.addAttribute("rating",new String(String.valueOf(outlet.getRating())));
        model.addAttribute("reviews",reviews);
        return "outlet-page";

    }

    @RequestMapping(method = RequestMethod.GET, value = "outlet/all")
    public String getAllOutlets(Model model) {
        List<Outlet> outlets = outletDAO.findAll(new Sort(Sort.Direction.ASC, "rating"));
        model.addAttribute("outlets", outlets);
        return "alloutlets-page";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/outlet")
    public void createOutlet(@RequestBody Outlet outlet) {
        outletDAO.saveAndFlush(outlet);
    }

    @RequestMapping(method = RequestMethod.GET, value = "outlet/delete")
    public void deleteOutlet(@RequestParam("delete_id") Long id) {
        outletDAO.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "outlet/search")
    public List<Outlet> searchOutlet(@RequestParam("keyword") String search) {
        return outletDAO.findOutletByNameContainsOrAddressContainsOrCuisineContainsOrderByRating(search, search, search);
    }

}
