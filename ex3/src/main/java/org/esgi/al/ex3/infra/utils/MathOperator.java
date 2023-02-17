package org.esgi.al.ex3.infra.utils;

import org.esgi.al.ex3.domain.utils.Operator;

import java.util.List;
import java.util.Objects;

public class MathOperator implements Operator<Integer> {

    private final String operator;
    private final String operatorName;

    public MathOperator(String operator) {
        if (operator == null || operator.isBlank() || !List.of("+", "-", "*").contains(operator)) {
            throw new IllegalArgumentException("Operator cannot be null or empty and must be one of +, -, *, current value: " + operator);
        }
        this.operator = operator;
        this.operatorName = switch (operator) {
            case "+" -> "addition";
            case "-" -> "subtraction";
            case "*" -> "multiplication";
            default ->
                    throw new IllegalArgumentException("Operator cannot be null or empty and must be one of +, -, *, current value: " + operator);
        };
    }

    @Override
    public Integer apply(Integer a, Integer b) {
        return switch (operator) {
            case "+" -> Objects.requireNonNull(a) + Objects.requireNonNull(b);
            case "-" -> Objects.requireNonNull(a) - Objects.requireNonNull(b);
            case "*" -> Objects.requireNonNull(a) * Objects.requireNonNull(b);
            default ->
                    throw new IllegalArgumentException("Operator cannot be null or empty and must be one of +, -, *, current value: " + operator);
        };
    }

    @Override
    public String operatorName() {
        return operatorName;
    }

    @Override
    public String operatorSymbol() {
        return operator;
    }
}
