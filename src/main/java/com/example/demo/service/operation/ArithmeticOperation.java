package com.example.demo.service.operation;

import com.example.demo.model.Operation;

import java.math.BigDecimal;

public interface ArithmeticOperation {
    Operation getType();

    BigDecimal apply(BigDecimal valueA, BigDecimal valueB);
}
