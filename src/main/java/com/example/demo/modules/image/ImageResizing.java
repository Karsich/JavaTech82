package com.example.demo.modules.image;

import com.example.demo.modules.Module;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Component
public class ImageResizing implements Module {
    @Override
    public boolean isSupported(String format) {
        return format.endsWith(".jpg");
    }

    @Override
    public String getDescription() {
        return "Image resizing";
    }

    @Override
    public void Execute(String file) {
        try {
            File inputFile = new File(file);
            BufferedImage originalImage = ImageIO.read(inputFile);
            BufferedImage resizedImage = new BufferedImage(500, 500, originalImage.getType());
            Graphics2D g = resizedImage.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(originalImage, 0, 0, 500, 500, null);
            g.dispose();
            File outputFile = new File(file + "-resized");
            ImageIO.write(resizedImage, "jpg", outputFile);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
