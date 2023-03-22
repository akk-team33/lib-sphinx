package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.function.Supplier;
import javax.swing.Action;
import javax.swing.JToolBar;
import javax.swing.plaf.ToolBarUI;

/**
 * Utility class to handle {@link JToolBar}s.
 */
@SuppressWarnings("unused")
public final class JToolBars {

    private JToolBars() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JToolBar}.
     */
    public static Builder<JToolBar, ?> builder() {
        return new Builder<>(JToolBar::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JToolBar}.
     */
    public static <T extends JToolBar> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JToolBar}.
     * 
     * @param <T> The final type of the target instances, at least {@link JToolBar}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JToolBar, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JToolBar}.
     * 
     * @param <T> The final type of the target instance, at least {@link JToolBar}.
     * @param <S> The final type of the Setup implementation.
     */
    @FunctionalInterface
    public interface Setup<T extends JToolBar, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JToolBar#add(Action)
         */
        default S add(final Action a) {
            return setup(result -> result.add(a));
        }

        /**
         * @see JToolBar#addSeparator()
         */
        default S addSeparator() {
            return setup(JToolBar::addSeparator);
        }

        /**
         * @see JToolBar#addSeparator(Dimension)
         */
        default S addSeparator(final Dimension size) {
            return setup(result -> result.addSeparator(size));
        }

        /**
         * @see JToolBar#setBorderPainted(boolean)
         */
        default S setBorderPainted(final boolean b) {
            return setup(result -> result.setBorderPainted(b));
        }

        /**
         * @see JToolBar#setFloatable(boolean)
         */
        default S setFloatable(final boolean b) {
            return setup(result -> result.setFloatable(b));
        }

        /**
         * @see JToolBar#setLayout(LayoutManager)
         */
        default S setLayout(final LayoutManager mgr) {
            return setup(result -> result.setLayout(mgr));
        }

        /**
         * @see JToolBar#setMargin(Insets)
         */
        default S setMargin(final Insets m) {
            return setup(result -> result.setMargin(m));
        }

        /**
         * @see JToolBar#setOrientation(int)
         */
        default S setOrientation(final int o) {
            return setup(result -> result.setOrientation(o));
        }

        /**
         * @see JToolBar#setRollover(boolean)
         */
        default S setRollover(final boolean rollover) {
            return setup(result -> result.setRollover(rollover));
        }

        /**
         * @see JToolBar#setUI(ToolBarUI)
         */
        default S setUI(final ToolBarUI ui) {
            return setup(result -> result.setUI(ui));
        }
    }
}
