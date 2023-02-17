package org.esgi.al.ex3;

import org.esgi.al.ex3.domain.Calculator;
import org.esgi.al.ex3.domain.io.InputReader;
import org.esgi.al.ex3.domain.io.Output;
import org.esgi.al.ex3.domain.utils.Operator;
import org.esgi.al.ex3.domain.utils.Parser;
import org.esgi.al.ex3.infra.io.CliOutput;
import org.esgi.al.ex3.infra.io.FileInputReader;
import org.esgi.al.ex3.infra.logger.CliLogger;
import org.esgi.al.ex3.infra.utils.IntegerParser;
import org.esgi.al.ex3.infra.utils.MathOperator;
import org.esgi.al.ex3.kernel.Logger;

import java.util.List;
import java.util.Objects;

public class CalculatorMain {
    public static void main(String[] args) {
        if (args.length < 2 || args.length > 3) {
            System.out.println("Usage: java -jar app.jar <filename> \"<operation>\" [-log]");
            System.exit(1);
        }

        // Parse the arguments

        String filename = args[0];
        String operation = args[1];
        boolean log = args.length == 3 && args[2].equals("-log");

        // Create the objects

        InputReader inputReader = new FileInputReader();
        Output output = new CliOutput();
        Logger logger = new CliLogger(output, log);
        Parser<Integer> parser = new IntegerParser(logger);
        Operator<Integer> operator = new MathOperator(operation);
        Calculator calculator = new Calculator(output, logger, parser);

        // Run the program
        List<String> lines = Objects.requireNonNull(inputReader.read(filename));
        calculator.calculate(lines, operator);
    }
}
