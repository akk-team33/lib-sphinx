package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.MenuBar;
import java.awt.MenuComponent;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link Frame}s.
 */
@SuppressWarnings("unused")
public final class Frames {

    private Frames() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link Frame}.
     */
    public static Builder<Frame, ?> builder() {
        return new Builder<>(Frame::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link Frame}.
     */
    public static <T extends Frame> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link Frame}.
     * 
     * @param <T> The final type of the target instances, at least {@link Frame}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends Frame, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link Frame}.
     * 
     * @param <T> The final type of the target instance, at least {@link Frame}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends Frame, S extends Setup<T, S>> extends Windows.Setup<T, S> {

        /**
         * @see Frame#remove(MenuComponent)
         */
        default S remove(final MenuComponent m) {
            return setup(result -> result.remove(m));
        }

        /**
         * @see Frame#setBackground(Color)
         */
        default S setBackground(final Color bgColor) {
            return setup(result -> result.setBackground(bgColor));
        }

        /**
         * @see Frame#setExtendedState(int)
         */
        default S setExtendedState(final int state) {
            return setup(result -> result.setExtendedState(state));
        }

        /**
         * @see Frame#setIconImage(Image)
         */
        default S setIconImage(final Image image) {
            return setup(result -> result.setIconImage(image));
        }

        /**
         * @see Frame#setMaximizedBounds(Rectangle)
         */
        default S setMaximizedBounds(final Rectangle bounds) {
            return setup(result -> result.setMaximizedBounds(bounds));
        }

        /**
         * @see Frame#setMenuBar(MenuBar)
         */
        default S setMenuBar(final MenuBar mb) {
            return setup(result -> result.setMenuBar(mb));
        }

        /**
         * @see Frame#setOpacity(float)
         */
        default S setOpacity(final float opacity) {
            return setup(result -> result.setOpacity(opacity));
        }

        /**
         * @see Frame#setResizable(boolean)
         */
        default S setResizable(final boolean resizable) {
            return setup(result -> result.setResizable(resizable));
        }

        /**
         * @see Frame#setShape(Shape)
         */
        default S setShape(final Shape shape) {
            return setup(result -> result.setShape(shape));
        }

        /**
         * @see Frame#setState(int)
         */
        default S setState(final int state) {
            return setup(result -> result.setState(state));
        }

        /**
         * @see Frame#setTitle(String)
         */
        default S setTitle(final String title) {
            return setup(result -> result.setTitle(title));
        }

        /**
         * @see Frame#setUndecorated(boolean)
         */
        default S setUndecorated(final boolean undecorated) {
            return setup(result -> result.setUndecorated(undecorated));
        }
    }
}
