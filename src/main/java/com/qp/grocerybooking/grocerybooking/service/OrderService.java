package com.qp.grocerybooking.grocerybooking.service;

import com.qp.grocerybooking.grocerybooking.entity.Grocery;
import com.qp.grocerybooking.grocerybooking.entity.GroceryOrder;
import com.qp.grocerybooking.grocerybooking.entity.OrderItem;
import com.qp.grocerybooking.grocerybooking.model.OrderItemRequest;
import com.qp.grocerybooking.grocerybooking.repository.GroceryOrderRepository;
import com.qp.grocerybooking.grocerybooking.repository.GroceryRepository;
import com.qp.grocerybooking.grocerybooking.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final GroceryRepository groceryRepository;

    private final GroceryOrderRepository groceryOrderRepository;

    public OrderService(GroceryRepository groceryRepository, GroceryOrderRepository groceryOrderRepository, OrderItemRepository orderItemRepository) {
        this.groceryRepository = groceryRepository;
        this.groceryOrderRepository = groceryOrderRepository;
    }

    public GroceryOrder createOrder(List<OrderItemRequest> orderItemRequests) {
        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemRequest request : orderItemRequests) {
            Optional<Grocery> groceryOptional = groceryRepository.findByName(request.getName());
            if (groceryOptional.isEmpty()) {
                throw new IllegalArgumentException("Grocery item " + request.getName() + " not found.");
            }
            Grocery grocery = groceryOptional.get();

            if (grocery.getInventory() < request.getQuantity()) {
                throw new IllegalArgumentException("Not enough inventory for " + grocery.getName());
            }
            grocery.setInventory(grocery.getInventory() - request.getQuantity());
            groceryRepository.save(grocery);

            OrderItem orderItem = new OrderItem(grocery, request.getQuantity());
            orderItems.add(orderItem);
        }

        GroceryOrder groceryOrder = new GroceryOrder(orderItems, "Pending");

        for (OrderItem orderItem : orderItems) {
            orderItem.setOrder(groceryOrder);
        }
        return groceryOrderRepository.save(groceryOrder);
    }

}
