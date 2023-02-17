package org.esgi.al.ex3.infra.logger;

import org.esgi.al.ex3.domain.io.Output;
import org.esgi.al.ex3.kernel.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CliLogger implements Logger {
    private final Output output;
    private final boolean debugEnabled;

    private final SimpleDateFormat formatter = new SimpleDateFormat("hhmmss:SSSSSS");

    public CliLogger(Output output, boolean debugEnabled) {
        this.output = output;
        this.debugEnabled = debugEnabled;
    }

    @Override
    public void log(String message) {
        if (debugEnabled) {
            output.write("[" + formatter.format(new Date()) + "][log] " + message);
        }
    }
}
