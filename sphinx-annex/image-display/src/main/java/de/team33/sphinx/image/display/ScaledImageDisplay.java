package de.team33.sphinx.image.display;

import de.team33.sphinx.image.display.visual.ImagePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ScaledImageDisplay {

    public static void main(String[] args) {
        // Pfad zur Bilddatei
        String imagePath = "/Users/andi/Pictures/2004-14-22 (Babs)/DSC_1772-1.jpg";

        // Überprüfen, ob die Datei existiert
        File file = new File(imagePath);
        if (!file.exists()) {
            System.out.println("Die Bilddatei wurde nicht gefunden: " + imagePath);
            return;
        }

        // Bild laden
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (Exception e) {
            System.out.println("Fehler beim Laden des Bildes: " + e.getMessage());
            return;
        }

        // Erstellen des Fensters
        JFrame frame = new JFrame("Bildanzeige mit Skalierung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Optional: Standardgröße des Fensters

        // Bildanzeige-Komponente hinzufügen
        ImagePanel imagePanel = ImagePanel.builder(image).build();
        frame.add(imagePanel);

        // Fenster sichtbar machen
        frame.setVisible(true);
    }
}
