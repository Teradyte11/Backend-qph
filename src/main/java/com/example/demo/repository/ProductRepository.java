package com.example.demo.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select stock from products where id = :id ", nativeQuery = true)
    Integer findStockById(@Param("id") Long id);

    @Query(value = "select precio from products where id = :id ", nativeQuery = true)
    BigDecimal findPriceById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "update products set stock = :stock where id = :id ", nativeQuery = true)
    int updateStockById(@Param("id") Long id, @Param("stock") Integer stock);

}
