package com.qp.grocerybooking.grocerybooking.repository;

import com.qp.grocerybooking.grocerybooking.entity.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Long> {
    Optional<Grocery> findByName(String name);
}
