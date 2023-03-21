package de.team33.sphinx.alpha.option;

import java.awt.*;
import java.util.function.Supplier;
import java.util.prefs.Preferences;

@SuppressWarnings({"unused", "WeakerAccess"})
public class BackedBounds {

    private static final String X = "x";
    private static final String Y = "y";
    private static final String WIDTH = "width";
    private static final String HEIGHT = "height";
    private static final String STATE = "xState";

    private final Preferences backing;
    private final Rectangle fallback;

    public BackedBounds(final Preferences backing, final Rectangle fallback) {
        this.backing = backing;
        this.fallback = fallback;
    }

    public final Point getLocation() {
        return new Point(backing.getInt(X, fallback.x),
                         backing.getInt(Y, fallback.y));
    }

    public final void setLocation(final Point point) {
        backing.putInt(X, point.x);
        backing.putInt(Y, point.y);
    }

    public final void setLocationIfNormal(final Point point) {
        setLocationIfNormal(() -> point);
    }

    public final void setLocationIfNormal(final Supplier<? extends Point> point) {
        if (0 == getState())
            setLocation(point.get());
    }

    public final Dimension getSize() {
        return new Dimension(backing.getInt(WIDTH, fallback.width),
                             backing.getInt(HEIGHT, fallback.height));
    }

    public final void setSize(final Dimension size) {
        backing.putInt(WIDTH, size.width);
        backing.putInt(HEIGHT, size.height);
    }

    public final void setSizeIfNormal(final Dimension size) {
        setSizeIfNormal(() -> size);
    }

    public final void setSizeIfNormal(final Supplier<? extends Dimension> size) {
        if (0 == getState())
            setSize(size.get());
    }

    public final Rectangle getBounds() {
        return new Rectangle(getLocation(), getSize());
    }

    public final void setBounds(final Rectangle bounds) {
        setLocation(bounds.getLocation());
        setSize(bounds.getSize());
    }

    public final void setBoundsIfNormal(final Rectangle bounds) {
        setBoundsIfNormal(() -> bounds);
    }

    public final void setBoundsIfNormal(final Supplier<? extends Rectangle> bounds) {
        if (0 == getState())
            setBounds(bounds.get());
    }

    public final int getState() {
        return backing.getInt(STATE, 0);
    }

    public final void setState(final int state) {
        backing.putInt(STATE, state);
    }
}
