package de.team33.trial.sphinx.alpha.visible;

import de.team33.sphinx.alpha.visible.JFrames;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class JFramesTrial {

    private final JFrame frame;

    public JFramesTrial(final String[] args) {
        this.frame = JFrames.builder()
                            .setup(jFrame -> jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE))
                            .setup(jFrame -> jFrame.setVisible(true))
                            .build();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JFramesTrial(args));
    }
}