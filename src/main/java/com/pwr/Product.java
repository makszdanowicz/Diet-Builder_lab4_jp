package com.pwr;

public class Product {
    private String name;
    private double mass; //weight
    private double carbohydrates; //weglowodany
    private double fats;
    private double protein;
    private String category;

    public Product(String name, double mass, double carbohydrates, double fats, double protein, String category)
    {
        this.name = name;
        this.mass = mass;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.protein = protein;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                name + " (" + mass + "g)" + '\n' +
                "- Carbohydrates (g): " + carbohydrates + '\n' +
                "- Fats (g): " + fats + '\n' +
                "- Protein (g): " + protein + '\n' +
                "- Category (g): " + category + '\n';
    }
}
