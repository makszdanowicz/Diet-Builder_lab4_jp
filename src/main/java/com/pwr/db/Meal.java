package com.pwr.db;

public interface Meal {
    void addToMeal(Product product, double amount, String query);
    void updateMeal(String name, Double amount, String query);
}
