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
    public static Builder<JTextField, ?> builder() {
        return new Builder<>(JTextField::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTextField}.
     */
    public static <T extends JTextField> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JTextField}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTextField}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JTextField, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JTextField}.
     * 
     * @param <T> The final type of the target instance, at least {@link JTextField}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JTextField, S extends Setup<T, S>> extends JTextComponents.Setup<T, S> {

        /**
         * @see JTextField#setAction(Action)
         */
        default S setAction(final Action a) {
            return setup(result -> result.setAction(a));
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
         * @see JTextField#setDocument(Document)
         */
        default S setDocument(final Document doc) {
            return setup(result -> result.setDocument(doc));
        }

        /**
         * @see JTextField#setFont(Font)
         */
        default S setFont(final Font f) {
            return setup(result -> result.setFont(f));
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
        default S setScrollOffset(final int scrollOffset) {
            return setup(result -> result.setScrollOffset(scrollOffset));
        }
    }
}
