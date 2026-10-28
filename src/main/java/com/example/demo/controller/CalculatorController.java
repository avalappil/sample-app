package com.example.demo.controller;

import com.example.demo.model.CalculationRequest;
import com.example.demo.model.CalculationResponse;
import com.example.demo.service.CalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping
    public CalculationResponse calculate(@RequestBody CalculationRequest request) {
        return calculatorService.calculate(request);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleBadRequest(IllegalArgumentException ex) {
        return Map.of("error", ex.getMessage());
    }
}
