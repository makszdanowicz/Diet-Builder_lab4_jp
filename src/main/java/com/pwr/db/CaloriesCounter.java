package com.pwr.db;

public class CaloriesCounter {
    /*
    *To calculate the number of calories in a product, you can use the following formula:
    * Calories = (Carbohydrates*4) + (Protein*4) + (Fat*9)
    * This formula is based on the fact that each gram of carbohydrates and protein contains
    * approximately 4 calories, while each gram of fat contains approximately 9 calories.
    *
    * PLN
    * Ta formuła opiera się na tym, że każdy gram węglowodanów i białka zawiera około 4 kalorie,
    * a każdy gram tłuszczu zawiera około 9 kalorii.
    **/

    public double countCaloriesInProduct(double carbohydrates, double fats, double protein,double amount)
    {
        double calories = (carbohydrates*4 + protein*4 + fats*9)*amount;
        return calories;
    }
}
