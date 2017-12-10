package com.foodzie.foodzie.DAO;

import com.foodzie.foodzie.Entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends JpaRepository<Person,Integer>{
}
