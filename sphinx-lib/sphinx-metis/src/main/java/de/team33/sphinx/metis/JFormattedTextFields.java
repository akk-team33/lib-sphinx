package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JFormattedTextField}s.
 */
@SuppressWarnings("unused")
public final class JFormattedTextFields {

    private JFormattedTextFields() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JFormattedTextField}.
     */
    public static Builder<JFormattedTextField> builder() {
        return new Builder<>(JFormattedTextField::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JFormattedTextField}.
     */
    public static <T extends JFormattedTextField> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JFormattedTextField}.
     */
    public static <T extends JFormattedTextField> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link JFormattedTextField}.
     * 
     * @param <T> The final type of the target instances, at least {@link JFormattedTextField}.
     */
    public static final class Builder<T extends JFormattedTextField>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JFormattedTextField}.
     * 
     * @param <T> The final type of the target instance, at least {@link JFormattedTextField}.
     */
    public static final class Charger<T extends JFormattedTextField>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JFormattedTextField}.
     * 
     * @param <T> The final type of the target instance, at least {@link JFormattedTextField}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JFormattedTextField, S extends Setup<T, S>> extends JTextFields.Setup<T, S> {

        /**
         * @see JFormattedTextField#setFocusLostBehavior(int)
         */
        default S setFocusLostBehavior(final int arg0) {
            return setup(result -> result.setFocusLostBehavior(arg0));
        }

        /**
         * @see JFormattedTextField#setFormatterFactory(AbstractFormatterFactory)
         */
        default S setFormatterFactory(final AbstractFormatterFactory arg0) {
            return setup(result -> result.setFormatterFactory(arg0));
        }

        /**
         * @see JFormattedTextField#setValue(Object)
         */
        default S setValue(final Object arg0) {
            return setup(result -> result.setValue(arg0));
        }
    }
}
