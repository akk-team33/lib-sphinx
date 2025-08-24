package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JButton}s.
 */
@SuppressWarnings("unused")
public final class JButtons {

    private JButtons() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JButton}.
     */
    public static Builder<JButton> builder() {
        return new Builder<>(JButton::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     *
     * @param <B> The final type of the target instances, at least {@link JButton}.
     */
    public static <B extends JButton> Builder<B> builder(final Supplier<B> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     *
     * @param <B> The final type of the target instance, at least {@link JButton}.
     */
    public static <B extends JButton> Charger<B> charger(final B target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Returns a new {@link Setup} for a given {@link JButton} instance.
     */
    public static Setup<JButton, ?> setup(final JButton target) {
        return charger(target);
    }

    /**
     * Utility interface to set up a target instance of {@link JButton}.
     *
     * @param <B> The final type of the target instance, at least {@link JButton}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<B extends JButton, S extends Setup<B, S>> extends AbstractButtons.Setup<B, S> {

        /**
         * @see JButton#setDefaultCapable(boolean)
         */
        default S setDefaultCapable(final boolean capable) {
            return setup(result -> result.setDefaultCapable(capable));
        }
    }

    /**
     * Builder implementation to build target instances of {@link JButton}.
     *
     * @param <B> The final type of the target instances, at least {@link JButton}.
     */
    public static final class Builder<B extends JButton>
            extends LateBuilder<B, Builder<B>> implements Setup<B, Builder<B>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<B> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JButton}.
     *
     * @param <B> The final type of the target instance, at least {@link JButton}.
     */
    public static final class Charger<B extends JButton>
            extends de.team33.patterns.building.elara.Charger<B, Charger<B>>
            implements Setup<B, Charger<B>> {

        @SuppressWarnings("unchecked")
        private Charger(final B target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }
}
