package org.faze.store.services;



import org.faze.store.models.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();

    public void saveProduct(Product product);

    public void updateProduct(int id, Product product);

    public Product getProduct(int id);

    public void deleteProduct(int id);

    public List<Product> findAllByMarka(String marka);

}
