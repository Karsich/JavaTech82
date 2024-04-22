package com.example.demo.modules.txt;

import com.example.demo.modules.Module;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class AllSymbolCounting implements Module {
    @Override
    public boolean isSupported(String format) {
        return format.endsWith(".txt");
    }

    @Override
    public String getDescription() {
        return "Count of all characters";
    }

    @Override
    public void Execute(String file) {
        File realFile = new File(file);
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(realFile))) {
            String line;
            while ((line = reader.readLine()) != null)
                for (char letter : line.toCharArray()) count +=1;
            System.out.printf(count + " symbols in file " + file);
        } catch (IOException e) {
            System.err.printf("Error reading file '%s': %s%n", file, e.getMessage());
        }
    }
}
