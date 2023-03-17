package de.team33.sphinx.alpha.option;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.util.Optional;
import java.util.prefs.Preferences;

public class PreferredBounds {

    private static final String X = "x";
    private static final String Y = "y";
    private static final String WIDTH = "width";
    private static final String HEIGHT = "height";
    private static final String X_STATE = "xState";

    private final Preferences prefs;
    private final Rectangle fallback;

    public PreferredBounds(final Preferences prefs, final Rectangle fallback) {
        this.prefs = prefs;
        this.fallback = fallback;
    }

    public Rectangle getRectangle() {
        return new Rectangle(prefs.getInt(X, fallback.x),
                             prefs.getInt(Y, fallback.y),
                             prefs.getInt(WIDTH, fallback.width),
                             prefs.getInt(HEIGHT, fallback.height));
    }

    public int getExtendedState() {
        return prefs.getInt(X_STATE, 0);
    }

    public void store(final Rectangle rectangle, final int xState) {
        prefs.putInt(X, rectangle.x);
        prefs.putInt(Y, rectangle.y);
        prefs.putInt(WIDTH, rectangle.width);
        prefs.putInt(HEIGHT, rectangle.height);
        prefs.putInt(X_STATE, xState);
    }

    public final void onClosing(ComponentEvent event) {
        Optional.of(event.getComponent())
                .filter(Frame.class::isInstance)
                .map(Frame.class::cast)
                .ifPresent(this::onClosing);
    }

    private void onClosing(Frame frame) {
        store(frame.getBounds(), frame.getExtendedState());
    }
}
