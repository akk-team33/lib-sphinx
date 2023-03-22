package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.JSeparator;
import javax.swing.plaf.SeparatorUI;

/**
 * Utility class to handle {@link JSeparator}s.
 */
@SuppressWarnings("unused")
public final class JSeparators {

    private JSeparators() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JSeparator}.
     */
    public static Builder<JSeparator, ?> builder() {
        return new Builder<>(JSeparator::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JSeparator}.
     */
    public static <T extends JSeparator> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JSeparator}.
     * 
     * @param <T> The final type of the target instances, at least {@link JSeparator}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JSeparator, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JSeparator}.
     * 
     * @param <T> The final type of the target instance, at least {@link JSeparator}.
     * @param <S> The final type of the Setup implementation.
     */
    @FunctionalInterface
    public interface Setup<T extends JSeparator, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JSeparator#setOrientation(int)
         */
        default S setOrientation(final int orientation) {
            return setup(result -> result.setOrientation(orientation));
        }

        /**
         * @see JSeparator#setUI(SeparatorUI)
         */
        default S setUI(final SeparatorUI ui) {
            return setup(result -> result.setUI(ui));
        }
    }
}
