package com.example.demo.model;

import java.math.BigDecimal;

public record CalculationRequest(BigDecimal valueA, BigDecimal valueB, Operation operation) {}
