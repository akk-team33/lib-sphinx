package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JPanel}s.
 */
@SuppressWarnings("unused")
public final class JPanels {

    private JPanels() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JPanel}.
     *
     * @see #builder(Supplier)
     * @see JPanel#JPanel()
     */
    public static Builder<JPanel> builder() {
        return new Builder<>(JPanel::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JPanel}.
     *
     * @see #builder(Supplier)
     * @see JPanel#JPanel(boolean)
     */
    public static Builder<JPanel> builder(final boolean doubleBuffered) {
        return new Builder<>(() -> new JPanel(doubleBuffered), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JPanel}.
     *
     * @see #builder(Supplier)
     * @see JPanel#JPanel(LayoutManager)
     */
    public static Builder<JPanel> builder(final LayoutManager layout) {
        return new Builder<>(() -> new JPanel(layout), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JPanel}.
     *
     * @see #builder(Supplier)
     * @see JPanel#JPanel(LayoutManager, boolean)
     */
    public static Builder<JPanel> builder(final LayoutManager layout, final boolean doubleBuffered) {
        return new Builder<>(() -> new JPanel(layout, doubleBuffered), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     *
     * @param <P> The final type of the target instances, at least {@link JPanel}.
     */
    public static <P extends JPanel> Builder<P> builder(final Supplier<P> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     *
     * @param <P> The final type of the target instance, at least {@link JPanel}.
     */
    public static <P extends JPanel> Charger<P> charger(final P target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Returns a new {@link Setup} for a given {@link JPanel} instance.
     */
    public static Setup<JPanel, ?> setup(final JPanel target) {
        return charger(target);
    }

    /**
     * Utility interface to set up a target instance of {@link JPanel}.
     *
     * @param <P> The final type of the target instance, at least {@link JPanel}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<P extends JPanel, S extends Setup<P, S>> extends JComponents.Setup<P, S> {

        /**
         * @see JPanel#setUI(PanelUI)
         */
        default S setUI(final PanelUI ui) {
            return setup(result -> result.setUI(ui));
        }
    }

    /**
     * Builder implementation to build target instances of {@link JPanel}.
     *
     * @param <P> The final type of the target instances, at least {@link JPanel}.
     */
    public static final class Builder<P extends JPanel>
            extends LateBuilder<P, Builder<P>> implements Setup<P, Builder<P>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<P> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JPanel}.
     *
     * @param <P> The final type of the target instance, at least {@link JPanel}.
     */
    public static final class Charger<P extends JPanel>
            extends de.team33.patterns.building.elara.Charger<P, Charger<P>>
            implements Setup<P, Charger<P>> {

        @SuppressWarnings("unchecked")
        private Charger(final P target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }
}
