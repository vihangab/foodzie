package com.foodzie.foodzie.DAO;

import com.foodzie.foodzie.Entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDAO extends JpaRepository<Review, Long>{
}
