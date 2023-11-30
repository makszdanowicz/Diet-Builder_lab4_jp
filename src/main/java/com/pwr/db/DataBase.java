package com.pwr.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase implements InformationWorker{
    private final String dbURL = "jdbc:mysql://localhost:3306/diet";
    private final String dbUserName = "root";
    private final String dbPassword = "HelloWorld12345";
    private Connection connection;
    public DataBase()
    {
        try {
            connection = DriverManager.getConnection(dbURL,dbUserName,dbPassword);
        } catch (SQLException e) {
            System.out.println("You have a problem with connection to DB" + e.getMessage());
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
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getProductData(String query)
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
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public void updateProductData(String query)
    {

    }


    //Zrobimy ze usuwa po nazwie produktu
    @Override
    public void deleteProductData(String name,String query)
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
