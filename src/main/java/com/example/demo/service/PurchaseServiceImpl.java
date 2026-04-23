package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.PurchaseDto;
import com.example.demo.entity.Product;
import com.example.demo.entity.Purchase;
import com.example.demo.entity.User;
import com.example.demo.exception.CValidationException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.PurchaseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository repository;
    private final ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PurchaseDto findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    @SuppressWarnings({ "unused", "static-access" })
    public PurchaseDto create(PurchaseDto dto) {
        Integer availableStock = 0;
        Integer finalStock = 0;
        BigDecimal finalPrice = new BigDecimal("20.0");
        availableStock = productRepository.findStockById(dto.getProduct_id());
        if (availableStock == 0) {
            throw new CValidationException("Producto sin stock");
        }
        if (availableStock < dto.getAmount()) {
            throw new CValidationException("No existe stock suficiente.");
        }
        finalStock = availableStock - dto.getAmount();
        if (finalStock < 0) {
            throw new CValidationException("No existe stock suficiente.");
        }
        finalPrice = productRepository.findPriceById(dto.getProduct_id());
        System.out.println("----ENTRA----");
        System.out.println(dto);
        // System.out.println(finalPrice);
        if (finalPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new CValidationException("El precio por producto no puede ser menor a0.");
        }
        finalPrice = finalPrice.multiply(BigDecimal.valueOf(dto.getAmount()));
        System.out.println(finalPrice);
        productRepository.updateStockById(dto.getProduct_id(), finalStock);
        Purchase purchase = toEntity(dto, finalPrice);
        return toDTO(repository.save(purchase));
    }

    @Override
    public PurchaseDto update(Long id, PurchaseDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private PurchaseDto toDTO(Purchase p) {
        return PurchaseDto.builder()
                .id(p.getId())
                .amount(p.getAmount())
                .price(p.getPrice())
                .product_id(p.getProduct().getId())
                .user_id(p.getUser().getId())
                .build();
    }

    private Purchase toEntity(PurchaseDto dto, BigDecimal finalPrice) {
        User user = new User();
        Product product = new Product();
        user.setId(dto.getUser_id());
        product.setId(dto.getProduct_id());
        return Purchase.builder()
                .id(dto.getId())
                .amount(dto.getAmount())
                .price(finalPrice)
                .user(user)
                .product(product)
                .build();
    }

}
