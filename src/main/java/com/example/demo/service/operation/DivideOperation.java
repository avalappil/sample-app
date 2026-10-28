package com.example.demo.service.operation;

import com.example.demo.model.Operation;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;

@Component
public class DivideOperation implements ArithmeticOperation {
    @Override
    public Operation getType() {
        return Operation.DIVIDE;
    }

    @Override
    public BigDecimal apply(BigDecimal valueA, BigDecimal valueB) {
        validate(valueA, valueB);
        BigDecimal result = compute(valueA, valueB);
        return normalize(result);
    }

    private void validate(BigDecimal valueA, BigDecimal valueB) {
        if (valueA == null || valueB == null) {
            throw new IllegalArgumentException("Both values are required for DIVIDE");
        }
        if (valueB.signum() == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
    }

    private BigDecimal compute(BigDecimal valueA, BigDecimal valueB) {
        return valueA.divide(valueB, MathContext.DECIMAL64);
    }

    private BigDecimal normalize(BigDecimal result) {
        BigDecimal stripped = result.stripTrailingZeros();
        return stripped.scale() < 0 ? stripped.setScale(0) : stripped;
    }
}
