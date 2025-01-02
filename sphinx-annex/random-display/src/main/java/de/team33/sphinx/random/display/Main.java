package de.team33.sphinx.random.display;

import de.team33.sphinx.random.display.business.RandomProcess;
import de.team33.sphinx.random.display.visual.RandomFrame;

import javax.swing.*;

public class Main implements Runnable {

    private final RandomProcess process = new RandomProcess();
    private final RandomFrame frame = new RandomFrame(process);

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Main());
    }

    @Override
    public void run() {
        frame.setVisible(true);
        process.start();
    }
}
