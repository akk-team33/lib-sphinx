package de.team33.sphinx.image.display.visual;

import de.team33.sphinx.alpha.visual.JFrames;

import javax.swing.*;

public class MainFrame extends JFrame {

    private MainFrame() {
        setLocationByPlatform(true);
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static JFrames.Builder<MainFrame> builder() {
        return JFrames.builder(() -> new MainFrame());
    }
}
