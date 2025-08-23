package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import javax.swing.border.Border;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JComponent}s.
 */
@SuppressWarnings("unused")
public final class JComponents {

    private JComponents() {
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JComponent}.
     */
    public static <T extends JComponent> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JComponent}.
     */
    public static <T extends JComponent> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link JComponent}.
     * 
     * @param <T> The final type of the target instances, at least {@link JComponent}.
     */
    public static final class Builder<T extends JComponent>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JComponent}.
     * 
     * @param <T> The final type of the target instance, at least {@link JComponent}.
     */
    public static final class Charger<T extends JComponent>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JComponent}.
     * 
     * @param <T> The final type of the target instance, at least {@link JComponent}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JComponent, S extends Setup<T, S>> extends Containers.Setup<T, S> {

        /**
         * @see JComponent#setActionMap(ActionMap)
         */
        default S setActionMap(final ActionMap arg0) {
            return setup(result -> result.setActionMap(arg0));
        }

        /**
         * @see JComponent#setAlignmentX(float)
         */
        default S setAlignmentX(final float arg0) {
            return setup(result -> result.setAlignmentX(arg0));
        }

        /**
         * @see JComponent#setAlignmentY(float)
         */
        default S setAlignmentY(final float arg0) {
            return setup(result -> result.setAlignmentY(arg0));
        }

        /**
         * @see JComponent#setAutoscrolls(boolean)
         */
        default S setAutoscrolls(final boolean arg0) {
            return setup(result -> result.setAutoscrolls(arg0));
        }

        /**
         * @see JComponent#setBorder(Border)
         */
        default S setBorder(final Border arg0) {
            return setup(result -> result.setBorder(arg0));
        }

        /**
         * @see JComponent#setComponentPopupMenu(JPopupMenu)
         */
        default S setComponentPopupMenu(final JPopupMenu arg0) {
            return setup(result -> result.setComponentPopupMenu(arg0));
        }

        /**
         * @see JComponent#setDebugGraphicsOptions(int)
         */
        default S setDebugGraphicsOptions(final int arg0) {
            return setup(result -> result.setDebugGraphicsOptions(arg0));
        }

        /**
         * @see JComponent#setDoubleBuffered(boolean)
         */
        default S setDoubleBuffered(final boolean arg0) {
            return setup(result -> result.setDoubleBuffered(arg0));
        }

        /**
         * @see JComponent#setInheritsPopupMenu(boolean)
         */
        default S setInheritsPopupMenu(final boolean arg0) {
            return setup(result -> result.setInheritsPopupMenu(arg0));
        }

        /**
         * @see JComponent#setInputMap(int, InputMap)
         */
        default S setInputMap(final int arg0, final InputMap arg1) {
            return setup(result -> result.setInputMap(arg0, arg1));
        }

        /**
         * @see JComponent#setInputVerifier(InputVerifier)
         */
        default S setInputVerifier(final InputVerifier arg0) {
            return setup(result -> result.setInputVerifier(arg0));
        }

        /**
         * @see JComponent#setOpaque(boolean)
         */
        default S setOpaque(final boolean arg0) {
            return setup(result -> result.setOpaque(arg0));
        }

        /**
         * @see JComponent#setRequestFocusEnabled(boolean)
         */
        default S setRequestFocusEnabled(final boolean arg0) {
            return setup(result -> result.setRequestFocusEnabled(arg0));
        }

        /**
         * @see JComponent#setToolTipText(String)
         */
        default S setToolTipText(final String arg0) {
            return setup(result -> result.setToolTipText(arg0));
        }

        /**
         * @see JComponent#setTransferHandler(TransferHandler)
         */
        default S setTransferHandler(final TransferHandler arg0) {
            return setup(result -> result.setTransferHandler(arg0));
        }

        /**
         * @see JComponent#setVerifyInputWhenFocusTarget(boolean)
         */
        default S setVerifyInputWhenFocusTarget(final boolean arg0) {
            return setup(result -> result.setVerifyInputWhenFocusTarget(arg0));
        }
    }
}
