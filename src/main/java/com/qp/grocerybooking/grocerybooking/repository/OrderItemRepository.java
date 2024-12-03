package com.qp.grocerybooking.grocerybooking.repository;

import com.qp.grocerybooking.grocerybooking.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
