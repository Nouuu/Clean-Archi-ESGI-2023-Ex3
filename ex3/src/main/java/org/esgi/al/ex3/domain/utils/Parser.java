package org.esgi.al.ex3.domain.utils;

public interface Parser<T> {
    T parse(String input);
}
