package de.team33.sphinx.random.display;

import de.team33.sphinx.random.display.business.RandomCase;
import de.team33.sphinx.random.display.business.RandomAreaProcess;
import de.team33.sphinx.random.display.visual.RandomAreaFrame;

import javax.swing.*;

public class AreaMain implements Runnable {

    private final RandomAreaProcess process = new RandomAreaProcess(RandomCase.RANDOM_GENERATOR);
    private final RandomAreaFrame frame = new RandomAreaFrame(process);

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new AreaMain());
    }

    @Override
    public void run() {
        frame.setVisible(true);
        process.start();
    }
}
