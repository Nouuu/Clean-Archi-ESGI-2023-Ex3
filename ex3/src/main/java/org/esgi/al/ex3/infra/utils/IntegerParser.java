package org.esgi.al.ex3.infra.utils;

import org.esgi.al.ex3.domain.utils.Parser;
import org.esgi.al.ex3.kernel.Logger;

public class IntegerParser implements Parser<Integer> {
    private final Logger logger;

    public IntegerParser(Logger logger) {
        this.logger = logger;
    }


    @Override
    public Integer parse(String input) {
        Integer result = Integer.parseInt(input);
        logger.log("parsed value = " + result);
        return result;
    }
}
