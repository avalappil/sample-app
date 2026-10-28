package com.example.demo.service;

import com.example.demo.model.CalculationRequest;
import com.example.demo.model.CalculationResponse;
import com.example.demo.service.operation.ArithmeticOperation;
import com.example.demo.service.operation.OperationFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    private final OperationFactory operationFactory;

    public CalculatorServiceImpl(OperationFactory operationFactory) {
        this.operationFactory = operationFactory;
    }

    @Override
    public CalculationResponse calculate(CalculationRequest request) {
        if (request.valueA() == null || request.valueB() == null || request.operation() == null) {
            throw new IllegalArgumentException("valueA, valueB and operation are required");
        }
        ArithmeticOperation operation = operationFactory.getOperation(request.operation());
        BigDecimal result = operation.apply(request.valueA(), request.valueB());
        return new CalculationResponse(request.valueA(), request.valueB(), request.operation(), result);
    }
}
