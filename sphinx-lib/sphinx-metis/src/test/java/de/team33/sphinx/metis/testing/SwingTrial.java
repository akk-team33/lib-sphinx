package de.team33.sphinx.metis.testing;

import de.team33.sphinx.metis.JFrames;

import javax.swing.*;
import java.awt.*;

public abstract class SwingTrial {

    public static void run(final SwingTrial trial) {
        SwingUtilities.invokeLater(trial::run);
    }

    private void run() {
        JFrames.builder()
               .setContentPane(contentPane())
               .setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
               .setup(this::setupFrame)
               .setLocationByPlatform(true)
               .pack()
               .setVisible(true)
               .build();
    }

    protected abstract Container contentPane();

    protected abstract void setupFrame(final JFrame jFrame);
}
