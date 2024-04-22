package com.example.demo.modules.image;

import com.example.demo.modules.Module;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Component
public class ImageSizeChecker implements Module {
    @Override
    public boolean isSupported(String format) {
        return format.endsWith(".jpg");
    }

    @Override
    public String getDescription() {
        return "Output image size ";
    }

    @Override
    public void Execute(String file) {
        try {
            BufferedImage bimg = ImageIO.read(new File(file));
            int width          = bimg.getWidth();
            int height         = bimg.getHeight();
            System.out.println("Image " + file + " :  Width - " + width + "; height - " + height);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
