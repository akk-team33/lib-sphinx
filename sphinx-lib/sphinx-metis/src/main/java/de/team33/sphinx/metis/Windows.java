package de.team33.sphinx.metis;

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
     * @param <W> The final type of the target instances, at least {@link Window}.
     */
    public static <W extends Window> Builder<W> builder(final Supplier<W> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * @see #builder(Supplier)
     * @see Window#Window(Frame)
     */
    public static Builder<Window> builder(final Frame owner) {
        return new Builder<>(() -> new Window(owner), Builder.class);
    }

    /**
     * @see #builder(Supplier)
     * @see Window#Window(Window)
     */
    public static Builder<Window> builder(final Window owner) {
        return new Builder<>(() -> new Window(owner), Builder.class);
    }

    /**
     * @see #builder(Supplier)
     * @see Window#Window(Window, GraphicsConfiguration)
     */
    public static Builder<Window> builder(final Window owner, final GraphicsConfiguration gc) {
        return new Builder<>(() -> new Window(owner, gc), Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     *
     * @param <W> The final type of the target instance, at least {@link Window}.
     */
    public static <W extends Window> Charger<W> charger(final W target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Utility interface to set up a target instance of {@link Window}.
     *
     * @param <W> The final type of the target instance, at least {@link Window}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<W extends Window, S extends Setup<W, S>> extends Containers.Setup<W, S> {

        /**
         * @see Window#setAlwaysOnTop(boolean)
         */
        default S setAlwaysOnTop(final boolean always) {
            return setup(result -> result.setAlwaysOnTop(always));
        }

        /**
         * @see Window#setAutoRequestFocus(boolean)
         */
        default S setAutoRequestFocus(final boolean auto) {
            return setup(result -> result.setAutoRequestFocus(auto));
        }

        /**
         * @see Window#setFocusableWindowState(boolean)
         */
        default S setFocusableWindowState(final boolean focusable) {
            return setup(result -> result.setFocusableWindowState(focusable));
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
        default S setIconImages(final List<? extends Image> images) {
            return setup(result -> result.setIconImages(images));
        }

        /**
         * @see Window#setLocationByPlatform(boolean)
         */
        default S setLocationByPlatform(final boolean byPlatform) {
            return setup(result -> result.setLocationByPlatform(byPlatform));
        }

        /**
         * @see Window#setLocationRelativeTo(Component)
         */
        default S setLocationRelativeTo(final Component component) {
            return setup(result -> result.setLocationRelativeTo(component));
        }

        /**
         * @see Window#setModalExclusionType(ModalExclusionType)
         */
        default S setModalExclusionType(final ModalExclusionType type) {
            return setup(result -> result.setModalExclusionType(type));
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
         * @see Window#setType(Type)
         */
        default S setType(final Type type) {
            return setup(result -> result.setType(type));
        }

        /**
         * @see Window#pack()
         */
        default S pack() {
            return setup(Window::pack);
        }
    }

    /**
     * Builder implementation to build target instances of {@link Window}.
     *
     * @param <W> The final type of the target instances, at least {@link Window}.
     */
    public static final class Builder<W extends Window>
            extends LateBuilder<W, Builder<W>> implements Setup<W, Builder<W>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<W> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link Window}.
     *
     * @param <W> The final type of the target instance, at least {@link Window}.
     */
    public static final class Charger<W extends Window>
            extends de.team33.patterns.building.elara.Charger<W, Charger<W>>
            implements Setup<W, Charger<W>> {

        @SuppressWarnings("unchecked")
        private Charger(final W target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }
}
