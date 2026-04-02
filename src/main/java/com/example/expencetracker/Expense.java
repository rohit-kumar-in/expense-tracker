package com.example.expencetracker;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private double amount;
    private String category;
    private LocalDate date;


    // Getters file
    public Long getId() { return id; }
    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }
    public LocalDate getDate() { return date; }

    // Setters file
    public void setDescription(String description) { this.description = description; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setCategory(String category) { this.category = category; }
    public void setDate(LocalDate date) { this.date = date; }

}