package com.example.demo.modules.txt;

import com.example.demo.modules.Module;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class LinesCounting implements Module {
    @Override
    public boolean isSupported(String format) {
        return format.endsWith(".txt");
    }

    @Override
    public String getDescription() {
        return "Counting and displaying the number of lines";
    }

    @Override
    public void Execute(String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("Count of lines in" + file + " - " + reader.lines().count());
        } catch (IOException e) {
            System.err.printf("Error reading file '%s': %s%n", file, e.getMessage());
        }
    }
}
