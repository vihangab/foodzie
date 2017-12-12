package com.foodzie.foodzie.DAO;

import com.foodzie.foodzie.Entities.Outlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutletDAO extends JpaRepository<Outlet, Long> {

    Outlet outlet = new Outlet();

    public Outlet findById(@Param("Id") Long Id);

    public List<Outlet> findOutletByNameContainsOrAddressContainsOrCuisineContainsOrderByRatingDesc(@Param("name") String name, @Param("address") String address, @Param("cuisine") String cuisine);

}
