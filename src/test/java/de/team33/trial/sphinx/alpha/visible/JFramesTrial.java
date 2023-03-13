package de.team33.trial.sphinx.alpha.visible;

import de.team33.sphinx.alpha.visible.JFrames;

import javax.swing.*;

class JFramesTrial {

    private final JFrame frame;

    public JFramesTrial(final String[] args) {
        this.frame = JFrames.builder()
                            .setup(t -> t.setBounds(200, 150, 600, 800))
                            .setLocation(100, 100)
                            .setSize(640, 480)
                            .setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE)
                            .setVisible(true)
                            .build();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JFramesTrial(args));
    }
}