package org.esgi.al.ex3.infra.io;

import org.esgi.al.ex3.domain.io.InputReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileInputReader implements InputReader {

    @Override
    public List<String> read(String filename) {
        try {
            return Files.readAllLines(Path.of(filename))
                    .stream()
                    .map(String::trim)
                    .toList();
        } catch (IOException e) {
            return null;
        }
    }
}
