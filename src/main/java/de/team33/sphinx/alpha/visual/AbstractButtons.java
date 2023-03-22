package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.function.Supplier;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.plaf.ButtonUI;

/**
 * Utility class to handle {@link AbstractButton}s.
 */
@SuppressWarnings("unused")
public final class AbstractButtons {

    private AbstractButtons() {
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link AbstractButton}.
     */
    public static <T extends AbstractButton> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link AbstractButton}.
     * 
     * @param <T> The final type of the target instances, at least {@link AbstractButton}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends AbstractButton, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link AbstractButton}.
     * 
     * @param <T> The final type of the target instance, at least {@link AbstractButton}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends AbstractButton, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see AbstractButton#setAction(Action)
         */
        default S setAction(final Action a) {
            return setup(result -> result.setAction(a));
        }

        /**
         * @see AbstractButton#setActionCommand(String)
         */
        default S setActionCommand(final String actionCommand) {
            return setup(result -> result.setActionCommand(actionCommand));
        }

        /**
         * @see AbstractButton#setBorderPainted(boolean)
         */
        default S setBorderPainted(final boolean b) {
            return setup(result -> result.setBorderPainted(b));
        }

        /**
         * @see AbstractButton#setContentAreaFilled(boolean)
         */
        default S setContentAreaFilled(final boolean b) {
            return setup(result -> result.setContentAreaFilled(b));
        }

        /**
         * @see AbstractButton#setDisabledIcon(Icon)
         */
        default S setDisabledIcon(final Icon disabledIcon) {
            return setup(result -> result.setDisabledIcon(disabledIcon));
        }

        /**
         * @see AbstractButton#setDisabledSelectedIcon(Icon)
         */
        default S setDisabledSelectedIcon(final Icon disabledSelectedIcon) {
            return setup(result -> result.setDisabledSelectedIcon(disabledSelectedIcon));
        }

        /**
         * @see AbstractButton#setDisplayedMnemonicIndex(int)
         */
        default S setDisplayedMnemonicIndex(final int index) {
            return setup(result -> result.setDisplayedMnemonicIndex(index));
        }

        /**
         * @see AbstractButton#setEnabled(boolean)
         */
        default S setEnabled(final boolean b) {
            return setup(result -> result.setEnabled(b));
        }

        /**
         * @see AbstractButton#setFocusPainted(boolean)
         */
        default S setFocusPainted(final boolean b) {
            return setup(result -> result.setFocusPainted(b));
        }

        /**
         * @see AbstractButton#setHideActionText(boolean)
         */
        default S setHideActionText(final boolean hideActionText) {
            return setup(result -> result.setHideActionText(hideActionText));
        }

        /**
         * @see AbstractButton#setHorizontalAlignment(int)
         */
        default S setHorizontalAlignment(final int alignment) {
            return setup(result -> result.setHorizontalAlignment(alignment));
        }

        /**
         * @see AbstractButton#setHorizontalTextPosition(int)
         */
        default S setHorizontalTextPosition(final int textPosition) {
            return setup(result -> result.setHorizontalTextPosition(textPosition));
        }

        /**
         * @see AbstractButton#setIcon(Icon)
         */
        default S setIcon(final Icon defaultIcon) {
            return setup(result -> result.setIcon(defaultIcon));
        }

        /**
         * @see AbstractButton#setIconTextGap(int)
         */
        default S setIconTextGap(final int iconTextGap) {
            return setup(result -> result.setIconTextGap(iconTextGap));
        }

        /**
         * @see AbstractButton#setLayout(LayoutManager)
         */
        default S setLayout(final LayoutManager mgr) {
            return setup(result -> result.setLayout(mgr));
        }

        /**
         * @see AbstractButton#setMargin(Insets)
         */
        default S setMargin(final Insets m) {
            return setup(result -> result.setMargin(m));
        }

        /**
         * @see AbstractButton#setMnemonic(char)
         */
        default S setMnemonic(final char mnemonic) {
            return setup(result -> result.setMnemonic(mnemonic));
        }

        /**
         * @see AbstractButton#setMnemonic(int)
         */
        default S setMnemonic(final int mnemonic) {
            return setup(result -> result.setMnemonic(mnemonic));
        }

        /**
         * @see AbstractButton#setModel(ButtonModel)
         */
        default S setModel(final ButtonModel newModel) {
            return setup(result -> result.setModel(newModel));
        }

        /**
         * @see AbstractButton#setMultiClickThreshhold(long)
         */
        default S setMultiClickThreshold(final long arg0) {
            return setup(result -> result.setMultiClickThreshhold(arg0));
        }

        /**
         * @see AbstractButton#setPressedIcon(Icon)
         */
        default S setPressedIcon(final Icon pressedIcon) {
            return setup(result -> result.setPressedIcon(pressedIcon));
        }

        /**
         * @see AbstractButton#setRolloverEnabled(boolean)
         */
        default S setRolloverEnabled(final boolean b) {
            return setup(result -> result.setRolloverEnabled(b));
        }

        /**
         * @see AbstractButton#setRolloverIcon(Icon)
         */
        default S setRolloverIcon(final Icon rolloverIcon) {
            return setup(result -> result.setRolloverIcon(rolloverIcon));
        }

        /**
         * @see AbstractButton#setRolloverSelectedIcon(Icon)
         */
        default S setRolloverSelectedIcon(final Icon rolloverSelectedIcon) {
            return setup(result -> result.setRolloverSelectedIcon(rolloverSelectedIcon));
        }

        /**
         * @see AbstractButton#setSelected(boolean)
         */
        default S setSelected(final boolean b) {
            return setup(result -> result.setSelected(b));
        }

        /**
         * @see AbstractButton#setSelectedIcon(Icon)
         */
        default S setSelectedIcon(final Icon selectedIcon) {
            return setup(result -> result.setSelectedIcon(selectedIcon));
        }

        /**
         * @see AbstractButton#setText(String)
         */
        default S setText(final String text) {
            return setup(result -> result.setText(text));
        }

        /**
         * @see AbstractButton#setUI(ButtonUI)
         */
        default S setUI(final ButtonUI ui) {
            return setup(result -> result.setUI(ui));
        }

        /**
         * @see AbstractButton#setVerticalAlignment(int)
         */
        default S setVerticalAlignment(final int alignment) {
            return setup(result -> result.setVerticalAlignment(alignment));
        }

        /**
         * @see AbstractButton#setVerticalTextPosition(int)
         */
        default S setVerticalTextPosition(final int textPosition) {
            return setup(result -> result.setVerticalTextPosition(textPosition));
        }
    }
}
