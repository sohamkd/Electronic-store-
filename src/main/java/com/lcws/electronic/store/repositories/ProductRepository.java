package com.lcws.electronic.store.repositories;

import com.lcws.electronic.store.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {

}
