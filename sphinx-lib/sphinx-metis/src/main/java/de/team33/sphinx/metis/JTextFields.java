package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import javax.swing.text.Document;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JTextField}s.
 */
@SuppressWarnings("unused")
public final class JTextFields {

    private JTextFields() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JTextField}.
     *
     * @see #builder(Supplier)
     * @see JTextField#JTextField()
     */
    public static Builder<JTextField> builder() {
        return new Builder<>(JTextField::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JTextField}.
     *
     * @see #builder(Supplier)
     * @see JTextField#JTextField(String)
     */
    public static Builder<JTextField> builder(String text) {
        return new Builder<>(() -> new JTextField(text), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JTextField}.
     *
     * @see #builder(Supplier)
     * @see JTextField#JTextField(String, int)
     */
    public static Builder<JTextField> builder(int columns) {
        return new Builder<>(() -> new JTextField(columns), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JTextField}.
     *
     * @see #builder(Supplier)
     * @see JTextField#JTextField(String, int)
     */
    public static Builder<JTextField> builder(String text, int columns) {
        return new Builder<>(() -> new JTextField(text, columns), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JTextField}.
     *
     * @see #builder(Supplier)
     * @see JTextField#JTextField(Document, String, int)
     */
    public static Builder<JTextField> builder(Document doc, String text, int columns) {
        return new Builder<>(() -> new JTextField(doc, text, columns), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTextField}.
     */
    public static <T extends JTextField> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JTextField}.
     */
    public static <T extends JTextField> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Returns a new {@link Setup} for a given {@link JTextField} instance.
     */
    public static Setup<JTextField, ?> setup(final JTextField target) {
        return charger(target);
    }

    /**
     * Utility interface to set up a target instance of {@link JTextField}.
     *
     * @param <T> The final type of the target instance, at least {@link JTextField}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JTextField, S extends Setup<T, S>> extends JTextComponents.Setup<T, S> {

        /**
         * @see JTextField#setAction(Action)
         */
        default S setAction(final Action action) {
            return setup(result -> result.setAction(action));
        }

        /**
         * @see JTextField#setActionCommand(String)
         */
        default S setActionCommand(final String command) {
            return setup(result -> result.setActionCommand(command));
        }

        /**
         * @see JTextField#setColumns(int)
         */
        default S setColumns(final int columns) {
            return setup(result -> result.setColumns(columns));
        }

        /**
         * @see JTextField#setHorizontalAlignment(int)
         */
        default S setHorizontalAlignment(final int alignment) {
            return setup(result -> result.setHorizontalAlignment(alignment));
        }

        /**
         * @see JTextField#setScrollOffset(int)
         */
        default S setScrollOffset(final int offset) {
            return setup(result -> result.setScrollOffset(offset));
        }
    }

    /**
     * Builder implementation to build target instances of {@link JTextField}.
     *
     * @param <T> The final type of the target instances, at least {@link JTextField}.
     */
    public static final class Builder<T extends JTextField>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JTextField}.
     *
     * @param <T> The final type of the target instance, at least {@link JTextField}.
     */
    public static final class Charger<T extends JTextField>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings("unchecked")
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }
}
