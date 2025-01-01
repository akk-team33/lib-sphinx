package de.team33.sphinx.image.display.visual;

import de.team33.sphinx.alpha.visual.JPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.function.Supplier;

public class ImagePanel extends JPanel {

    private final BufferedImage image;

    private ImagePanel(BufferedImage image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

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
    }

    /**
     * Returns a new {@link JPanels.Builder} for target instances of type {@link ImagePanel}.
     */
    public static JPanels.Builder<ImagePanel> builder(final BufferedImage image) {
        return JPanels.builder(() -> new ImagePanel(image));
    }

    /**
     * Returns a new {@link JPanels.Builder} for target instances as supplied by the given {@link Supplier}.
     *
     * @param <T> The final type of the target instances, at least {@link ImagePanel}.
     */
    public static <T extends ImagePanel> JPanels.Builder<T> builder(final Supplier<T> newTarget) {
        return JPanels.builder(newTarget);
    }
}
