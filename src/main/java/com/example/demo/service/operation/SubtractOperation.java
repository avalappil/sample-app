package com.example.demo.service.operation;

import com.example.demo.model.Operation;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SubtractOperation implements ArithmeticOperation {
    @Override
    public Operation getType() {
        return Operation.SUBTRACT;
    }

    @Override
    public BigDecimal apply(BigDecimal valueA, BigDecimal valueB) {
        validate(valueA, valueB);
        BigDecimal result = compute(valueA, valueB);
        return normalize(result);
    }

    private void validate(BigDecimal valueA, BigDecimal valueB) {
        if (valueA == null || valueB == null) {
            throw new IllegalArgumentException("Both values are required for SUBTRACT");
        }
    }

    private BigDecimal compute(BigDecimal valueA, BigDecimal valueB) {
        return valueA.subtract(valueB);
    }

    private BigDecimal normalize(BigDecimal result) {
        BigDecimal stripped = result.stripTrailingZeros();
        return stripped.scale() < 0 ? stripped.setScale(0) : stripped;
    }
}
