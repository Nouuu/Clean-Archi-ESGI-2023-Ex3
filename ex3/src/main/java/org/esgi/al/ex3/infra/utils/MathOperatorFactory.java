package org.esgi.al.ex3.infra.utils;

import org.esgi.al.ex3.domain.utils.Operator;

import java.util.List;

public class MathOperatorFactory {
    private MathOperatorFactory() {
    }

    public static Operator<Integer> fromSymbol(String operator) {
        if (operator == null || operator.isBlank() || !List.of("+", "-", "*").contains(operator)) {
            throw new IllegalArgumentException("Operator cannot be null or empty and must be one of +, -, *, current value: " + operator);
        }
        return switch (operator) {
            case "+" -> new Addition();
            case "-" -> new Substraction();
            case "*" -> new Multiplication();
            default ->
                    throw new IllegalArgumentException("Operator cannot be null or empty and must be one of +, -, *, current value: " + operator);
        };
    }
}
