package com.pwr.db;

import java.util.List;

public interface InformationWorker {
    void addProductData(Product product,String query);
    Product getProductData(String name,String query);
    List<Product> getProductsData(String query);
    void deleteProductData(String name,String query);
    void updateProductData(double mass, double carbohydrates, double fats, double protein, String name,String query);
}
