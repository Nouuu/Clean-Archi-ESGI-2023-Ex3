package org.esgi.al.ex3.infra.io;

import org.esgi.al.ex3.domain.io.Output;

public class CliOutput implements Output {
    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
