package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Component;
import java.util.function.Supplier;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.border.Border;
import javax.swing.plaf.ScrollPaneUI;

/**
 * Utility class to handle {@link JScrollPane}s.
 */
@SuppressWarnings("unused")
public final class JScrollPanes {

    private JScrollPanes() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JScrollPane}.
     */
    public static Builder<JScrollPane> builder() {
        return new Builder<>(JScrollPane::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JScrollPane}.
     */
    public static <T extends JScrollPane> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JScrollPane}.
     * 
     * @param <T> The final type of the target instances, at least {@link JScrollPane}.
     */
    public static final class Builder<T extends JScrollPane>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JScrollPane}.
     * 
     * @param <T> The final type of the target instance, at least {@link JScrollPane}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JScrollPane, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JScrollPane#setColumnHeader(JViewport)
         */
        default S setColumnHeader(final JViewport arg0) {
            return setup(result -> result.setColumnHeader(arg0));
        }

        /**
         * @see JScrollPane#setColumnHeaderView(Component)
         */
        default S setColumnHeaderView(final Component arg0) {
            return setup(result -> result.setColumnHeaderView(arg0));
        }

        /**
         * @see JScrollPane#setCorner(String, Component)
         */
        default S setCorner(final String arg0, final Component arg1) {
            return setup(result -> result.setCorner(arg0, arg1));
        }

        /**
         * @see JScrollPane#setHorizontalScrollBar(JScrollBar)
         */
        default S setHorizontalScrollBar(final JScrollBar arg0) {
            return setup(result -> result.setHorizontalScrollBar(arg0));
        }

        /**
         * @see JScrollPane#setHorizontalScrollBarPolicy(int)
         */
        default S setHorizontalScrollBarPolicy(final int arg0) {
            return setup(result -> result.setHorizontalScrollBarPolicy(arg0));
        }

        /**
         * @see JScrollPane#setRowHeader(JViewport)
         */
        default S setRowHeader(final JViewport arg0) {
            return setup(result -> result.setRowHeader(arg0));
        }

        /**
         * @see JScrollPane#setRowHeaderView(Component)
         */
        default S setRowHeaderView(final Component arg0) {
            return setup(result -> result.setRowHeaderView(arg0));
        }

        /**
         * @see JScrollPane#setUI(ScrollPaneUI)
         */
        default S setUI(final ScrollPaneUI arg0) {
            return setup(result -> result.setUI(arg0));
        }

        /**
         * @see JScrollPane#setVerticalScrollBar(JScrollBar)
         */
        default S setVerticalScrollBar(final JScrollBar arg0) {
            return setup(result -> result.setVerticalScrollBar(arg0));
        }

        /**
         * @see JScrollPane#setVerticalScrollBarPolicy(int)
         */
        default S setVerticalScrollBarPolicy(final int arg0) {
            return setup(result -> result.setVerticalScrollBarPolicy(arg0));
        }

        /**
         * @see JScrollPane#setViewport(JViewport)
         */
        default S setViewport(final JViewport arg0) {
            return setup(result -> result.setViewport(arg0));
        }

        /**
         * @see JScrollPane#setViewportBorder(Border)
         */
        default S setViewportBorder(final Border arg0) {
            return setup(result -> result.setViewportBorder(arg0));
        }

        /**
         * @see JScrollPane#setViewportView(Component)
         */
        default S setViewportView(final Component arg0) {
            return setup(result -> result.setViewportView(arg0));
        }

        /**
         * @see JScrollPane#setWheelScrollingEnabled(boolean)
         */
        default S setWheelScrollingEnabled(final boolean arg0) {
            return setup(result -> result.setWheelScrollingEnabled(arg0));
        }
    }
}
