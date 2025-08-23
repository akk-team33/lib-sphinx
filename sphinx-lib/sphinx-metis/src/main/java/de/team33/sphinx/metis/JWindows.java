package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JWindow}s.
 */
@SuppressWarnings("unused")
public final class JWindows {

    private JWindows() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JWindow}.
     */
    public static Builder<JWindow> builder() {
        return new Builder<>(JWindow::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JWindow}.
     */
    public static <T extends JWindow> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JWindow}.
     */
    public static <T extends JWindow> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link JWindow}.
     * 
     * @param <T> The final type of the target instances, at least {@link JWindow}.
     */
    public static final class Builder<T extends JWindow>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JWindow}.
     * 
     * @param <T> The final type of the target instance, at least {@link JWindow}.
     */
    public static final class Charger<T extends JWindow>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JWindow}.
     * 
     * @param <T> The final type of the target instance, at least {@link JWindow}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JWindow, S extends Setup<T, S>> extends Windows.Setup<T, S> {

        /**
         * @see JWindow#setContentPane(Container)
         */
        default S setContentPane(final Container arg0) {
            return setup(result -> result.setContentPane(arg0));
        }

        /**
         * @see JWindow#setGlassPane(Component)
         */
        default S setGlassPane(final Component arg0) {
            return setup(result -> result.setGlassPane(arg0));
        }

        /**
         * @see JWindow#setLayeredPane(JLayeredPane)
         */
        default S setLayeredPane(final JLayeredPane arg0) {
            return setup(result -> result.setLayeredPane(arg0));
        }

        /**
         * @see JWindow#setTransferHandler(TransferHandler)
         */
        default S setTransferHandler(final TransferHandler arg0) {
            return setup(result -> result.setTransferHandler(arg0));
        }
    }
}
