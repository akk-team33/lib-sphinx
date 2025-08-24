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
     * @param <C> The final type of the target instances, at least {@link JComponent}.
     */
    public static <C extends JComponent> Builder<C> builder(final Supplier<C> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     *
     * @param <C> The final type of the target instance, at least {@link JComponent}.
     */
    public static <C extends JComponent> Charger<C> charger(final C target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Returns a new {@link Setup} for a given {@link JComponent} instance.
     */
    public static Setup<JComponent, ?> setup(final JComponent target) {
        return charger(target);
    }

    /**
     * Utility interface to set up a target instance of {@link JComponent}.
     *
     * @param <C> The final type of the target instance, at least {@link JComponent}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<C extends JComponent, S extends Setup<C, S>> extends Containers.Setup<C, S> {

        /**
         * @see JComponent#setActionMap(ActionMap)
         */
        default S setActionMap(final ActionMap map) {
            return setup(result -> result.setActionMap(map));
        }

        /**
         * @see JComponent#setAlignmentX(float)
         */
        default S setAlignmentX(final float alignmentX) {
            return setup(result -> result.setAlignmentX(alignmentX));
        }

        /**
         * @see JComponent#setAlignmentY(float)
         */
        default S setAlignmentY(final float alignmentY) {
            return setup(result -> result.setAlignmentY(alignmentY));
        }

        /**
         * @see JComponent#setAutoscrolls(boolean)
         */
        default S setAutoscrolls(final boolean value) {
            return setup(result -> result.setAutoscrolls(value));
        }

        /**
         * @see JComponent#setBorder(Border)
         */
        default S setBorder(final Border border) {
            return setup(result -> result.setBorder(border));
        }

        /**
         * @see JComponent#setComponentPopupMenu(JPopupMenu)
         */
        default S setComponentPopupMenu(final JPopupMenu menu) {
            return setup(result -> result.setComponentPopupMenu(menu));
        }

        /**
         * @see JComponent#setDebugGraphicsOptions(int)
         */
        default S setDebugGraphicsOptions(final int options) {
            return setup(result -> result.setDebugGraphicsOptions(options));
        }

        /**
         * @see JComponent#setDoubleBuffered(boolean)
         */
        default S setDoubleBuffered(final boolean value) {
            return setup(result -> result.setDoubleBuffered(value));
        }

        /**
         * @see JComponent#setInheritsPopupMenu(boolean)
         */
        default S setInheritsPopupMenu(final boolean value) {
            return setup(result -> result.setInheritsPopupMenu(value));
        }

        /**
         * @see JComponent#setInputMap(int, InputMap)
         */
        default S setInputMap(final int condition, final InputMap map) {
            return setup(result -> result.setInputMap(condition, map));
        }

        /**
         * @see JComponent#setInputVerifier(InputVerifier)
         */
        default S setInputVerifier(final InputVerifier verifier) {
            return setup(result -> result.setInputVerifier(verifier));
        }

        /**
         * @see JComponent#setOpaque(boolean)
         */
        default S setOpaque(final boolean opaque) {
            return setup(result -> result.setOpaque(opaque));
        }

        /**
         * @see JComponent#setRequestFocusEnabled(boolean)
         */
        default S setRequestFocusEnabled(final boolean enabled) {
            return setup(result -> result.setRequestFocusEnabled(enabled));
        }

        /**
         * @see JComponent#setToolTipText(String)
         */
        default S setToolTipText(final String text) {
            return setup(result -> result.setToolTipText(text));
        }

        /**
         * @see JComponent#setTransferHandler(TransferHandler)
         */
        default S setTransferHandler(final TransferHandler handler) {
            return setup(result -> result.setTransferHandler(handler));
        }

        /**
         * @see JComponent#setVerifyInputWhenFocusTarget(boolean)
         */
        default S setVerifyInputWhenFocusTarget(final boolean verify) {
            return setup(result -> result.setVerifyInputWhenFocusTarget(verify));
        }
    }

    /**
     * Builder implementation to build target instances of {@link JComponent}.
     *
     * @param <C> The final type of the target instances, at least {@link JComponent}.
     */
    public static final class Builder<C extends JComponent>
            extends LateBuilder<C, Builder<C>> implements Setup<C, Builder<C>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<C> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JComponent}.
     *
     * @param <C> The final type of the target instance, at least {@link JComponent}.
     */
    public static final class Charger<C extends JComponent>
            extends de.team33.patterns.building.elara.Charger<C, Charger<C>>
            implements Setup<C, Charger<C>> {

        @SuppressWarnings("unchecked")
        private Charger(final C target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }
}
