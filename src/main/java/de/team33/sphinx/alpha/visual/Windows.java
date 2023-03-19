package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
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
        default S setAlwaysOnTop(final boolean arg0) {
            return setup(result -> result.setAlwaysOnTop(arg0));
        }

        /**
         * @see Window#setAutoRequestFocus(boolean)
         */
        default S setAutoRequestFocus(final boolean arg0) {
            return setup(result -> result.setAutoRequestFocus(arg0));
        }

        /**
         * @see Window#setBackground(Color)
         */
        default S setBackground(final Color arg0) {
            return setup(result -> result.setBackground(arg0));
        }

        /**
         * @see Window#setBounds(Rectangle)
         */
        default S setBounds(final Rectangle arg0) {
            return setup(result -> result.setBounds(arg0));
        }

        /**
         * @see Window#setBounds(int, int, int, int)
         */
        default S setBounds(final int arg0, final int arg1, final int arg2, final int arg3) {
            return setup(result -> result.setBounds(arg0, arg1, arg2, arg3));
        }

        /**
         * @see Window#setCursor(Cursor)
         */
        default S setCursor(final Cursor arg0) {
            return setup(result -> result.setCursor(arg0));
        }

        /**
         * @see Window#setFocusCycleRoot(boolean)
         */
        default S setFocusCycleRoot(final boolean arg0) {
            return setup(result -> result.setFocusCycleRoot(arg0));
        }

        /**
         * @see Window#setFocusableWindowState(boolean)
         */
        default S setFocusableWindowState(final boolean arg0) {
            return setup(result -> result.setFocusableWindowState(arg0));
        }

        /**
         * @see Window#setIconImage(Image)
         */
        default S setIconImage(final Image arg0) {
            return setup(result -> result.setIconImage(arg0));
        }

        /**
         * @see Window#setIconImages(List)
         */
        default S setIconImages(final List<? extends java.awt.Image> arg0) {
            return setup(result -> result.setIconImages(arg0));
        }

        /**
         * @see Window#setLocation(Point)
         */
        default S setLocation(final Point arg0) {
            return setup(result -> result.setLocation(arg0));
        }

        /**
         * @see Window#setLocation(int, int)
         */
        default S setLocation(final int arg0, final int arg1) {
            return setup(result -> result.setLocation(arg0, arg1));
        }

        /**
         * @see Window#setLocationByPlatform(boolean)
         */
        default S setLocationByPlatform(final boolean arg0) {
            return setup(result -> result.setLocationByPlatform(arg0));
        }

        /**
         * @see Window#setLocationRelativeTo(Component)
         */
        default S setLocationRelativeTo(final Component arg0) {
            return setup(result -> result.setLocationRelativeTo(arg0));
        }

        /**
         * @see Window#setMinimumSize(Dimension)
         */
        default S setMinimumSize(final Dimension arg0) {
            return setup(result -> result.setMinimumSize(arg0));
        }

        /**
         * @see Window#setModalExclusionType(ModalExclusionType)
         */
        default S setModalExclusionType(final ModalExclusionType arg0) {
            return setup(result -> result.setModalExclusionType(arg0));
        }

        /**
         * @see Window#setOpacity(float)
         */
        default S setOpacity(final float arg0) {
            return setup(result -> result.setOpacity(arg0));
        }

        /**
         * @see Window#setShape(Shape)
         */
        default S setShape(final Shape arg0) {
            return setup(result -> result.setShape(arg0));
        }

        /**
         * @see Window#setSize(Dimension)
         */
        default S setSize(final Dimension arg0) {
            return setup(result -> result.setSize(arg0));
        }

        /**
         * @see Window#setSize(int, int)
         */
        default S setSize(final int arg0, final int arg1) {
            return setup(result -> result.setSize(arg0, arg1));
        }

        /**
         * @see Window#setType(Type)
         */
        default S setType(final Type arg0) {
            return setup(result -> result.setType(arg0));
        }

        /**
         * @see Window#setVisible(boolean)
         */
        default S setVisible(final boolean arg0) {
            return setup(result -> result.setVisible(arg0));
        }
    }
}
