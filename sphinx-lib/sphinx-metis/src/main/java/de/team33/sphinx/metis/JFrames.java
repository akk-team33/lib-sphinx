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
     */
    public static Builder<JFrame> builder() {
        return new Builder<>(JFrame::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JFrame}.
     */
    public static <T extends JFrame> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JFrame}.
     */
    public static <T extends JFrame> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link JFrame}.
     * 
     * @param <T> The final type of the target instances, at least {@link JFrame}.
     */
    public static final class Builder<T extends JFrame>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JFrame}.
     * 
     * @param <T> The final type of the target instance, at least {@link JFrame}.
     */
    public static final class Charger<T extends JFrame>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JFrame}.
     * 
     * @param <T> The final type of the target instance, at least {@link JFrame}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JFrame, S extends Setup<T, S>> extends Frames.Setup<T, S> {

        /**
         * @see JFrame#setContentPane(Container)
         */
        default S setContentPane(final Container arg0) {
            return setup(result -> result.setContentPane(arg0));
        }

        /**
         * @see JFrame#setDefaultCloseOperation(int)
         */
        default S setDefaultCloseOperation(final int arg0) {
            return setup(result -> result.setDefaultCloseOperation(arg0));
        }

        /**
         * @see JFrame#setGlassPane(Component)
         */
        default S setGlassPane(final Component arg0) {
            return setup(result -> result.setGlassPane(arg0));
        }

        /**
         * @see JFrame#setJMenuBar(JMenuBar)
         */
        default S setJMenuBar(final JMenuBar arg0) {
            return setup(result -> result.setJMenuBar(arg0));
        }

        /**
         * @see JFrame#setLayeredPane(JLayeredPane)
         */
        default S setLayeredPane(final JLayeredPane arg0) {
            return setup(result -> result.setLayeredPane(arg0));
        }

        /**
         * @see JFrame#setTransferHandler(TransferHandler)
         */
        default S setTransferHandler(final TransferHandler arg0) {
            return setup(result -> result.setTransferHandler(arg0));
        }
    }
}
