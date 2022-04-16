package org.faze.store.services;

import org.faze.store.dao.ProductRepository;
import org.faze.store.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional
    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Transactional
    @Override
    public void updateProduct(int id, Product updatedProduct) {
        updatedProduct.setId(id);
        productRepository.save(updatedProduct);
    }

    @Override
    public Product getProduct(int id) {
        Product product = null;
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            product = optional.get();
        }

        return product;
    }

    @Transactional
    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAllByMarka(String marka) {
        List<Product> products = productRepository.findAllByMarka(marka);
        return products;
    }
}
