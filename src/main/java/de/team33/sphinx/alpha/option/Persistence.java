package de.team33.sphinx.alpha.option;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.util.Optional;
import java.util.prefs.Preferences;

public class Persistence {

    private static final String X = "x";
    private static final String Y = "y";
    private static final String WIDTH = "width";
    private static final String HEIGHT = "height";
    private static final String X_STATE = "xState";

    private final Preferences preferences;
    private final Rectangle fallback;

    public Persistence(final Preferences preferences, final Rectangle fallback) {
        this.preferences = preferences;
        this.fallback = fallback;
    }

    public Rectangle getBounds() {
        return new Rectangle(preferences.getInt(X, fallback.x),
                             preferences.getInt(Y, fallback.y),
                             preferences.getInt(WIDTH, fallback.width),
                             preferences.getInt(HEIGHT, fallback.height));
    }

    public int getExtendedState() {
        return preferences.getInt(X_STATE, 0);
    }

    public void onMovedOrResized(final ComponentEvent message) {
        final Component cmp = message.getComponent();
        final int xState = Optional.of(cmp)
                                   .filter(Frame.class::isInstance)
                                   .map(Frame.class::cast)
                                   .map(Frame::getExtendedState)
                                   .orElse(0);
        if (0 == xState) {
            preferences.putInt(X, cmp.getX());
            preferences.putInt(Y, cmp.getY());
            preferences.putInt(WIDTH, cmp.getWidth());
            preferences.putInt(HEIGHT, cmp.getHeight());
        }
    }

    public void onStateChanged(final WindowEvent message) {
        preferences.putInt(X_STATE, message.getNewState());
    }
}
