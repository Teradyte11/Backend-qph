package com.example.demo.exception;

import java.util.Map;

public class CValidationException extends RuntimeException {
    private Map<String, String> errors;

    /**
     * Funcion constructor de la clase.
     * 
     * @param message
     */
    public CValidationException(String message) {
        super(message);
    }

    /**
     * Funcion constructor de la clase.
     * 
     * @param message
     * @param errors
     */
    public CValidationException(String message, Map<String, String> errors) {
        super(message);
        this.errors = errors;
    }

    /**
     * Funcion para el retornde errores.
     * 
     * @return
     */
    public Map<String, String> getErrors() {
        return errors;
    }
}
