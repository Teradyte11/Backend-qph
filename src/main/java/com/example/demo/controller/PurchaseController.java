package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PurchaseDto;
import com.example.demo.service.PurchaseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/purchase")
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseService purchaseService;

    @GetMapping
    public ResponseEntity<List<PurchaseDto>> getAll() {
        return ResponseEntity.ok(purchaseService.findAll());
    }

    @PostMapping(path = "/create")
    public ResponseEntity<PurchaseDto> create(@RequestBody PurchaseDto dto) {
        PurchaseDto created = purchaseService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
