package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PurchaseDto;

public interface PurchaseService {
    List<PurchaseDto> findAll();

    PurchaseDto findById(Long id);

    PurchaseDto create(PurchaseDto dto);

    PurchaseDto update(Long id, PurchaseDto dto);

    void delete(Long id);
}
