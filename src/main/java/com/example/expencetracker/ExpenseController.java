package com.example.expencetracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
        import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseRepository repository;

    // 1. ADD (POST) - This is the professional way to send data
    // Use Postman to send a JSON body to: http://localhost:8080/api/expenses
    @PostMapping
    public Expense add(@RequestBody Expense e) {
        if (e.getDate() == null) {
            e.setDate(LocalDate.now());
        }
        return repository.save(e);
    }

    // 2. LIST ALL (GET)
    @GetMapping
    public List<Expense> getAll() {
        return repository.findAll();
    }

    // 3. SEARCH (GET) - Filters are fine in GET
    @GetMapping("/search")
    public List<Expense> search(@RequestParam String cat) {
        return repository.findByCategoryIgnoreCase(cat);
    }

    // 4. DELETE (DELETE) - Use the correct method for removing
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return "Deleted expense with ID: " + id;
        }
        return "Error: ID not found!";
    }
}