package com.example.demo.service.operation;

import com.example.demo.model.Operation;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AddOperation implements ArithmeticOperation {
    @Override
    public Operation getType() {
        return Operation.ADD;
    }

    @Override
    public BigDecimal apply(BigDecimal valueA, BigDecimal valueB) {
        validate(valueA, valueB);
        BigDecimal result = compute(valueA, valueB);
        return normalize(result);
    }

    private void validate(BigDecimal valueA, BigDecimal valueB) {
        if (valueA == null || valueB == null) {
            throw new IllegalArgumentException("Both values are required for ADD");
        }
    }

    private BigDecimal compute(BigDecimal valueA, BigDecimal valueB) {
        return valueA.add(valueB);
    }

    private BigDecimal normalize(BigDecimal result) {
        BigDecimal stripped = result.stripTrailingZeros();
        return stripped.scale() < 0 ? stripped.setScale(0) : stripped;
    }
}
