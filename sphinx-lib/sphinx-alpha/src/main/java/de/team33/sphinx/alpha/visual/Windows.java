package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;

import java.awt.*;
import java.awt.Dialog.ModalExclusionType;
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
    public static <T extends Window> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link Window}.
     */
    public static <T extends Window> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link Window}.
     * 
     * @param <T> The final type of the target instances, at least {@link Window}.
     */
    public static final class Builder<T extends Window>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link Window}.
     * 
     * @param <T> The final type of the target instance, at least {@link Window}.
     */
    public static final class Charger<T extends Window>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link Window}.
     * 
     * @param <T> The final type of the target instance, at least {@link Window}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
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
         * @see Window#setType(Type)
         */
        default S setType(final Type arg0) {
            return setup(result -> result.setType(arg0));
        }

        /**
         * @see Window#pack()
         */
        default S pack() {
            return setup(Window::pack);
        }
    }
}
