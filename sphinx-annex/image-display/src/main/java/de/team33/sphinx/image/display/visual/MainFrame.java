package de.team33.sphinx.image.display.visual;

import de.team33.sphinx.alpha.activity.Event;
import de.team33.sphinx.image.display.business.ImageProcess;

import java.awt.event.WindowEvent;

public class MainFrame extends StdFrame {

    private final ImageProcess process;

    public MainFrame(final ImageProcess process) {
        this.process = process.addSetImageListener(this::onSetImage);
        setContentPane(new ImagePanel(process));
        Event.WINDOW_CLOSING.add(this, this::onWindowClosing);
    }

    private void onWindowClosing(final WindowEvent event) {
        process.shutdown();
    }

    private void onSetImage(final ImageProcess sender) {
        if (process == sender) {
            setTitle(sender.getImagePath());
        }
    }
}
