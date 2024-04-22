package com.example.demo.modules.dir;

import com.example.demo.modules.Module;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileSizeCounting implements Module {
    @Override
    public boolean isSupported(String format) {
        return new File(format).isDirectory();
    }

    @Override
    public String getDescription() {
        return "Counting the size of all files in a directory";
    }

    @Override
    public void Execute(String file) {
        File directory = new File(file);
        File[] files = directory.listFiles();
        long size = 0;
        if (files != null)
            for (File realfile : files)
                if(realfile.isFile()) {
                    System.out.println(realfile.getName() + " size is " + size);
                    size += realfile.length();
                }
        System.out.println("Directory size - " + size);
    }
}
