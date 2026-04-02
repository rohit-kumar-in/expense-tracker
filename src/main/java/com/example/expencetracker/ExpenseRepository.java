package com.example.expencetracker;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // Custom search by category
    List<Expense> findByCategoryIgnoreCase(String category);
}