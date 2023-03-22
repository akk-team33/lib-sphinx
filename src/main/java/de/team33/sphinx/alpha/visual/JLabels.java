package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Component;
import java.util.function.Supplier;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.plaf.LabelUI;

/**
 * Utility class to handle {@link JLabel}s.
 */
@SuppressWarnings("unused")
public final class JLabels {

    private JLabels() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JLabel}.
     */
    public static Builder<JLabel, ?> builder() {
        return new Builder<>(JLabel::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JLabel}.
     */
    public static <T extends JLabel> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JLabel}.
     * 
     * @param <T> The final type of the target instances, at least {@link JLabel}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JLabel, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JLabel}.
     * 
     * @param <T> The final type of the target instance, at least {@link JLabel}.
     * @param <S> The final type of the Setup implementation.
     */
    @FunctionalInterface
    public interface Setup<T extends JLabel, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JLabel#setDisabledIcon(Icon)
         */
        default S setDisabledIcon(final Icon disabledIcon) {
            return setup(result -> result.setDisabledIcon(disabledIcon));
        }

        /**
         * @see JLabel#setDisplayedMnemonic(char)
         */
        default S setDisplayedMnemonic(final char aChar) {
            return setup(result -> result.setDisplayedMnemonic(aChar));
        }

        /**
         * @see JLabel#setDisplayedMnemonic(int)
         */
        default S setDisplayedMnemonic(final int key) {
            return setup(result -> result.setDisplayedMnemonic(key));
        }

        /**
         * @see JLabel#setDisplayedMnemonicIndex(int)
         */
        default S setDisplayedMnemonicIndex(final int index) {
            return setup(result -> result.setDisplayedMnemonicIndex(index));
        }

        /**
         * @see JLabel#setHorizontalAlignment(int)
         */
        default S setHorizontalAlignment(final int alignment) {
            return setup(result -> result.setHorizontalAlignment(alignment));
        }

        /**
         * @see JLabel#setHorizontalTextPosition(int)
         */
        default S setHorizontalTextPosition(final int textPosition) {
            return setup(result -> result.setHorizontalTextPosition(textPosition));
        }

        /**
         * @see JLabel#setIcon(Icon)
         */
        default S setIcon(final Icon icon) {
            return setup(result -> result.setIcon(icon));
        }

        /**
         * @see JLabel#setIconTextGap(int)
         */
        default S setIconTextGap(final int iconTextGap) {
            return setup(result -> result.setIconTextGap(iconTextGap));
        }

        /**
         * @see JLabel#setLabelFor(Component)
         */
        default S setLabelFor(final Component c) {
            return setup(result -> result.setLabelFor(c));
        }

        /**
         * @see JLabel#setText(String)
         */
        default S setText(final String text) {
            return setup(result -> result.setText(text));
        }

        /**
         * @see JLabel#setUI(LabelUI)
         */
        default S setUI(final LabelUI ui) {
            return setup(result -> result.setUI(ui));
        }

        /**
         * @see JLabel#setVerticalAlignment(int)
         */
        default S setVerticalAlignment(final int alignment) {
            return setup(result -> result.setVerticalAlignment(alignment));
        }

        /**
         * @see JLabel#setVerticalTextPosition(int)
         */
        default S setVerticalTextPosition(final int textPosition) {
            return setup(result -> result.setVerticalTextPosition(textPosition));
        }
    }
}
