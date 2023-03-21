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
        default S setActionMap(final ActionMap am) {
            return setup(result -> result.setActionMap(am));
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
        default S setAutoscrolls(final boolean autoscrolls) {
            return setup(result -> result.setAutoscrolls(autoscrolls));
        }

        /**
         * @see JComponent#setBackground(Color)
         */
        default S setBackground(final Color bg) {
            return setup(result -> result.setBackground(bg));
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
        default S setComponentPopupMenu(final JPopupMenu popup) {
            return setup(result -> result.setComponentPopupMenu(popup));
        }

        /**
         * @see JComponent#setDebugGraphicsOptions(int)
         */
        default S setDebugGraphicsOptions(final int debugOptions) {
            return setup(result -> result.setDebugGraphicsOptions(debugOptions));
        }

        /**
         * @see JComponent#setDoubleBuffered(boolean)
         */
        default S setDoubleBuffered(final boolean aFlag) {
            return setup(result -> result.setDoubleBuffered(aFlag));
        }

        /**
         * @see JComponent#setEnabled(boolean)
         */
        default S setEnabled(final boolean enabled) {
            return setup(result -> result.setEnabled(enabled));
        }

        /**
         * @see JComponent#setFocusTraversalKeys(int, Set)
         */
        default S setFocusTraversalKeys(final int id, final Set<? extends java.awt.AWTKeyStroke> keystrokes) {
            return setup(result -> result.setFocusTraversalKeys(id, keystrokes));
        }

        /**
         * @see JComponent#setFont(Font)
         */
        default S setFont(final Font font) {
            return setup(result -> result.setFont(font));
        }

        /**
         * @see JComponent#setForeground(Color)
         */
        default S setForeground(final Color fg) {
            return setup(result -> result.setForeground(fg));
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
        default S setInputVerifier(final InputVerifier inputVerifier) {
            return setup(result -> result.setInputVerifier(inputVerifier));
        }

        /**
         * @see JComponent#setMaximumSize(Dimension)
         */
        default S setMaximumSize(final Dimension maximumSize) {
            return setup(result -> result.setMaximumSize(maximumSize));
        }

        /**
         * @see JComponent#setMinimumSize(Dimension)
         */
        default S setMinimumSize(final Dimension minimumSize) {
            return setup(result -> result.setMinimumSize(minimumSize));
        }

        /**
         * @see JComponent#setOpaque(boolean)
         */
        default S setOpaque(final boolean isOpaque) {
            return setup(result -> result.setOpaque(isOpaque));
        }

        /**
         * @see JComponent#setPreferredSize(Dimension)
         */
        default S setPreferredSize(final Dimension preferredSize) {
            return setup(result -> result.setPreferredSize(preferredSize));
        }

        /**
         * @see JComponent#setRequestFocusEnabled(boolean)
         */
        default S setRequestFocusEnabled(final boolean requestFocusEnabled) {
            return setup(result -> result.setRequestFocusEnabled(requestFocusEnabled));
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
        default S setTransferHandler(final TransferHandler newHandler) {
            return setup(result -> result.setTransferHandler(newHandler));
        }

        /**
         * @see JComponent#setVerifyInputWhenFocusTarget(boolean)
         */
        default S setVerifyInputWhenFocusTarget(final boolean verifyInputWhenFocusTarget) {
            return setup(result -> result.setVerifyInputWhenFocusTarget(verifyInputWhenFocusTarget));
        }

        /**
         * @see JComponent#setVisible(boolean)
         */
        default S setVisible(final boolean aFlag) {
            return setup(result -> result.setVisible(aFlag));
        }
    }
}
