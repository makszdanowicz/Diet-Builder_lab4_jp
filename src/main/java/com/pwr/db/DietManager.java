package com.pwr.db;

import com.pwr.gui.InformationCollector;

public class DietManager implements Lunch,Dinner{
    private InformationWorker worker;
    private InformationCollector collector = new InformationCollector();
    public DietManager(InformationWorker worker)
    {
        this.worker = worker;
    }

    public Product addProduct()
    {
        String name = collector.getName();
        double mass = collector.getMass();
        double carbohydrates = collector.getCarbohydrates();
        double fats = collector.getFats();
        double protein = collector.getProtein();
        String category = collector.getCategory();
        Product product = new Product(name,mass,carbohydrates,fats,protein,category);
        return product;
    }

    public void addToBreakfast()
    {
        Product product = addProduct();
        worker.addProductData(product,"INSERT INTO breakfast(name,mass,carbohydrates,fats,protein,category) VALUE(?, ?, ?, ?, ?, ?);");
    }

    public void updateBreakfast()
    {

    }


    public void deleteFromBreakfast()
    {
        String name = collector.getName();
        worker.deleteProductData(name,"DELETE FROM breakfast where name = ?;");
    }

    @Override
    public void addToLunch()
    {
        Product product = addProduct();
        worker.addProductData(product,"INSERT INTO lunch(name,mass,carbohydrates,fats,protein,category) VALUE(?, ?, ?, ?, ?, ?);");
    }

    /*
    @Override
    public void updateLunch()
    {
        worker.updateProductData("UPDATE_PRODUCT lunch SET;");
    }

     */

    @Override
    public void deleteFromLunch()
    {
        String name = collector.getName();
        worker.deleteProductData(name,"DELETE FROM lunch where name = ?;");
    }

    @Override
    public void addToDinner()
    {
        Product product = addProduct();
        worker.addProductData(product,"INSERT INTO dinner(name,mass,carbohydrates,fats,protein,category) VALUE(?, ?, ?, ?, ?, ?);");
    }

    @Override
    public void updateDinner()
    {

    }

    @Override
    public void deleteFromDinner()
    {
        String name = collector.getName();
        worker.deleteProductData(name,"DELETE FROM dinner where name = ?;");
    }
}
