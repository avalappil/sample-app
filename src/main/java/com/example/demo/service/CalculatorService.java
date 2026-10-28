package com.example.demo.service;

import com.example.demo.model.CalculationRequest;
import com.example.demo.model.CalculationResponse;

public interface CalculatorService {
    CalculationResponse calculate(CalculationRequest request);
}
