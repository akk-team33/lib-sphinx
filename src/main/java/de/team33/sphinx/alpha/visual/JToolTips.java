package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;

import javax.swing.JComponent;
import javax.swing.JToolTip;

/**
 * Utility class to handle {@link JToolTip}s.
 */
public final class JToolTips {

    /**
     * Returns a new {@link Builder} for target instances of type {@link JToolTip}.
     */
    public static Builder<JToolTip, ?> builder() {
        return new Builder<>(JToolTip::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JToolTip}.
     */
    public static <T extends JToolTip> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JToolTip}.
     * 
     * @param <T> The final type of the target instances, at least {@link JToolTip}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JToolTip, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JToolTip}.
     * 
     * @param <T> The final type of the target instance, at least {@link JToolTip}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JToolTip, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JToolTip#setTipText(String)
         */
        default S setTipText(final String arg0) {
            return setup(result -> result.setTipText(arg0));
        }

        /**
         * @see JToolTip#setComponent(JComponent)
         */
        default S setComponent(final JComponent arg0) {
            return setup(result -> result.setComponent(arg0));
        }
    }
}
