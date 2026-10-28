package com.example.demo.model;

import java.math.BigDecimal;

public record CalculationResponse(BigDecimal valueA, BigDecimal valueB, Operation operation, BigDecimal result) {}
