package org.esgi.al.ex3.domain;

import org.esgi.al.ex3.domain.io.Output;
import org.esgi.al.ex3.domain.utils.Operator;
import org.esgi.al.ex3.domain.utils.Parser;
import org.esgi.al.ex3.kernel.Logger;

import java.util.List;

public class Calculator {
    private final Output output;
    private final Logger logger;
    private final Parser<Integer> parser;

    public Calculator(Output output, Logger logger, Parser<Integer> parser) {
        this.output = output;
        this.logger = logger;
        this.parser = parser;
    }

    public void calculate(List<String> lines, Operator<Integer> operator) {
        logger.log("Started");
        logger.log("applying operation " + operator.operatorName());
        Integer result = null;

        for (int i = 0; i < lines.size(); i++) {
            Integer value = parser.parse(lines.get(i));
            if (i == 0) {
                result = value;
                output.write(value.toString());
            } else {
                result = operator.apply(value, result);
                output.write(operator.operatorSymbol() + value + " (=" + result + ")");
            }
            logger.log("accumulation : " + result + " on line " + (i + 1));
        }
        output.write("--------------");
        output.write("Total = " + result + " (" + operator.operatorName() + ")");
        logger.log("end of program");
    }
}
