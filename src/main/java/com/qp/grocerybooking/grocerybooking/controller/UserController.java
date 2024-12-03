package com.qp.grocerybooking.grocerybooking.controller;

import com.qp.grocerybooking.grocerybooking.entity.Grocery;
import com.qp.grocerybooking.grocerybooking.entity.GroceryOrder;
import com.qp.grocerybooking.grocerybooking.model.OrderItemRequest;
import com.qp.grocerybooking.grocerybooking.service.GroceryService;
import com.qp.grocerybooking.grocerybooking.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/groceries")
public class UserController {

    private final GroceryService groceryService;
    private final OrderService orderService;

    public UserController(GroceryService groceryService, OrderService orderService) {
        this.groceryService = groceryService;
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Grocery>> getAllGroceries() {
        List<Grocery> groceries = groceryService.getAllGroceries();
        return ResponseEntity.ok(groceries);
    }

    @PostMapping("/orders")
    public ResponseEntity<GroceryOrder> placeOrder(@RequestBody List<OrderItemRequest> orderItemRequests) {
        try {
            GroceryOrder groceryOrder = orderService.createOrder(orderItemRequests);
            return new ResponseEntity<>(groceryOrder, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
