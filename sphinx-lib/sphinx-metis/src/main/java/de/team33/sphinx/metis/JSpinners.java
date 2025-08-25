package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import javax.swing.plaf.SpinnerUI;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JSpinner}s.
 */
@SuppressWarnings("unused")
public final class JSpinners {

    private JSpinners() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JSpinner}.
     */
    public static Builder<JSpinner> builder() {
        return new Builder<>(JSpinner::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JSpinner}.
     */
    public static <T extends JSpinner> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JSpinner}.
     */
    public static <T extends JSpinner> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Returns a new {@link Setup} for a given {@link JSpinner} instance.
     */
    public static Setup<JSpinner, ?> setup(final JSpinner target) {
        return charger(target);
    }

    /**
     * Builder implementation to build target instances of {@link JSpinner}.
     * 
     * @param <T> The final type of the target instances, at least {@link JSpinner}.
     */
    public static final class Builder<T extends JSpinner>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JSpinner}.
     * 
     * @param <T> The final type of the target instance, at least {@link JSpinner}.
     */
    public static final class Charger<T extends JSpinner>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings("unchecked")
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JSpinner}.
     * 
     * @param <T> The final type of the target instance, at least {@link JSpinner}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JSpinner, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JSpinner#setEditor(JComponent)
         */
        default S setEditor(final JComponent arg0) {
            return setup(result -> result.setEditor(arg0));
        }

        /**
         * @see JSpinner#setModel(SpinnerModel)
         */
        default S setModel(final SpinnerModel arg0) {
            return setup(result -> result.setModel(arg0));
        }

        /**
         * @see JSpinner#setUI(SpinnerUI)
         */
        default S setUI(final SpinnerUI arg0) {
            return setup(result -> result.setUI(arg0));
        }

        /**
         * @see JSpinner#setValue(Object)
         */
        default S setValue(final Object arg0) {
            return setup(result -> result.setValue(arg0));
        }
    }
}
