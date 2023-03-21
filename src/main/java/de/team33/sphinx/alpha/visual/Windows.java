package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Window;
import java.awt.Window.Type;
import java.util.List;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link Window}s.
 */
@SuppressWarnings("unused")
public final class Windows {

    private Windows() {
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link Window}.
     */
    public static <T extends Window> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link Window}.
     * 
     * @param <T> The final type of the target instances, at least {@link Window}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends Window, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link Window}.
     * 
     * @param <T> The final type of the target instance, at least {@link Window}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends Window, S extends Setup<T, S>> extends Containers.Setup<T, S> {

        /**
         * @see Window#setAlwaysOnTop(boolean)
         */
        default S setAlwaysOnTop(final boolean alwaysOnTop) {
            return setup(result -> result.setAlwaysOnTop(alwaysOnTop));
        }

        /**
         * @see Window#setAutoRequestFocus(boolean)
         */
        default S setAutoRequestFocus(final boolean autoRequestFocus) {
            return setup(result -> result.setAutoRequestFocus(autoRequestFocus));
        }

        /**
         * @see Window#setBackground(Color)
         */
        default S setBackground(final Color bgColor) {
            return setup(result -> result.setBackground(bgColor));
        }

        /**
         * @see Window#setBounds(Rectangle)
         */
        default S setBounds(final Rectangle r) {
            return setup(result -> result.setBounds(r));
        }

        /**
         * @see Window#setBounds(int, int, int, int)
         */
        default S setBounds(final int x, final int y, final int width, final int height) {
            return setup(result -> result.setBounds(x, y, width, height));
        }

        /**
         * @see Window#setCursor(Cursor)
         */
        default S setCursor(final Cursor cursor) {
            return setup(result -> result.setCursor(cursor));
        }

        /**
         * @see Window#setFocusCycleRoot(boolean)
         */
        default S setFocusCycleRoot(final boolean focusCycleRoot) {
            return setup(result -> result.setFocusCycleRoot(focusCycleRoot));
        }

        /**
         * @see Window#setFocusableWindowState(boolean)
         */
        default S setFocusableWindowState(final boolean focusableWindowState) {
            return setup(result -> result.setFocusableWindowState(focusableWindowState));
        }

        /**
         * @see Window#setIconImage(Image)
         */
        default S setIconImage(final Image image) {
            return setup(result -> result.setIconImage(image));
        }

        /**
         * @see Window#setIconImages(List)
         */
        default S setIconImages(final List<? extends java.awt.Image> icons) {
            return setup(result -> result.setIconImages(icons));
        }

        /**
         * @see Window#setLocation(Point)
         */
        default S setLocation(final Point p) {
            return setup(result -> result.setLocation(p));
        }

        /**
         * @see Window#setLocation(int, int)
         */
        default S setLocation(final int x, final int y) {
            return setup(result -> result.setLocation(x, y));
        }

        /**
         * @see Window#setLocationByPlatform(boolean)
         */
        default S setLocationByPlatform(final boolean locationByPlatform) {
            return setup(result -> result.setLocationByPlatform(locationByPlatform));
        }

        /**
         * @see Window#setLocationRelativeTo(Component)
         */
        default S setLocationRelativeTo(final Component c) {
            return setup(result -> result.setLocationRelativeTo(c));
        }

        /**
         * @see Window#setMinimumSize(Dimension)
         */
        default S setMinimumSize(final Dimension minimumSize) {
            return setup(result -> result.setMinimumSize(minimumSize));
        }

        /**
         * @see Window#setModalExclusionType(ModalExclusionType)
         */
        default S setModalExclusionType(final ModalExclusionType exclusionType) {
            return setup(result -> result.setModalExclusionType(exclusionType));
        }

        /**
         * @see Window#setOpacity(float)
         */
        default S setOpacity(final float opacity) {
            return setup(result -> result.setOpacity(opacity));
        }

        /**
         * @see Window#setShape(Shape)
         */
        default S setShape(final Shape shape) {
            return setup(result -> result.setShape(shape));
        }

        /**
         * @see Window#setSize(Dimension)
         */
        default S setSize(final Dimension d) {
            return setup(result -> result.setSize(d));
        }

        /**
         * @see Window#setSize(int, int)
         */
        default S setSize(final int width, final int height) {
            return setup(result -> result.setSize(width, height));
        }

        /**
         * @see Window#setType(Type)
         */
        default S setType(final Type type) {
            return setup(result -> result.setType(type));
        }

        /**
         * @see Window#setVisible(boolean)
         */
        default S setVisible(final boolean b) {
            return setup(result -> result.setVisible(b));
        }
    }
}
