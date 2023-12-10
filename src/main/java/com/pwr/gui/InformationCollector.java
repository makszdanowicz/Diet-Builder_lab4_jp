package com.pwr.gui;

import com.pwr.db.DataBase;
import com.pwr.db.DietManager;
import java.util.Scanner;

public class InformationCollector {
    public String getName()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the name of product(for example 'Apple'):");
        String name = scanner.nextLine();
        return name;
    }

    public double getMass()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type your product mass in grams(for example '50'):");
        double mass = scanner.nextDouble();
        return mass;
    }

    public double getCarbohydrates()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the amount of carbohydrates,that contains in ur product, in grams(for example '23'):");
        double carbohydrates = scanner.nextDouble();
        return carbohydrates;
    }

    public double getFats()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the amount of fats,that contains in ur product, in grams(for example '0'):");
        double fats = scanner.nextDouble();
        return fats;
    }

    public double getProtein()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the amount of protein,that contains in ur product, in grams(for example '15'):");
        double protein = scanner.nextDouble();
        return protein;
    }

    public String getCategory()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the category of ur product,(for example 'Fruit'):");
        String category = scanner.nextLine();
        return category;
    }

    public void getDecision()
    {
        DataBase dataBase = new DataBase();
        DietManager manager = new DietManager(dataBase);
        System.out.println("What u would like to do, choose necessary category: ");
        System.out.println("|Breakfast/Lunch/Dinner|");
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.next();
        if(decision.equals("Breakfast") || decision.equals("breakfast"))
        {
            System.out.println("What action would u like to do:");
            System.out.println("Add to breakfast(press '1') | Update breakfast(press '2') | Delete from breakfast(press '3')");
            int number = scanner.nextInt();
            if(number == 1)
            {
                manager.addToBreakfast();
            }
            else if(number == 2)
            {
                manager.updateBreakfast();
            }
            else if(number == 3)
            {
                manager.deleteFromBreakfast();
            }
        }
        else if(decision.equals("Lunch") || decision.equals("lunch"))
        {
            System.out.println("What action would u like to do:");
            System.out.println("Add to lunch(press '1') | Update lunch(press '2') | Delete from lunch(press '3')");
            int number = scanner.nextInt();
            if(number == 1)
            {
                manager.addToLunch();
            }
            else if(number == 2)
            {
                //manager.updateLunch();
            }
            else if(number ==3)
            {
                manager.deleteFromLunch();
            }
        }
        else if(decision.equals("Dinner") || decision.equals("dinner"))
        {
            System.out.println("What action would u like to do:");
            System.out.println("Add to dinner(press '1') | Update dinner(press '2') | Delete from dinner(press '3')");
            int number = scanner.nextInt();
            if(number == 1)
            {
                manager.addToDinner();
            }
            else if(number == 2)
            {
                manager.updateDinner();
            }
            else if(number ==3)
            {
                manager.deleteFromDinner();
            }
        }
    }

}
