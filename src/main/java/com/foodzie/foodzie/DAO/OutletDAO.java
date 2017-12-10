package com.foodzie.foodzie.DAO;

import com.foodzie.foodzie.Entities.Outlet;
import com.foodzie.foodzie.Entities.Person;
import com.foodzie.foodzie.Entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OutletDAO extends JpaRepository<Outlet, Long> {

    public Outlet findById(@Param("Id") Long Id);

}
