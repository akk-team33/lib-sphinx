package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.util.function.Supplier;
import javax.swing.JViewport;
import javax.swing.border.Border;
import javax.swing.plaf.ViewportUI;

/**
 * Utility class to handle {@link JViewport}s.
 */
@SuppressWarnings("unused")
public final class JViewports {

    private JViewports() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JViewport}.
     */
    public static Builder<JViewport, ?> builder() {
        return new Builder<>(JViewport::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JViewport}.
     */
    public static <T extends JViewport> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JViewport}.
     * 
     * @param <T> The final type of the target instances, at least {@link JViewport}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JViewport, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JViewport}.
     * 
     * @param <T> The final type of the target instance, at least {@link JViewport}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JViewport, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JViewport#remove(Component)
         */
        default S remove(final Component arg0) {
            return setup(result -> result.remove(arg0));
        }

        /**
         * @see JViewport#setBorder(Border)
         */
        default S setBorder(final Border arg0) {
            return setup(result -> result.setBorder(arg0));
        }

        /**
         * @see JViewport#setExtentSize(Dimension)
         */
        default S setExtentSize(final Dimension arg0) {
            return setup(result -> result.setExtentSize(arg0));
        }

        /**
         * @see JViewport#setScrollMode(int)
         */
        default S setScrollMode(final int arg0) {
            return setup(result -> result.setScrollMode(arg0));
        }

        /**
         * @see JViewport#setUI(ViewportUI)
         */
        default S setUI(final ViewportUI arg0) {
            return setup(result -> result.setUI(arg0));
        }

        /**
         * @see JViewport#setView(Component)
         */
        default S setView(final Component arg0) {
            return setup(result -> result.setView(arg0));
        }

        /**
         * @see JViewport#setViewPosition(Point)
         */
        default S setViewPosition(final Point arg0) {
            return setup(result -> result.setViewPosition(arg0));
        }

        /**
         * @see JViewport#setViewSize(Dimension)
         */
        default S setViewSize(final Dimension arg0) {
            return setup(result -> result.setViewSize(arg0));
        }
    }
}
