package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Insets;
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
    public static <T extends AbstractButton> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link AbstractButton}.
     */
    public static <T extends AbstractButton> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link AbstractButton}.
     * 
     * @param <T> The final type of the target instances, at least {@link AbstractButton}.
     */
    public static final class Builder<T extends AbstractButton>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link AbstractButton}.
     * 
     * @param <T> The final type of the target instance, at least {@link AbstractButton}.
     */
    public static final class Charger<T extends AbstractButton>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
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
        default S setAction(final Action arg0) {
            return setup(result -> result.setAction(arg0));
        }

        /**
         * @see AbstractButton#setActionCommand(String)
         */
        default S setActionCommand(final String arg0) {
            return setup(result -> result.setActionCommand(arg0));
        }

        /**
         * @see AbstractButton#setBorderPainted(boolean)
         */
        default S setBorderPainted(final boolean arg0) {
            return setup(result -> result.setBorderPainted(arg0));
        }

        /**
         * @see AbstractButton#setContentAreaFilled(boolean)
         */
        default S setContentAreaFilled(final boolean arg0) {
            return setup(result -> result.setContentAreaFilled(arg0));
        }

        /**
         * @see AbstractButton#setDisabledIcon(Icon)
         */
        default S setDisabledIcon(final Icon arg0) {
            return setup(result -> result.setDisabledIcon(arg0));
        }

        /**
         * @see AbstractButton#setDisabledSelectedIcon(Icon)
         */
        default S setDisabledSelectedIcon(final Icon arg0) {
            return setup(result -> result.setDisabledSelectedIcon(arg0));
        }

        /**
         * @see AbstractButton#setDisplayedMnemonicIndex(int)
         */
        default S setDisplayedMnemonicIndex(final int arg0) {
            return setup(result -> result.setDisplayedMnemonicIndex(arg0));
        }

        /**
         * @see AbstractButton#setFocusPainted(boolean)
         */
        default S setFocusPainted(final boolean arg0) {
            return setup(result -> result.setFocusPainted(arg0));
        }

        /**
         * @see AbstractButton#setHideActionText(boolean)
         */
        default S setHideActionText(final boolean arg0) {
            return setup(result -> result.setHideActionText(arg0));
        }

        /**
         * @see AbstractButton#setHorizontalAlignment(int)
         */
        default S setHorizontalAlignment(final int arg0) {
            return setup(result -> result.setHorizontalAlignment(arg0));
        }

        /**
         * @see AbstractButton#setHorizontalTextPosition(int)
         */
        default S setHorizontalTextPosition(final int arg0) {
            return setup(result -> result.setHorizontalTextPosition(arg0));
        }

        /**
         * @see AbstractButton#setIcon(Icon)
         */
        default S setIcon(final Icon arg0) {
            return setup(result -> result.setIcon(arg0));
        }

        /**
         * @see AbstractButton#setIconTextGap(int)
         */
        default S setIconTextGap(final int arg0) {
            return setup(result -> result.setIconTextGap(arg0));
        }

        /**
         * @see AbstractButton#setMargin(Insets)
         */
        default S setMargin(final Insets arg0) {
            return setup(result -> result.setMargin(arg0));
        }

        /**
         * @see AbstractButton#setMnemonic(char)
         */
        default S setMnemonic(final char arg0) {
            return setup(result -> result.setMnemonic(arg0));
        }

        /**
         * @see AbstractButton#setMnemonic(int)
         */
        default S setMnemonic(final int arg0) {
            return setup(result -> result.setMnemonic(arg0));
        }

        /**
         * @see AbstractButton#setModel(ButtonModel)
         */
        default S setModel(final ButtonModel arg0) {
            return setup(result -> result.setModel(arg0));
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
        default S setPressedIcon(final Icon arg0) {
            return setup(result -> result.setPressedIcon(arg0));
        }

        /**
         * @see AbstractButton#setRolloverEnabled(boolean)
         */
        default S setRolloverEnabled(final boolean arg0) {
            return setup(result -> result.setRolloverEnabled(arg0));
        }

        /**
         * @see AbstractButton#setRolloverIcon(Icon)
         */
        default S setRolloverIcon(final Icon arg0) {
            return setup(result -> result.setRolloverIcon(arg0));
        }

        /**
         * @see AbstractButton#setRolloverSelectedIcon(Icon)
         */
        default S setRolloverSelectedIcon(final Icon arg0) {
            return setup(result -> result.setRolloverSelectedIcon(arg0));
        }

        /**
         * @see AbstractButton#setSelected(boolean)
         */
        default S setSelected(final boolean arg0) {
            return setup(result -> result.setSelected(arg0));
        }

        /**
         * @see AbstractButton#setSelectedIcon(Icon)
         */
        default S setSelectedIcon(final Icon arg0) {
            return setup(result -> result.setSelectedIcon(arg0));
        }

        /**
         * @see AbstractButton#setText(String)
         */
        default S setText(final String arg0) {
            return setup(result -> result.setText(arg0));
        }

        /**
         * @see AbstractButton#setUI(ButtonUI)
         */
        default S setUI(final ButtonUI arg0) {
            return setup(result -> result.setUI(arg0));
        }

        /**
         * @see AbstractButton#setVerticalAlignment(int)
         */
        default S setVerticalAlignment(final int arg0) {
            return setup(result -> result.setVerticalAlignment(arg0));
        }

        /**
         * @see AbstractButton#setVerticalTextPosition(int)
         */
        default S setVerticalTextPosition(final int arg0) {
            return setup(result -> result.setVerticalTextPosition(arg0));
        }
    }
}
