package de.team33.sphinx.image.display;

import de.team33.sphinx.image.display.business.ImageProcess;
import de.team33.sphinx.image.display.visual.MainFrame;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Paths;

public class Main implements Runnable {

    private final ImageProcess process = new ImageProcess();
    private final MainFrame frame = new MainFrame(process);

    public Main(final String imagePath) throws IOException {
        process.setImage(Paths.get(imagePath));
    }

    public static void main(String[] args) throws IOException {
        final String imagePath = "/Users/andi/Pictures/2004-14-22 (Babs)/DSC_1772-1.jpg";
        SwingUtilities.invokeLater(new Main(imagePath));
    }

    @Override
    public void run() {
        frame.setVisible(true);
    }
}
