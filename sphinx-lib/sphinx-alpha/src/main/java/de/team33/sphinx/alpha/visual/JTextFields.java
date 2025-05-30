package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.Action;
import javax.swing.JTextField;

/**
 * Utility class to handle {@link JTextField}s.
 */
@SuppressWarnings("unused")
public final class JTextFields {

    private JTextFields() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JTextField}.
     */
    public static Builder<JTextField> builder() {
        return new Builder<>(JTextField::new, Builder.class);
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
     * Builder implementation to build target instances of {@link JTextField}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTextField}.
     */
    public static final class Builder<T extends JTextField>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
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

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
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
        default S setAction(final Action arg0) {
            return setup(result -> result.setAction(arg0));
        }

        /**
         * @see JTextField#setActionCommand(String)
         */
        default S setActionCommand(final String arg0) {
            return setup(result -> result.setActionCommand(arg0));
        }

        /**
         * @see JTextField#setColumns(int)
         */
        default S setColumns(final int arg0) {
            return setup(result -> result.setColumns(arg0));
        }

        /**
         * @see JTextField#setHorizontalAlignment(int)
         */
        default S setHorizontalAlignment(final int arg0) {
            return setup(result -> result.setHorizontalAlignment(arg0));
        }

        /**
         * @see JTextField#setScrollOffset(int)
         */
        default S setScrollOffset(final int arg0) {
            return setup(result -> result.setScrollOffset(arg0));
        }
    }
}
