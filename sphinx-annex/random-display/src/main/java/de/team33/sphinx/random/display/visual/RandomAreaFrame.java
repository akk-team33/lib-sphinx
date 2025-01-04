package de.team33.sphinx.random.display.visual;

import de.team33.sphinx.alpha.activity.Event;
import de.team33.sphinx.random.display.business.RandomAreaProcess;

import java.awt.event.WindowEvent;

public class RandomAreaFrame extends StdFrame {

    private final RandomAreaProcess process;

    public RandomAreaFrame(final RandomAreaProcess process) {
        this.process = process.addUpdateImageListener(this::onUpdate);
        setContentPane(new RandomArea(process));
        Event.WINDOW_CLOSING.add(this, this::onClosing);
    }

    private void onUpdate(final RandomAreaProcess sender) {
        if (sender == process) {
            setTitle(String.format("%,d", process.getCount()));
        }
    }

    private void onClosing(final WindowEvent event) {
        process.stop();
    }
}
