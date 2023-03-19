package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Component;
import java.util.function.Supplier;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;

/**
 * Utility class to handle {@link JLayeredPane}s.
 */
@SuppressWarnings("unused")
public final class JLayeredPanes {

    private JLayeredPanes() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JLayeredPane}.
     */
    public static Builder<JLayeredPane, ?> builder() {
        return new Builder<>(JLayeredPane::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JLayeredPane}.
     */
    public static <T extends JLayeredPane> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JLayeredPane}.
     * 
     * @param <T> The final type of the target instances, at least {@link JLayeredPane}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JLayeredPane, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JLayeredPane}.
     * 
     * @param <T> The final type of the target instance, at least {@link JLayeredPane}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JLayeredPane, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JLayeredPane#remove(int)
         */
        default S remove(final int arg0) {
            return setup(result -> result.remove(arg0));
        }

        /**
         * @see JLayeredPane#removeAll()
         */
        default S removeAll() {
            return setup(JLayeredPane::removeAll);
        }

        /**
         * @see JLayeredPane#setLayer(Component, int)
         */
        default S setLayer(final Component arg0, final int arg1) {
            return setup(result -> result.setLayer(arg0, arg1));
        }

        /**
         * @see JLayeredPane#setLayer(Component, int, int)
         */
        default S setLayer(final Component arg0, final int arg1, final int arg2) {
            return setup(result -> result.setLayer(arg0, arg1, arg2));
        }

        /**
         * @see JLayeredPane#setPosition(Component, int)
         */
        default S setPosition(final Component arg0, final int arg1) {
            return setup(result -> result.setPosition(arg0, arg1));
        }
    }
}
