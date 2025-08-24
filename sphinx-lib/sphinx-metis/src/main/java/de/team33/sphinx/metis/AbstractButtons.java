package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import java.awt.*;
import java.util.function.Supplier;

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
     * @param <B> The final type of the target instances, at least {@link AbstractButton}.
     */
    public static <B extends AbstractButton> Builder<B> builder(final Supplier<B> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     *
     * @param <B> The final type of the target instance, at least {@link AbstractButton}.
     */
    public static <B extends AbstractButton> Charger<B> charger(final B target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Returns a new {@link Setup} for a given {@link AbstractButton} instance.
     */
    public static Setup<AbstractButton, ?> setup(final AbstractButton target) {
        return charger(target);
    }

    /**
     * Utility interface to set up a target instance of {@link AbstractButton}.
     *
     * @param <B> The final type of the target instance, at least {@link AbstractButton}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<B extends AbstractButton, S extends Setup<B, S>> extends JComponents.Setup<B, S> {

        /**
         * @see AbstractButton#setAction(Action)
         */
        default S setAction(final Action action) {
            return setup(result -> result.setAction(action));
        }

        /**
         * @see AbstractButton#setActionCommand(String)
         */
        default S setActionCommand(final String command) {
            return setup(result -> result.setActionCommand(command));
        }

        /**
         * @see AbstractButton#setBorderPainted(boolean)
         */
        default S setBorderPainted(final boolean painted) {
            return setup(result -> result.setBorderPainted(painted));
        }

        /**
         * @see AbstractButton#setContentAreaFilled(boolean)
         */
        default S setContentAreaFilled(final boolean filled) {
            return setup(result -> result.setContentAreaFilled(filled));
        }

        /**
         * @see AbstractButton#setDisabledIcon(Icon)
         */
        default S setDisabledIcon(final Icon icon) {
            return setup(result -> result.setDisabledIcon(icon));
        }

        /**
         * @see AbstractButton#setDisabledSelectedIcon(Icon)
         */
        default S setDisabledSelectedIcon(final Icon icon) {
            return setup(result -> result.setDisabledSelectedIcon(icon));
        }

        /**
         * @see AbstractButton#setDisplayedMnemonicIndex(int)
         */
        default S setDisplayedMnemonicIndex(final int index) {
            return setup(result -> result.setDisplayedMnemonicIndex(index));
        }

        /**
         * @see AbstractButton#setFocusPainted(boolean)
         */
        default S setFocusPainted(final boolean painted) {
            return setup(result -> result.setFocusPainted(painted));
        }

        /**
         * @see AbstractButton#setHideActionText(boolean)
         */
        default S setHideActionText(final boolean hide) {
            return setup(result -> result.setHideActionText(hide));
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
        default S setHorizontalTextPosition(final int position) {
            return setup(result -> result.setHorizontalTextPosition(position));
        }

        /**
         * @see AbstractButton#setIcon(Icon)
         */
        default S setIcon(final Icon icon) {
            return setup(result -> result.setIcon(icon));
        }

        /**
         * @see AbstractButton#setIconTextGap(int)
         */
        default S setIconTextGap(final int gap) {
            return setup(result -> result.setIconTextGap(gap));
        }

        /**
         * @see AbstractButton#setMargin(Insets)
         */
        default S setMargin(final Insets insets) {
            return setup(result -> result.setMargin(insets));
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
        default S setModel(final ButtonModel model) {
            return setup(result -> result.setModel(model));
        }

        /**
         * @see AbstractButton#setMultiClickThreshhold(long)
         */
        default S setMultiClickThreshold(final long threshold) {
            return setup(result -> result.setMultiClickThreshhold(threshold));
        }

        /**
         * @see AbstractButton#setPressedIcon(Icon)
         */
        default S setPressedIcon(final Icon icon) {
            return setup(result -> result.setPressedIcon(icon));
        }

        /**
         * @see AbstractButton#setRolloverEnabled(boolean)
         */
        default S setRolloverEnabled(final boolean enabled) {
            return setup(result -> result.setRolloverEnabled(enabled));
        }

        /**
         * @see AbstractButton#setRolloverIcon(Icon)
         */
        default S setRolloverIcon(final Icon icon) {
            return setup(result -> result.setRolloverIcon(icon));
        }

        /**
         * @see AbstractButton#setRolloverSelectedIcon(Icon)
         */
        default S setRolloverSelectedIcon(final Icon icon) {
            return setup(result -> result.setRolloverSelectedIcon(icon));
        }

        /**
         * @see AbstractButton#setSelected(boolean)
         */
        default S setSelected(final boolean selected) {
            return setup(result -> result.setSelected(selected));
        }

        /**
         * @see AbstractButton#setSelectedIcon(Icon)
         */
        default S setSelectedIcon(final Icon icon) {
            return setup(result -> result.setSelectedIcon(icon));
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
        default S setVerticalTextPosition(final int position) {
            return setup(result -> result.setVerticalTextPosition(position));
        }
    }

    /**
     * Builder implementation to build target instances of {@link AbstractButton}.
     *
     * @param <B> The final type of the target instances, at least {@link AbstractButton}.
     */
    public static final class Builder<B extends AbstractButton>
            extends LateBuilder<B, Builder<B>> implements Setup<B, Builder<B>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<B> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link AbstractButton}.
     *
     * @param <B> The final type of the target instance, at least {@link AbstractButton}.
     */
    public static final class Charger<B extends AbstractButton>
            extends de.team33.patterns.building.elara.Charger<B, Charger<B>>
            implements Setup<B, Charger<B>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final B target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }
}
