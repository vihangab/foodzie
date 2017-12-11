package com.foodzie.foodzie.Controller;


import com.foodzie.foodzie.DAO.OutletDAO;
import com.foodzie.foodzie.DAO.PersonDAO;
import com.foodzie.foodzie.DAO.ReviewDAO;
import com.foodzie.foodzie.Entities.Outlet;
import com.foodzie.foodzie.Entities.Person;
import com.foodzie.foodzie.Entities.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewDAO reviewDAO;
    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private OutletDAO outletDAO;

    @RequestMapping(method = RequestMethod.GET, value = "/review/id/{id}")
    public Review getReviewById(@PathVariable String id) {
        return reviewDAO.findOne(Long.parseLong(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/review")
    public List<Review> getAllReviews() {
        return reviewDAO.findAll(new Sort(Sort.Direction.ASC, "rating"));
    }


    @RequestMapping(method = RequestMethod.GET, value = "/review/find/outlet")
    public List<Review> getAllReviewsForOutlet(@RequestParam("outlet_id") Long outletId) {
        final Outlet outlet = new Outlet();
        outlet.setId(outletId);
//        return reviewDAO.findAll(Example.of(new Review.Builder().outlet(outlet).build()));
        return reviewDAO.findByOutlet(outlet);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/review/find/person")
    public List<Review> getAllReviewsForPerson(@RequestParam("person_id") Integer personId) {
        final Person person = new Person();
        person.setId(personId);
//        return reviewDAO.findAll(Example.of(new Review.Builder().outlet(outlet).build()));
        return reviewDAO.findByPerson(person);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/review")
    public void createReview(@RequestBody Review review) {
        final Review.Builder reviewBuilder = new Review.Builder(review);
        final Person person = personDAO.findByIdIs(review.getPerson().getId());
        final Outlet outlet = outletDAO.findById(review.getOutlet().getId());
        reviewDAO.saveAndFlush(reviewBuilder.person(person)
                .outlet(outlet)
                .build());
    }

    @RequestMapping(method = RequestMethod.GET, value = "review/delete")
    public void deleteReview(@RequestParam("delete_id") Long id) {
        reviewDAO.delete(id);
    }
}
