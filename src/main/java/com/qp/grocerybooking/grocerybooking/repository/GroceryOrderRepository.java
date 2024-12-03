package com.qp.grocerybooking.grocerybooking.repository;

import com.qp.grocerybooking.grocerybooking.entity.GroceryOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryOrderRepository extends JpaRepository<GroceryOrder, Long> {
}
