package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Component;
import java.util.function.Supplier;
import javax.swing.JComponent;
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
    public interface Setup<T extends JSplitPane, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JSplitPane#remove(Component)
         */
        default S remove(final Component arg0) {
            return setup(result -> result.remove(arg0));
        }

        /**
         * @see JSplitPane#remove(int)
         */
        default S remove(final int arg0) {
            return setup(result -> result.remove(arg0));
        }

        /**
         * @see JSplitPane#removeAll()
         */
        default S removeAll() {
            return setup(result -> result.removeAll());
        }

        /**
         * @see JSplitPane#setBottomComponent(Component)
         */
        default S setBottomComponent(final Component arg0) {
            return setup(result -> result.setBottomComponent(arg0));
        }

        /**
         * @see JSplitPane#setContinuousLayout(boolean)
         */
        default S setContinuousLayout(final boolean arg0) {
            return setup(result -> result.setContinuousLayout(arg0));
        }

        /**
         * @see JSplitPane#setDividerLocation(double)
         */
        default S setDividerLocation(final double arg0) {
            return setup(result -> result.setDividerLocation(arg0));
        }

        /**
         * @see JSplitPane#setDividerLocation(int)
         */
        default S setDividerLocation(final int arg0) {
            return setup(result -> result.setDividerLocation(arg0));
        }

        /**
         * @see JSplitPane#setDividerSize(int)
         */
        default S setDividerSize(final int arg0) {
            return setup(result -> result.setDividerSize(arg0));
        }

        /**
         * @see JSplitPane#setLastDividerLocation(int)
         */
        default S setLastDividerLocation(final int arg0) {
            return setup(result -> result.setLastDividerLocation(arg0));
        }

        /**
         * @see JSplitPane#setLeftComponent(Component)
         */
        default S setLeftComponent(final Component arg0) {
            return setup(result -> result.setLeftComponent(arg0));
        }

        /**
         * @see JSplitPane#setOneTouchExpandable(boolean)
         */
        default S setOneTouchExpandable(final boolean arg0) {
            return setup(result -> result.setOneTouchExpandable(arg0));
        }

        /**
         * @see JSplitPane#setOrientation(int)
         */
        default S setOrientation(final int arg0) {
            return setup(result -> result.setOrientation(arg0));
        }

        /**
         * @see JSplitPane#setResizeWeight(double)
         */
        default S setResizeWeight(final double arg0) {
            return setup(result -> result.setResizeWeight(arg0));
        }

        /**
         * @see JSplitPane#setRightComponent(Component)
         */
        default S setRightComponent(final Component arg0) {
            return setup(result -> result.setRightComponent(arg0));
        }

        /**
         * @see JSplitPane#setTopComponent(Component)
         */
        default S setTopComponent(final Component arg0) {
            return setup(result -> result.setTopComponent(arg0));
        }

        /**
         * @see JSplitPane#setUI(SplitPaneUI)
         */
        default S setUI(final SplitPaneUI arg0) {
            return setup(result -> result.setUI(arg0));
        }
    }
}
