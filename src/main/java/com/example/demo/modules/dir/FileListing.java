package com.example.demo.modules.dir;

import com.example.demo.modules.Module;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileListing implements Module {
    @Override
    public boolean isSupported(String format) {
        return new File(format).isDirectory();
    }

    @Override
    public String getDescription() {
        return "Listing files in a directory";
    }

    @Override
    public void Execute(String file) {
        File directory = new File(file);
        File[] files = directory.listFiles();
        System.out.println("List of all files in directory " + directory.getName());
        int count = 1;
        if (files != null)
            for (File realfile : files)
                if (realfile.isFile()) {
                    System.out.println(count + ")" + realfile.getName());
                    count++;
                }
    }
}
