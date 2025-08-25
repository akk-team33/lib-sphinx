package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ScrollPaneUI;
import java.awt.*;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JScrollPane}s.
 */
@SuppressWarnings("unused")
public final class JScrollPanes {

    private JScrollPanes() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JScrollPane}.
     *
     * @see #builder(Supplier)
     * @see JScrollPane#JScrollPane()
     */
    public static Builder<JScrollPane> builder() {
        return new Builder<>(JScrollPane::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JScrollPane}.
     *
     * @see #builder(Supplier)
     * @see JScrollPane#JScrollPane(Component)
     */
    public static Builder<JScrollPane> builder(final Component content) {
        return new Builder<>(() -> new JScrollPane(content), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JScrollPane}.
     *
     * @see #builder(Supplier)
     * @see JScrollPane#JScrollPane(int, int)
     */
    public static Builder<JScrollPane> builder(final int vsbPolicy, final int hsbPolicy) {
        return new Builder<>(() -> new JScrollPane(vsbPolicy, hsbPolicy), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JScrollPane}.
     *
     * @see #builder(Supplier)
     * @see JScrollPane#JScrollPane(Component, int, int)
     */
    public static Builder<JScrollPane> builder(final Component content, final int vsbPolicy, final int hsbPolicy) {
        return new Builder<>(() -> new JScrollPane(content, vsbPolicy, hsbPolicy), Builder.class);
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
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JScrollPane}.
     */
    public static <T extends JScrollPane> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Returns a new {@link Setup} for a given {@link JScrollPane} instance.
     */
    public static Setup<JScrollPane, ?> setup(final JScrollPane target) {
        return charger(target);
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
        default S setColumnHeader(final JViewport header) {
            return setup(result -> result.setColumnHeader(header));
        }

        /**
         * @see JScrollPane#setColumnHeaderView(Component)
         */
        default S setColumnHeaderView(final Component header) {
            return setup(result -> result.setColumnHeaderView(header));
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
        default S setHorizontalScrollBar(final JScrollBar bar) {
            return setup(result -> result.setHorizontalScrollBar(bar));
        }

        /**
         * @see JScrollPane#setHorizontalScrollBarPolicy(int)
         */
        default S setHorizontalScrollBarPolicy(final int policy) {
            return setup(result -> result.setHorizontalScrollBarPolicy(policy));
        }

        /**
         * @see JScrollPane#setRowHeader(JViewport)
         */
        default S setRowHeader(final JViewport header) {
            return setup(result -> result.setRowHeader(header));
        }

        /**
         * @see JScrollPane#setRowHeaderView(Component)
         */
        default S setRowHeaderView(final Component header) {
            return setup(result -> result.setRowHeaderView(header));
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
        default S setVerticalScrollBar(final JScrollBar bar) {
            return setup(result -> result.setVerticalScrollBar(bar));
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
        default S setViewportBorder(final Border border) {
            return setup(result -> result.setViewportBorder(border));
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
        default S setWheelScrollingEnabled(final boolean enabled) {
            return setup(result -> result.setWheelScrollingEnabled(enabled));
        }
    }

    /**
     * Builder implementation to build target instances of {@link JScrollPane}.
     *
     * @param <T> The final type of the target instances, at least {@link JScrollPane}.
     */
    public static final class Builder<T extends JScrollPane>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JScrollPane}.
     *
     * @param <T> The final type of the target instance, at least {@link JScrollPane}.
     */
    public static final class Charger<T extends JScrollPane>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings("unchecked")
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }
}
