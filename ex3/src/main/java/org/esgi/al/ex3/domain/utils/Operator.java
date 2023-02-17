package org.esgi.al.ex3.domain.utils;

public interface Operator<T> {
    T apply(T a, T b);

    String operatorName();

    String operatorSymbol();
}
