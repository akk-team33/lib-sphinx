package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JFrame}s.
 */
@SuppressWarnings("unused")
public final class JFrames {

    private JFrames() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JFrame}.
     *
     * @see #builder(Supplier)
     * @see JFrame#JFrame()
     */
    public static Builder<JFrame> builder() {
        return new Builder<>(JFrame::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JFrame}.
     *
     * @see #builder(Supplier)
     * @see JFrame#JFrame(String)
     */
    public static Builder<JFrame> builder(final String title) {
        return new Builder<>(() -> new JFrame(title), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JFrame}.
     *
     * @see #builder(Supplier)
     * @see JFrame#JFrame(GraphicsConfiguration)
     */
    public static Builder<JFrame> builder(final GraphicsConfiguration gc) {
        return new Builder<>(() -> new JFrame(gc), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JFrame}.
     *
     * @see #builder(Supplier)
     * @see JFrame#JFrame(String, GraphicsConfiguration)
     */
    public static Builder<JFrame> builder(final String title, final GraphicsConfiguration gc) {
        return new Builder<>(() -> new JFrame(title, gc), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     *
     * @param <F> The final type of the target instances, at least {@link JFrame}.
     */
    public static <F extends JFrame> Builder<F> builder(final Supplier<F> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     *
     * @param <F> The final type of the target instance, at least {@link JFrame}.
     */
    public static <F extends JFrame> Charger<F> charger(final F target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Returns a new {@link Setup} for a given {@link JFrame} instance.
     */
    public static Setup<JFrame, ?> setup(final JFrame target) {
        return charger(target);
    }

    /**
     * Utility interface to set up a target instance of {@link JFrame}.
     *
     * @param <F> The final type of the target instance, at least {@link JFrame}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<F extends JFrame, S extends Setup<F, S>> extends Frames.Setup<F, S> {

        /**
         * @see JFrame#setContentPane(Container)
         */
        default S setContentPane(final Container contentPane) {
            return setup(result -> result.setContentPane(contentPane));
        }

        /**
         * @see JFrame#setDefaultCloseOperation(int)
         */
        default S setDefaultCloseOperation(final int operation) {
            return setup(result -> result.setDefaultCloseOperation(operation));
        }

        /**
         * @see JFrame#setGlassPane(Component)
         */
        default S setGlassPane(final Component glassPane) {
            return setup(result -> result.setGlassPane(glassPane));
        }

        /**
         * @see JFrame#setJMenuBar(JMenuBar)
         */
        default S setJMenuBar(final JMenuBar menuBar) {
            return setup(result -> result.setJMenuBar(menuBar));
        }

        /**
         * @see JFrame#setLayeredPane(JLayeredPane)
         */
        default S setLayeredPane(final JLayeredPane layeredPane) {
            return setup(result -> result.setLayeredPane(layeredPane));
        }

        /**
         * @see JFrame#setTransferHandler(TransferHandler)
         */
        default S setTransferHandler(final TransferHandler handler) {
            return setup(result -> result.setTransferHandler(handler));
        }
    }

    /**
     * Builder implementation to build target instances of {@link JFrame}.
     *
     * @param <F> The final type of the target instances, at least {@link JFrame}.
     */
    public static final class Builder<F extends JFrame>
            extends LateBuilder<F, Builder<F>> implements Setup<F, Builder<F>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<F> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JFrame}.
     *
     * @param <F> The final type of the target instance, at least {@link JFrame}.
     */
    public static final class Charger<F extends JFrame>
            extends de.team33.patterns.building.elara.Charger<F, Charger<F>>
            implements Setup<F, Charger<F>> {

        @SuppressWarnings("unchecked")
        private Charger(final F target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }
}
