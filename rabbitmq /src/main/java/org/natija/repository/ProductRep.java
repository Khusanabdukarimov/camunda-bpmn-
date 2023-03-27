package org.natija.repository;


import org.natija.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRep extends JpaRepository<Product, String> {
}
