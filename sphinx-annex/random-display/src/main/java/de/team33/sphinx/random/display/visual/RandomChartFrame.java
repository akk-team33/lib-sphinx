package de.team33.sphinx.random.display.visual;

import de.team33.sphinx.alpha.activity.Event;
import de.team33.sphinx.alpha.visual.JButtons;
import de.team33.sphinx.alpha.visual.JPanels;
import de.team33.sphinx.random.display.business.RandomChartProcess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class RandomChartFrame extends StdFrame {

    private final RandomChartProcess process;
    private final JButton startButton = JButtons.builder()
                                                .setText("Start")
                                                .on(Event.ACTION_PERFORMED, this::onStart)
                                                .build();

    public RandomChartFrame(final RandomChartProcess process) {
        this.process = process.addUpdateImageListener(this::onUpdate);
        setLayout(new BorderLayout());
        add(new RandomChart(process), BorderLayout.CENTER);
        add(JPanels.builder()
                   .setLayout(new BorderLayout())
                   .add(startButton, BorderLayout.WEST)
                   .build(),
            BorderLayout.SOUTH);
        Event.WINDOW_CLOSING.add(this, this::onClosing);
    }

    private void onStart(final ActionEvent event) {
        startButton.setEnabled(false);
        process.start();
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
