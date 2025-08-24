package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import java.awt.*;
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
    public static Builder<Frame> builder() {
        return new Builder<>(Frame::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link Frame}.
     *
     * @see #builder(Supplier)
     * @see Frame#Frame(String)
     */
    public static Builder<Frame> builder(final String title) {
        return new Builder<>(() -> new Frame(title), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link Frame}.
     *
     * @see #builder(Supplier)
     * @see Frame#Frame(String, GraphicsConfiguration)
     */
    public static Builder<Frame> builder(final String title, final GraphicsConfiguration gc) {
        return new Builder<>(() -> new Frame(title, gc), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     *
     * @param <F> The final type of the target instances, at least {@link Frame}.
     */
    public static <F extends Frame> Builder<F> builder(final Supplier<F> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     *
     * @param <F> The final type of the target instance, at least {@link Frame}.
     */
    public static <F extends Frame> Charger<F> charger(final F target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Returns a new {@link Setup} for a given {@link Frame} instance.
     */
    public static Setup<Frame, ?> setup(final Frame target) {
        return charger(target);
    }

    /**
     * Utility interface to set up a target instance of {@link Frame}.
     *
     * @param <F> The final type of the target instance, at least {@link Frame}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<F extends Frame, S extends Setup<F, S>> extends Windows.Setup<F, S> {

        /**
         * @see Frame#setExtendedState(int)
         */
        default S setExtendedState(final int state) {
            return setup(result -> result.setExtendedState(state));
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
        default S setMenuBar(final MenuBar menuBar) {
            return setup(result -> result.setMenuBar(menuBar));
        }

        /**
         * @see Frame#setResizable(boolean)
         */
        default S setResizable(final boolean resizable) {
            return setup(result -> result.setResizable(resizable));
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

    /**
     * Builder implementation to build target instances of {@link Frame}.
     *
     * @param <F> The final type of the target instances, at least {@link Frame}.
     */
    public static final class Builder<F extends Frame>
            extends LateBuilder<F, Builder<F>> implements Setup<F, Builder<F>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<F> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link Frame}.
     *
     * @param <F> The final type of the target instance, at least {@link Frame}.
     */
    public static final class Charger<F extends Frame>
            extends de.team33.patterns.building.elara.Charger<F, Charger<F>>
            implements Setup<F, Charger<F>> {

        @SuppressWarnings("unchecked")
        private Charger(final F target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }
}
