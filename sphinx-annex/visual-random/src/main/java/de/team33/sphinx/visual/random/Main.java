package de.team33.sphinx.visual.random;

import de.team33.sphinx.alpha.visual.JFrames;

import javax.swing.*;
import java.awt.*;

public class Main implements Runnable {

    private final JFrame frame = JFrames.builder()
                                        .setSize(640, 480)
                                        .setLocationByPlatform(true)
                                        .setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
                                        .build();

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Main());
    }

    @Override
    public void run() {
        frame.setVisible(true);
    }
}
