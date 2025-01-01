package de.team33.sphinx.image.display;

import de.team33.sphinx.image.display.visual.ImagePanel;
import de.team33.sphinx.image.display.visual.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageDisplay implements Runnable {

    private final MainFrame frame;

    public ImageDisplay(final String imagePath) throws IOException {
        final File file = new File(imagePath);
        if (!file.isFile()) {
            throw new IOException("not a regular file: " + imagePath);
        }
        final BufferedImage image = ImageIO.read(file);
        frame = MainFrame.builder()
                         .setTitle(imagePath)
                         .add(ImagePanel.builder(image).build())
                         .build();
    }

    public static void main(String[] args) throws IOException {
        final String imagePath = "/Users/andi/Pictures/2004-14-22 (Babs)/DSC_1772-1.jpg";
        SwingUtilities.invokeLater(new ImageDisplay(imagePath));
    }

    @Override
    public void run() {
        frame.setVisible(true);
    }
}
