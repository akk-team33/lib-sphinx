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
        SwingUtilities.invokeLater(new Main(args[0]));
    }

    @Override
    public void run() {
        frame.setVisible(true);
    }
}
