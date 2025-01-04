package de.team33.sphinx.random.display.visual;

import de.team33.sphinx.alpha.activity.Event;
import de.team33.sphinx.random.display.business.RandomAreaProcess;
import de.team33.sphinx.random.display.business.RandomChartProcess;

import java.awt.event.WindowEvent;

public class RandomChartFrame extends StdFrame {

    private final RandomChartProcess process;

    public RandomChartFrame(final RandomChartProcess process) {
        this.process = process.addUpdateImageListener(this::onUpdate);
        setContentPane(new RandomChart(process));
        Event.WINDOW_CLOSING.add(this, this::onClosing);
    }

    private void onUpdate(final RandomChartProcess sender) {
        if (sender == process) {
            setTitle(String.format("%,d", process.getCount()));
        }
    }

    private void onClosing(final WindowEvent event) {
        process.stop();
    }
}
