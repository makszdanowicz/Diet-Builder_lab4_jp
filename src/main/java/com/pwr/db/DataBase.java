package com.pwr.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class DataBase implements InformationWorker,Meal{
    private String dbURL;
    private String dbUserName;
    private String dbPassword;
    private Connection connection;
    public DataBase()
    {
        try {
            //Reading database information from config file
            Properties properties = new Properties();
            InputStream input = getClass().getResourceAsStream("/config_db.properties");
            properties.load(input);
            dbURL = properties.getProperty("db.url");
            dbUserName = properties.getProperty("db.username");
            dbPassword = properties.getProperty("db.password");

            connection = DriverManager.getConnection(dbURL,dbUserName,dbPassword);
        } catch (SQLException e) {
            System.out.println("You have a problem with connection to DB" + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Error.There is no config file found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Problem with reading config file: " + e.getMessage());
        }
    }
    @Override
    public void addProductData(Product product, String query)
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,product.getName());

            preparedStatement.setDouble(2,product.getMass());
            preparedStatement.setDouble(3,product.getCarbohydrates());
            preparedStatement.setDouble(4,product.getFats());
            preparedStatement.setDouble(5,product.getProtein());
            preparedStatement.setString(6,product.getCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can not add Product to DataBase" + e.getMessage());
        }
    }

    @Override
    public Product getProductData(String name,String query)
    {
        Product product = new Product();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                String nameDB = resultSet.getString("name");
                double mass = resultSet.getDouble("mass");
                double carbohydrates = resultSet.getDouble("carbohydrates");
                double fats = resultSet.getDouble("fats");
                double protein = resultSet.getDouble("protein");
                String category = resultSet.getString("category");

                product.setName(nameDB);
                product.setMass(mass);
                product.setCarbohydrates(carbohydrates);
                product.setFats(fats);
                product.setProtein(protein);
                product.setCategory(category);
            }

        } catch (SQLException e) {
            System.out.println("Can not get Data of Product from DataBase" + e.getMessage());
        }
        return product;
    }

    @Override
    public List<Product> getProductsData(String query)
    {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                String name = resultSet.getString("name");
                double mass = resultSet.getDouble("mass");
                double carbohydrates = resultSet.getDouble("carbohydrates");
                double fats = resultSet.getDouble("fats");
                double protein = resultSet.getDouble("protein");
                String category = resultSet.getString("category");

                productList.add(new Product(name,mass,carbohydrates,fats,protein,category));
            }
        } catch (SQLException e) {
            System.out.println("Can not get Products Data from DataBase" + e.getMessage());
        }
        return productList;
    }

    @Override
    public void updateProductData(double mass, double carbohydrates, double fats, double protein, String name,String query)
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1,mass);
            preparedStatement.setDouble(2,carbohydrates);
            preparedStatement.setDouble(3,fats);
            preparedStatement.setDouble(4,protein);
            preparedStatement.setString(5,name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can not update Product to DataBase" + e.getMessage());
        }
    }

    @Override
    public void deleteProductData(String name,String query)
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can not delete Product from DataBase" + e.getMessage());
        }
    }


    @Override
    public void addToMeal(Product product, double amount, String query) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,product.getName());

            preparedStatement.setDouble(2,product.getMass());
            preparedStatement.setDouble(3,product.getCarbohydrates());
            preparedStatement.setDouble(4,product.getFats());
            preparedStatement.setDouble(5,product.getProtein());
            preparedStatement.setString(6,product.getCategory());
            preparedStatement.setDouble(7,amount);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can not add Meal to DataBase" + e.getMessage());
        }
    }
    @Override
    public void updateMeal(String name, Double amount, String query) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1,amount);
            preparedStatement.setString(2,name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can not update Meal to DataBase" + e.getMessage());
        }
    }

    @Override
    public Map<Product,Double> getMealData(String query) {
        Map<Product,Double> meal = new HashMap<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                String name = resultSet.getString("name");
                double mass = resultSet.getDouble("mass");
                double carbohydrates = resultSet.getDouble("carbohydrates");
                double fats = resultSet.getDouble("fats");
                double protein = resultSet.getDouble("protein");
                String category = resultSet.getString("category");
                double amount = resultSet.getDouble("amount");

                meal.put(new Product(name,mass,carbohydrates,fats,protein,category),amount);
            }
        } catch (SQLException e) {
            System.out.println("Can not get Meal Data from DataBase" + e.getMessage());
        }
        return meal;

    }
}
