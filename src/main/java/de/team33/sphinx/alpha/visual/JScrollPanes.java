package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.LayoutManager;
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
    public static Builder<JScrollPane, ?> builder() {
        return new Builder<>(JScrollPane::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JScrollPane}.
     */
    public static <T extends JScrollPane> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JScrollPane}.
     * 
     * @param <T> The final type of the target instances, at least {@link JScrollPane}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JScrollPane, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JScrollPane}.
     * 
     * @param <T> The final type of the target instance, at least {@link JScrollPane}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JScrollPane, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JScrollPane#setColumnHeader(JViewport)
         */
        default S setColumnHeader(final JViewport columnHeader) {
            return setup(result -> result.setColumnHeader(columnHeader));
        }

        /**
         * @see JScrollPane#setColumnHeaderView(Component)
         */
        default S setColumnHeaderView(final Component view) {
            return setup(result -> result.setColumnHeaderView(view));
        }

        /**
         * @see JScrollPane#setComponentOrientation(ComponentOrientation)
         */
        default S setComponentOrientation(final ComponentOrientation co) {
            return setup(result -> result.setComponentOrientation(co));
        }

        /**
         * @see JScrollPane#setCorner(String, Component)
         */
        default S setCorner(final String key, final Component corner) {
            return setup(result -> result.setCorner(key, corner));
        }

        /**
         * @see JScrollPane#setHorizontalScrollBar(JScrollBar)
         */
        default S setHorizontalScrollBar(final JScrollBar horizontalScrollBar) {
            return setup(result -> result.setHorizontalScrollBar(horizontalScrollBar));
        }

        /**
         * @see JScrollPane#setHorizontalScrollBarPolicy(int)
         */
        default S setHorizontalScrollBarPolicy(final int policy) {
            return setup(result -> result.setHorizontalScrollBarPolicy(policy));
        }

        /**
         * @see JScrollPane#setLayout(LayoutManager)
         */
        default S setLayout(final LayoutManager layout) {
            return setup(result -> result.setLayout(layout));
        }

        /**
         * @see JScrollPane#setRowHeader(JViewport)
         */
        default S setRowHeader(final JViewport rowHeader) {
            return setup(result -> result.setRowHeader(rowHeader));
        }

        /**
         * @see JScrollPane#setRowHeaderView(Component)
         */
        default S setRowHeaderView(final Component view) {
            return setup(result -> result.setRowHeaderView(view));
        }

        /**
         * @see JScrollPane#setUI(ScrollPaneUI)
         */
        default S setUI(final ScrollPaneUI ui) {
            return setup(result -> result.setUI(ui));
        }

        /**
         * @see JScrollPane#setVerticalScrollBar(JScrollBar)
         */
        default S setVerticalScrollBar(final JScrollBar verticalScrollBar) {
            return setup(result -> result.setVerticalScrollBar(verticalScrollBar));
        }

        /**
         * @see JScrollPane#setVerticalScrollBarPolicy(int)
         */
        default S setVerticalScrollBarPolicy(final int policy) {
            return setup(result -> result.setVerticalScrollBarPolicy(policy));
        }

        /**
         * @see JScrollPane#setViewport(JViewport)
         */
        default S setViewport(final JViewport viewport) {
            return setup(result -> result.setViewport(viewport));
        }

        /**
         * @see JScrollPane#setViewportBorder(Border)
         */
        default S setViewportBorder(final Border viewportBorder) {
            return setup(result -> result.setViewportBorder(viewportBorder));
        }

        /**
         * @see JScrollPane#setViewportView(Component)
         */
        default S setViewportView(final Component view) {
            return setup(result -> result.setViewportView(view));
        }

        /**
         * @see JScrollPane#setWheelScrollingEnabled(boolean)
         */
        default S setWheelScrollingEnabled(final boolean handleWheel) {
            return setup(result -> result.setWheelScrollingEnabled(handleWheel));
        }
    }
}
