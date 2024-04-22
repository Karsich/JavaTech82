package com.example.demo.modules.dir;

import com.example.demo.modules.Module;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

@Component
public class FileDateChecking implements Module {
    @Override
    public boolean isSupported(String format) {
        return new File(format).isDirectory();
    }

    @Override
    public String getDescription() {
        return "Date of creation and modification of files";
    }

    @Override
    public void Execute(String file) {
        try{
            File directory = new File(file);
            File[] files = directory.listFiles();
            BasicFileAttributes attr = Files.readAttributes(directory.toPath(), BasicFileAttributes.class);
            if (files != null)
                for (File realfile : files)
                    if(realfile.isFile())
                        System.out.println("\nFile - "+ realfile.getName() + "\nCreation time - " + Files.readAttributes(directory.toPath(), BasicFileAttributes.class).creationTime() + "\nLast Modified Time - " + Files.readAttributes(directory.toPath(), BasicFileAttributes.class).lastModifiedTime());
        }
        catch (IOException e) {
            System.err.println(e);
        }


    }
}
