package de.team33.sphinx.random.display.visual;

import de.team33.sphinx.random.display.business.RandomAreaProcess;
import de.team33.sphinx.random.display.business.RandomChartProcess;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

class RandomChart extends JPanel {

    private final RandomChartProcess process;

    RandomChart(final RandomChartProcess process) {
        this.process = process.addUpdateImageListener(this::onUpdateImage);
    }

    private void onUpdateImage(final RandomChartProcess sender) {
        if (this.process == sender) {
            repaint();
        }
    }

    @Override
    protected final void paintComponent(final Graphics g) {
        super.paintComponent(g);
        Optional.ofNullable(process.getImage())
                .ifPresent(image -> {
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                });
    }
}
