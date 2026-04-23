package com.example.demo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "purchase")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    // @NotNull
    // @Positive(message = "El precio debe ser positivo")
    private BigDecimal price;
    @Column(nullable = false)
    @NotNull
    @Positive(message = "La cantidad de productos debe ser positivo")
    private Integer amount;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
}
