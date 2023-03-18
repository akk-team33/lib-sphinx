package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;

import javax.swing.JButton;

/**
 * Utility class to handle {@link JButton}s.
 */
public final class JButtons {

    /**
     * Returns a new {@link Builder} for target instances of type {@link JButton}.
     */
    public static Builder<JButton, ?> builder() {
        return new Builder<>(JButton::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JButton}.
     */
    public static <T extends JButton> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JButton}.
     * 
     * @param <T> The final type of the target instances, at least {@link JButton}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JButton, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JButton}.
     * 
     * @param <T> The final type of the target instance, at least {@link JButton}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JButton, S extends Setup<T, S>> extends AbstractButtons.Setup<T, S> {

        /**
         * @see JButton#setDefaultCapable(boolean)
         */
        default S setDefaultCapable(final boolean arg0) {
            return setup(result -> result.setDefaultCapable(arg0));
        }
    }
}
