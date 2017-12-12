package com.foodzie.foodzie.Controller;


import com.foodzie.foodzie.DAO.OutletDAO;
import com.foodzie.foodzie.DAO.PersonDAO;
import com.foodzie.foodzie.DAO.ReviewDAO;
import com.foodzie.foodzie.Entities.Outlet;
import com.foodzie.foodzie.Entities.Person;
import com.foodzie.foodzie.Entities.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReviewController {

    @Autowired
    private ReviewDAO reviewDAO;
    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private OutletDAO outletDAO;

    @RequestMapping(method = RequestMethod.GET, value = "/review/id/{id}")
    public String getReviewById(Model model, @PathVariable String id) {
        Review review = reviewDAO.findOne(Long.parseLong(id));
        model.addAttribute("outlet_name", new String(review.getOutlet().getName()));
        model.addAttribute("outlet_address", new String(review.getOutlet().getAddress()));
        model.addAttribute("outlet_cuisine", new String(review.getOutlet().getCuisine()));
        model.addAttribute("outlet_rating", new String(String.valueOf(review.getOutlet().getRating())));
        model.addAttribute("comment", new String(review.getComment()));
        model.addAttribute("review_rating", new String(String.valueOf(review.getRating())));
        model.addAttribute("person_name", new String(review.getPerson().getName()));
        model.addAttribute("review", review);
        return "review-page";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/review/all")
    public String getAllReviews(Model model) {
        List<Review> reviews = reviewDAO.findAll(new Sort(Sort.Direction.ASC, "person.name"));
        model.addAttribute("reviews",reviews);
        return "allreview-page";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/review/find/outlet")
    public List<Review> getAllReviewsForOutlet(@RequestParam("outlet_id") Long outletId) {
        final Outlet outlet = outletDAO.findOne(outletId);
        return reviewDAO.findByOutletOrderByRatingDesc(outlet);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/review/find/person")
    public List<Review> getAllReviewsForPerson(@RequestParam("person_id") Integer personId) {
        final Person person = new Person();
        person.setId(personId);
        return reviewDAO.findByPerson(person);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/review/add")
    public String showAddReview(Model model) {
        Outlet outlet = outletDAO.findById(outletDAO.outlet.getId());
        model.addAttribute("outlet_name", new String(outlet.getName()));
        model.addAttribute("outlet_id", new String(String.valueOf(outlet.getId())));
        model.addAttribute(new Review());
        return "add-review-page";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/review/add")
    public String createReview(Model model, @ModelAttribute Review review) {
        final Review.Builder reviewBuilder = new Review.Builder(review);
        final Person person = personDAO.findByIdIs(review.getPerson().getId());
        final Outlet outlet = outletDAO.findById(review.getOutlet().getId());
        reviewDAO.saveAndFlush(reviewBuilder.person(person)
                .outlet(outlet)
                .build());
        return "redirect:/outlet/" + String.valueOf(outlet.getId());
    }

    @RequestMapping(method = RequestMethod.GET, value = "review/delete")
    public String deleteReview(Model model, @RequestParam("delete_id") Long id) {
        reviewDAO.delete(id);
        return "redirect:/outlet/all";
    }
}
