package com.example.demo.modules.txt;

import com.example.demo.modules.Module;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class EachSymbolCounting implements Module {

    @Override
    public boolean isSupported(String format) {
        return format.endsWith(".txt");
    }

    @Override
    public String getDescription() {
        return "Frequency of occurrence of each character";
    }

    @Override
    public void Execute(String file) {
        File realFile = new File(file);
        Map<Character, Integer> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(realFile))) {
            String line;
            while ((line = reader.readLine()) != null)
                for (char letter : line.toCharArray())
                     map.put(letter, map.getOrDefault(letter, 0) + 1);
            System.out.printf("Count of each symbol in file " + file);
            for (Map.Entry<Character, Integer> entry : map.entrySet())
                System.out.printf("%c: %d%n", entry.getKey(), entry.getValue());
        } catch (IOException e) {
            System.err.printf("Error reading file '%s': %s%n", file, e.getMessage());
        }
    }
}
