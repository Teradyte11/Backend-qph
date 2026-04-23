package com.example.demo.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PurchaseDto {
    private Long id;
    private Long product_id;
    private Long user_id;
    private Integer amount;
    private BigDecimal price;
}
