package com.pwr.db;

import java.util.List;

public interface InformationWorker {
    void addProductData(Product product,String query);
    List<Product> getProductData(String query);
    void deleteProductData(String name,String query);
    void updateProductData(String query);
}
