package de.team33.trial.sphinx.alpha.visual;

import de.team33.sphinx.alpha.activity.Event;
import de.team33.sphinx.alpha.option.PreferredBounds;
import de.team33.sphinx.alpha.visual.JFrames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.prefs.Preferences;


class PreferredBoundsTrial {

    private static final Preferences PREFERENCES = Preferences.userRoot()
                                                              .node(PreferredBoundsTrial.class.getPackage().getName());

    private final Preferences prefs = PREFERENCES.node(PreferredBoundsTrial.class.getSimpleName());
    private final JFrame frame;

    public PreferredBoundsTrial(final String[] args) {
        PreferredBounds bounds = new PreferredBounds(prefs, new Rectangle(100, 100, 600, 400));
        this.frame = JFrames.builder()
                            .on(Event.MOUSE_PRESSED, this::mousePressed)
                            .on(Event.MOUSE_RELEASED, this::mouseReleased)
                            .on(Event.MOUSE_ENTERED, this::mouseEntered)
                            .on(Event.MOUSE_EXITED, this::mouseExited)
                            //.setPreferredBounds(bounds)
                            .setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE)
                            .setVisible(true)
                            .build();
    }

    private void mouseExited(final MouseEvent e) {
        frame.setTitle("mouse exited @(" + e.getX() + ", " + e.getY() + ")");
    }

    private void mouseEntered(final MouseEvent e) {
        frame.setTitle("mouse entered @(" + e.getX() + ", " + e.getY() + ")");
    }

    private void mouseReleased(final MouseEvent e) {
        frame.setTitle("mouse released @(" + e.getX() + ", " + e.getY() + ")");
    }

    private void mousePressed(final MouseEvent e) {
        frame.setTitle("mouse pressed @(" + e.getX() + ", " + e.getY() + ")");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PreferredBoundsTrial(args));
    }
}
