package de.team33.sphinx.random.display;

import de.team33.sphinx.random.display.business.RandomAreaProcess;
import de.team33.sphinx.random.display.business.RandomCase;
import de.team33.sphinx.random.display.business.RandomChartProcess;
import de.team33.sphinx.random.display.visual.RandomAreaFrame;
import de.team33.sphinx.random.display.visual.RandomChartFrame;

import javax.swing.*;

public class ChartMain implements Runnable {

    private final RandomChartProcess process = new RandomChartProcess(RandomCase.RANDOM_GENERATOR);
    private final RandomChartFrame frame = new RandomChartFrame(process);

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new ChartMain());
    }

    @Override
    public void run() {
        frame.setVisible(true);
        process.start();
    }
}
