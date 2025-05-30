package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.util.function.Supplier;
import javax.swing.JViewport;
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
    public static Builder<JViewport> builder() {
        return new Builder<>(JViewport::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JViewport}.
     */
    public static <T extends JViewport> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JViewport}.
     */
    public static <T extends JViewport> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link JViewport}.
     * 
     * @param <T> The final type of the target instances, at least {@link JViewport}.
     */
    public static final class Builder<T extends JViewport>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JViewport}.
     * 
     * @param <T> The final type of the target instance, at least {@link JViewport}.
     */
    public static final class Charger<T extends JViewport>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JViewport}.
     * 
     * @param <T> The final type of the target instance, at least {@link JViewport}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JViewport, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

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
