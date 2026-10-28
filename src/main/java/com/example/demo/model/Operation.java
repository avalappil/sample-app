package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Operation {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE;

    @JsonCreator
    public static Operation from(String value) {
        return Operation.valueOf(value.trim().toUpperCase());
    }
}
