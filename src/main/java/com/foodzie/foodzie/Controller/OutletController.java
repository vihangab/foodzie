package com.foodzie.foodzie.Controller;


import com.foodzie.foodzie.DAO.OutletDAO;
import com.foodzie.foodzie.DAO.PersonDAO;
import com.foodzie.foodzie.DAO.ReviewDAO;
import com.foodzie.foodzie.Entities.Outlet;
import com.foodzie.foodzie.Entities.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OutletController {

    private static final Logger log = LoggerFactory.getLogger(OutletController.class);

    @Autowired
    private OutletDAO outletDAO;

    @RequestMapping(method = RequestMethod.GET,value = "/outlet/{id}")
    public Outlet getOutletById(@PathVariable String id){
        return outletDAO.findOne(Long.parseLong(id));
    }

//
//    @RequestMapping(method = RequestMethod.GET, value = "/review")
//    public List<Review> getAllReviews() {
//        final List<Review> reviews = reviewDAO.findAll();
//        return reviews;
//    }

    @RequestMapping(method = RequestMethod.POST,value = "/outlet")
    public void createOutlet(@RequestBody Outlet outlet){
//        log.info("Review is {}", review);
//        final Person person = personDAO.findByIdIs(review.getPerson().getId());
//        final Outlet outlet = outletDAO.findById(review.getOutlet().getId());
//        review.setPerson(person);
//        review.setOutlet(outlet);
        outletDAO.saveAndFlush(outlet);
    }

}
