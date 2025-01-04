package de.team33.sphinx.random.display.visual;

import de.team33.sphinx.random.display.business.RandomAreaProcess;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

class RandomArea extends JPanel {

    private final RandomAreaProcess process;

    RandomArea(final RandomAreaProcess process) {
        this.process = process.addUpdateImageListener(this::onUpdateImage);
    }

    private void onUpdateImage(final RandomAreaProcess sender) {
        if (this.process == sender) {
            repaint();
        }
    }

    @Override
    protected final void paintComponent(final Graphics g) {
        super.paintComponent(g);
        Optional.ofNullable(process.getImage())
                .ifPresent(image -> {
                    // Bildgröße und Panelgröße ermitteln
                    int imgWidth = image.getWidth();
                    int imgHeight = image.getHeight();
                    int panelWidth = getWidth();
                    int panelHeight = getHeight();

                    // Berechnung des Skalierungsfaktors
                    double scale = Math.min((double) panelWidth / imgWidth, (double) panelHeight / imgHeight);

                    // Neue Dimensionen des Bildes
                    int newWidth = (int) (imgWidth * scale);
                    int newHeight = (int) (imgHeight * scale);

                    // Bild zentriert zeichnen
                    int x = (panelWidth - newWidth) / 2;
                    int y = (panelHeight - newHeight) / 2;

                    g.drawImage(image, x, y, newWidth, newHeight, this);
                });
    }
}
