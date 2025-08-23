package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JLayeredPane}s.
 */
@SuppressWarnings("unused")
public final class JLayeredPanes {

    private JLayeredPanes() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JLayeredPane}.
     */
    public static Builder<JLayeredPane> builder() {
        return new Builder<>(JLayeredPane::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JLayeredPane}.
     */
    public static <T extends JLayeredPane> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JLayeredPane}.
     */
    public static <T extends JLayeredPane> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link JLayeredPane}.
     * 
     * @param <T> The final type of the target instances, at least {@link JLayeredPane}.
     */
    public static final class Builder<T extends JLayeredPane>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JLayeredPane}.
     * 
     * @param <T> The final type of the target instance, at least {@link JLayeredPane}.
     */
    public static final class Charger<T extends JLayeredPane>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JLayeredPane}.
     * 
     * @param <T> The final type of the target instance, at least {@link JLayeredPane}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JLayeredPane, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JLayeredPane#setLayer(Component, int)
         */
        default S setLayer(final Component arg0, final int arg1) {
            return setup(result -> result.setLayer(arg0, arg1));
        }

        /**
         * @see JLayeredPane#setLayer(Component, int, int)
         */
        default S setLayer(final Component arg0, final int arg1, final int arg2) {
            return setup(result -> result.setLayer(arg0, arg1, arg2));
        }

        /**
         * @see JLayeredPane#setPosition(Component, int)
         */
        default S setPosition(final Component arg0, final int arg1) {
            return setup(result -> result.setPosition(arg0, arg1));
        }
    }
}
