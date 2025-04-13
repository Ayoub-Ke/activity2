package org.example.university.repository;

import org.example.university.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContaining(String mc);
    List<Product> findByPriceGreaterThan(double c);
    @Query("select p f from Product p  where p.name like :x")
    List<Product> search(@Param("x")String mc);
}
