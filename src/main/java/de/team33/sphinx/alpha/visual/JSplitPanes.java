package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Component;
import java.util.function.Supplier;
import javax.swing.JSplitPane;
import javax.swing.plaf.SplitPaneUI;

/**
 * Utility class to handle {@link JSplitPane}s.
 */
@SuppressWarnings("unused")
public final class JSplitPanes {

    private JSplitPanes() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JSplitPane}.
     */
    public static Builder<JSplitPane, ?> builder() {
        return new Builder<>(JSplitPane::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JSplitPane}.
     */
    public static <T extends JSplitPane> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JSplitPane}.
     * 
     * @param <T> The final type of the target instances, at least {@link JSplitPane}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JSplitPane, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JSplitPane}.
     * 
     * @param <T> The final type of the target instance, at least {@link JSplitPane}.
     * @param <S> The final type of the Setup implementation.
     */
    @FunctionalInterface
    public interface Setup<T extends JSplitPane, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JSplitPane#remove(Component)
         */
        default S remove(final Component component) {
            return setup(result -> result.remove(component));
        }

        /**
         * @see JSplitPane#remove(int)
         */
        default S remove(final int index) {
            return setup(result -> result.remove(index));
        }

        /**
         * @see JSplitPane#removeAll()
         */
        default S removeAll() {
            return setup(JSplitPane::removeAll);
        }

        /**
         * @see JSplitPane#setBottomComponent(Component)
         */
        default S setBottomComponent(final Component comp) {
            return setup(result -> result.setBottomComponent(comp));
        }

        /**
         * @see JSplitPane#setContinuousLayout(boolean)
         */
        default S setContinuousLayout(final boolean newContinuousLayout) {
            return setup(result -> result.setContinuousLayout(newContinuousLayout));
        }

        /**
         * @see JSplitPane#setDividerLocation(double)
         */
        default S setDividerLocation(final double proportionalLocation) {
            return setup(result -> result.setDividerLocation(proportionalLocation));
        }

        /**
         * @see JSplitPane#setDividerLocation(int)
         */
        default S setDividerLocation(final int location) {
            return setup(result -> result.setDividerLocation(location));
        }

        /**
         * @see JSplitPane#setDividerSize(int)
         */
        default S setDividerSize(final int newSize) {
            return setup(result -> result.setDividerSize(newSize));
        }

        /**
         * @see JSplitPane#setLastDividerLocation(int)
         */
        default S setLastDividerLocation(final int newLastLocation) {
            return setup(result -> result.setLastDividerLocation(newLastLocation));
        }

        /**
         * @see JSplitPane#setLeftComponent(Component)
         */
        default S setLeftComponent(final Component comp) {
            return setup(result -> result.setLeftComponent(comp));
        }

        /**
         * @see JSplitPane#setOneTouchExpandable(boolean)
         */
        default S setOneTouchExpandable(final boolean newValue) {
            return setup(result -> result.setOneTouchExpandable(newValue));
        }

        /**
         * @see JSplitPane#setOrientation(int)
         */
        default S setOrientation(final int orientation) {
            return setup(result -> result.setOrientation(orientation));
        }

        /**
         * @see JSplitPane#setResizeWeight(double)
         */
        default S setResizeWeight(final double value) {
            return setup(result -> result.setResizeWeight(value));
        }

        /**
         * @see JSplitPane#setRightComponent(Component)
         */
        default S setRightComponent(final Component comp) {
            return setup(result -> result.setRightComponent(comp));
        }

        /**
         * @see JSplitPane#setTopComponent(Component)
         */
        default S setTopComponent(final Component comp) {
            return setup(result -> result.setTopComponent(comp));
        }

        /**
         * @see JSplitPane#setUI(SplitPaneUI)
         */
        default S setUI(final SplitPaneUI ui) {
            return setup(result -> result.setUI(ui));
        }
    }
}
