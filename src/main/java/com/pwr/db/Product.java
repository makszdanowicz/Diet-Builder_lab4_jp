package com.pwr.db;

public class Product {
    private String name;
    private double mass; //weight
    private double carbohydrates; //weglowodany
    private double fats;
    private double protein;
    private String category;
    public Product()
    {
        System.out.println("ERROR");
    }

    public Product(String name, double mass, double carbohydrates, double fats, double protein, String category)
    {
        this.name = name;
        this.mass = mass;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.protein = protein;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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
