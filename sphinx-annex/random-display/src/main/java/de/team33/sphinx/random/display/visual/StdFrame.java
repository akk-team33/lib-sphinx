package de.team33.sphinx.random.display.visual;

import de.team33.sphinx.alpha.visual.JFrames;

import javax.swing.*;

public class StdFrame extends JFrame {

    protected StdFrame() {
        setLocationByPlatform(true);
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static JFrames.Builder<StdFrame> builder() {
        return JFrames.builder(StdFrame::new);
    }
}
