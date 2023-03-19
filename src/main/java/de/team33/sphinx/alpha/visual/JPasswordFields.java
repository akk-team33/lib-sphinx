package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Utility class to handle {@link JPasswordField}s.
 */
@SuppressWarnings("unused")
public final class JPasswordFields {

    private JPasswordFields() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JPasswordField}.
     */
    public static Builder<JPasswordField, ?> builder() {
        return new Builder<>(JPasswordField::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JPasswordField}.
     */
    public static <T extends JPasswordField> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JPasswordField}.
     * 
     * @param <T> The final type of the target instances, at least {@link JPasswordField}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JPasswordField, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JPasswordField}.
     * 
     * @param <T> The final type of the target instance, at least {@link JPasswordField}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JPasswordField, S extends Setup<T, S>> extends JTextFields.Setup<T, S> {

        /**
         * @see JPasswordField#setEchoChar(char)
         */
        default S setEchoChar(final char arg0) {
            return setup(result -> result.setEchoChar(arg0));
        }
    }
}
