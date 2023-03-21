package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.text.Document;

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
    public static Builder<JFormattedTextField, ?> builder() {
        return new Builder<>(JFormattedTextField::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JFormattedTextField}.
     */
    public static <T extends JFormattedTextField> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JFormattedTextField}.
     * 
     * @param <T> The final type of the target instances, at least {@link JFormattedTextField}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JFormattedTextField, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JFormattedTextField}.
     * 
     * @param <T> The final type of the target instance, at least {@link JFormattedTextField}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JFormattedTextField, S extends Setup<T, S>> extends JTextFields.Setup<T, S> {

        /**
         * @see JFormattedTextField#setDocument(Document)
         */
        default S setDocument(final Document doc) {
            return setup(result -> result.setDocument(doc));
        }

        /**
         * @see JFormattedTextField#setFocusLostBehavior(int)
         */
        default S setFocusLostBehavior(final int behavior) {
            return setup(result -> result.setFocusLostBehavior(behavior));
        }

        /**
         * @see JFormattedTextField#setFormatterFactory(AbstractFormatterFactory)
         */
        default S setFormatterFactory(final AbstractFormatterFactory tf) {
            return setup(result -> result.setFormatterFactory(tf));
        }

        /**
         * @see JFormattedTextField#setValue(Object)
         */
        default S setValue(final Object value) {
            return setup(result -> result.setValue(value));
        }
    }
}
