package de.team33.sphinx.visual.random;

import de.team33.sphinx.alpha.visual.JFrames;
import de.team33.sphinx.visual.random.business.RandomProcess;
import de.team33.sphinx.visual.random.visual.RandomFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

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
