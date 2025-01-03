package de.team33.sphinx.random.display.visual;

import de.team33.sphinx.alpha.activity.Event;
import de.team33.sphinx.random.display.business.RandomProcess;

import java.awt.event.WindowEvent;

public class RandomFrame extends StdFrame {

    private final RandomProcess process;

    public RandomFrame(final RandomProcess process) {
        this.process = process.addUpdateImageListener(this::onUpdate);
        setContentPane(new ImagePanel(process));
        Event.WINDOW_CLOSING.add(this, this::onClosing);
    }

    private void onUpdate(final RandomProcess sender) {
        if (sender == process) {
            setTitle(String.format("%,d", process.getCount()));
        }
    }

    private void onClosing(final WindowEvent event) {
        process.stop();
    }
}
