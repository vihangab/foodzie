package com.foodzie.foodzie.DAO;

import com.foodzie.foodzie.Entities.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDAO extends JpaRepository<Reviews, Long>{
}
