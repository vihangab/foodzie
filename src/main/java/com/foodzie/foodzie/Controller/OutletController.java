package com.foodzie.foodzie.Controller;


import com.foodzie.foodzie.DAO.OutletDAO;
import com.foodzie.foodzie.Entities.Outlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    @RequestMapping(method = RequestMethod.GET,value = "outlet/all")
    public List<Outlet> getAllOutlets(){
        return outletDAO.findAll(new Sort(Sort.Direction.ASC,"rating"));
    }

    @RequestMapping(method = RequestMethod.POST,value = "/outlet")
    public void createOutlet(@RequestBody Outlet outlet){
        outletDAO.saveAndFlush(outlet);
    }

    @RequestMapping(method = RequestMethod.GET, value = "outlet/delete")
    public void deleteOutlet(@RequestParam("delete_id") Long id) {
        outletDAO.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "outlet/search")
    public List<Outlet> searchOutlet(@RequestParam("keyword") String search){
        return outletDAO.findOutletByNameContainsOrAddressContainsOrCuisineContainsOrderByRating(search,search,search);
    }

}
