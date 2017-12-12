package com.foodzie.foodzie.DAO;

import com.foodzie.foodzie.Entities.Outlet;
import com.foodzie.foodzie.Entities.Person;
import com.foodzie.foodzie.Entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDAO extends JpaRepository<Review, Long> {

    public List<Review> findByOutletOrderByRatingDesc(@Param("outlet") Outlet outlet);

    public List<Review> findByPerson(@Param("person")Person person);

}
