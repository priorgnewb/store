package org.faze.store.dao;

import org.faze.store.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findAllByMarka(String marka);
}
