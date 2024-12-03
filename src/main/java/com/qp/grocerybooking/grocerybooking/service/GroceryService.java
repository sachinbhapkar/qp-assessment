package com.qp.grocerybooking.grocerybooking.service;

import com.qp.grocerybooking.grocerybooking.entity.Grocery;
import com.qp.grocerybooking.grocerybooking.repository.GroceryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryService {

    private final GroceryRepository groceryRepository;

    public GroceryService(GroceryRepository groceryRepository) {
        this.groceryRepository = groceryRepository;
    }

    public List<Grocery> getAllGroceries() {
        return groceryRepository.findAll();
    }

    public Grocery addGrocery(Grocery grocery) {
        return groceryRepository.save(grocery);
    }

    public Grocery updateGrocery(Long id, Grocery updatedGrocery) {
        Grocery existingGrocery = groceryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grocery not found"));
        existingGrocery.setName(updatedGrocery.getName());
        existingGrocery.setPrice(updatedGrocery.getPrice());
        existingGrocery.setDescription(updatedGrocery.getDescription());
        existingGrocery.setInventory(updatedGrocery.getInventory());
        return groceryRepository.save(existingGrocery);
    }

    public Grocery updateInventory(Long id, int newInventoryLevel) {
        Optional<Grocery> existingGrocery = groceryRepository.findById(id);
        if (existingGrocery.isPresent()) {
            Grocery grocery = existingGrocery.get();
            grocery.setInventory(newInventoryLevel);
            return groceryRepository.save(grocery);
        }
        return null;
    }

    public boolean removeGrocery(Long id) {
        Optional<Grocery> existingGrocery = groceryRepository.findById(id);
        if (existingGrocery.isPresent()) {
            groceryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
