package org.esgi.al.ex3.infra.utils;

import org.esgi.al.ex3.domain.utils.Operator;

import java.util.Objects;

public class Multiplication implements Operator<Integer> {

    private static final String OPERATOR_NAME = "multiplication";
    private static final String OPERATOR_SYMBOL = "*";


    @Override
    public Integer apply(Integer a, Integer b) {
        return Objects.requireNonNull(a) * Objects.requireNonNull(b);
    }

    @Override
    public String operatorName() {
        return OPERATOR_NAME;
    }

    @Override
    public String operatorSymbol() {
        return OPERATOR_SYMBOL;
    }
}
