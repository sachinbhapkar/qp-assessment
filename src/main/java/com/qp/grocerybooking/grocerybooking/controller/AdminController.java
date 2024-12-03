package com.qp.grocerybooking.grocerybooking.controller;

import com.qp.grocerybooking.grocerybooking.entity.Grocery;
import com.qp.grocerybooking.grocerybooking.service.GroceryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/groceries")
public class AdminController {


    private final GroceryService groceryService;

    public AdminController(GroceryService groceryService) {
        this.groceryService = groceryService;
    }

    @GetMapping
    public ResponseEntity<List<Grocery>> getAllGroceries() {
        List<Grocery> groceries = groceryService.getAllGroceries();
        return ResponseEntity.ok(groceries);
    }

    @PostMapping
    public ResponseEntity<Grocery> addGrocery(@RequestBody Grocery grocery) {
        Grocery createdGrocery = groceryService.addGrocery(grocery);
        return new ResponseEntity<>(createdGrocery, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grocery> updateGrocery(@PathVariable Long id, @RequestBody Grocery updatedGrocery) {
        Grocery grocery = groceryService.updateGrocery(id, updatedGrocery);
        return grocery != null ? ResponseEntity.ok(grocery) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeGrocery(@PathVariable Long id) {
        boolean isRemoved = groceryService.removeGrocery(id);
        if (isRemoved) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item with ID " + id + " not found.");
        }
    }

    @PutMapping("/{id}/inventory")
    public ResponseEntity<Grocery> updateInventory(@PathVariable Long id, @RequestParam int inventory) {
        Grocery grocery = groceryService.updateInventory(id, inventory);
        return grocery != null ? ResponseEntity.ok(grocery) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
