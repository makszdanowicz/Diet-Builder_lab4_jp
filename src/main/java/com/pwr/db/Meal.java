package com.pwr.db;

import java.util.Map;

public interface Meal {
    void addToMeal(Product product, double amount, String query);
    void updateMeal(String name, Double amount, String query);
    Map<Product,Double> getMealData(String query);
}
