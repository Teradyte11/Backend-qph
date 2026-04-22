package com.example.demo.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class CErrorMessageException {
    private LocalDateTime timestamp;
    private Boolean exists;
    private String message;
}
