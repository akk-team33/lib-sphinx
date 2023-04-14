package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Font;
import java.util.function.Supplier;
import javax.swing.Action;
import javax.swing.JTextField;
import javax.swing.text.Document;

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
         * @see JTextField#setDocument(Document)
         */
        default S setDocument(final Document arg0) {
            return setup(result -> result.setDocument(arg0));
        }

        /**
         * @see JTextField#setFont(Font)
         */
        default S setFont(final Font arg0) {
            return setup(result -> result.setFont(arg0));
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
