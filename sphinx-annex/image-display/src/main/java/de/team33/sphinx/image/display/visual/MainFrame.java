package de.team33.sphinx.image.display.visual;

import de.team33.sphinx.image.display.business.ImageProcess;

public class MainFrame extends StdFrame {

    private final ImageProcess process;

    public MainFrame(final ImageProcess process) {
        this.process = process.addSetImageListener(this::onSetImage);
        setContentPane(new ImagePanel(process));
    }

    private void onSetImage(final ImageProcess sender) {
        if (process == sender) {
            setTitle(sender.getImagePath());
        }
    }
}
