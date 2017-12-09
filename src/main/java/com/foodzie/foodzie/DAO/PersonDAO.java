package com.foodzie.foodzie.DAO;

import com.foodzie.foodzie.Entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDAO extends JpaRepository<Person,Long>{
}
