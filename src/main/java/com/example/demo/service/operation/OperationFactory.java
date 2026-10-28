package com.example.demo.service.operation;

import com.example.demo.model.Operation;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class OperationFactory {
    private final Map<Operation, ArithmeticOperation> operations = new EnumMap<>(Operation.class);

    public OperationFactory(List<ArithmeticOperation> operationBeans) {
        operationBeans.forEach(op -> operations.put(op.getType(), op));
    }

    public ArithmeticOperation getOperation(Operation type) {
        ArithmeticOperation operation = operations.get(type);
        if (operation == null) {
            throw new IllegalArgumentException("Unsupported operation: " + type);
        }
        return operation;
    }
}
