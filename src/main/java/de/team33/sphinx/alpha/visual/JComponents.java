package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Set;
import java.util.function.Supplier;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JPopupMenu;
import javax.swing.TransferHandler;
import javax.swing.border.Border;

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
    public static <T extends JComponent> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JComponent}.
     * 
     * @param <T> The final type of the target instances, at least {@link JComponent}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JComponent, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JComponent}.
     * 
     * @param <T> The final type of the target instance, at least {@link JComponent}.
     * @param <S> The final type of the Setup implementation.
     */
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
         * @see JComponent#setBackground(Color)
         */
        default S setBackground(final Color arg0) {
            return setup(result -> result.setBackground(arg0));
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
         * @see JComponent#setEnabled(boolean)
         */
        default S setEnabled(final boolean arg0) {
            return setup(result -> result.setEnabled(arg0));
        }

        /**
         * @see JComponent#setFocusTraversalKeys(int, Set)
         */
        default S setFocusTraversalKeys(final int arg0, final Set<? extends java.awt.AWTKeyStroke> arg1) {
            return setup(result -> result.setFocusTraversalKeys(arg0, arg1));
        }

        /**
         * @see JComponent#setFont(Font)
         */
        default S setFont(final Font arg0) {
            return setup(result -> result.setFont(arg0));
        }

        /**
         * @see JComponent#setForeground(Color)
         */
        default S setForeground(final Color arg0) {
            return setup(result -> result.setForeground(arg0));
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
         * @see JComponent#setMaximumSize(Dimension)
         */
        default S setMaximumSize(final Dimension arg0) {
            return setup(result -> result.setMaximumSize(arg0));
        }

        /**
         * @see JComponent#setMinimumSize(Dimension)
         */
        default S setMinimumSize(final Dimension arg0) {
            return setup(result -> result.setMinimumSize(arg0));
        }

        /**
         * @see JComponent#setOpaque(boolean)
         */
        default S setOpaque(final boolean arg0) {
            return setup(result -> result.setOpaque(arg0));
        }

        /**
         * @see JComponent#setPreferredSize(Dimension)
         */
        default S setPreferredSize(final Dimension arg0) {
            return setup(result -> result.setPreferredSize(arg0));
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

        /**
         * @see JComponent#setVisible(boolean)
         */
        default S setVisible(final boolean arg0) {
            return setup(result -> result.setVisible(arg0));
        }
    }
}
