package com.example.demo.modules.image;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifSubIFDDirectory;

import com.example.demo.modules.Module;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class ImageEXIFChecker implements Module {
    @Override
    public boolean isSupported(String format) {
        return format.endsWith(".jpg");
    }

    @Override
    public String getDescription() {
        return "Output exif information";
    }

    @Override
    public void Execute(String file) {
        File realFile = new File(file);
        try {
            ExifSubIFDDirectory directory = ImageMetadataReader.
                    readMetadata(realFile).
                    getFirstDirectoryOfType(ExifSubIFDDirectory.class);
            if (directory != null)
                for (Tag tag : directory.getTags())
                    System.out.println(tag.getTagName() + " - " + tag.getDescription());
            else
                System.out.println("No exif metadata");

        } catch (ImageProcessingException | IOException e) {
            System.out.println("Error with " + e.getMessage());
        }
    }
}
