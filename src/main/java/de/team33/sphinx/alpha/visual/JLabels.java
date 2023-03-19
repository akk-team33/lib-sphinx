package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Component;
import java.util.function.Supplier;
import javax.swing.Icon;
import javax.swing.JComponent;
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
    public interface Setup<T extends JLabel, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JLabel#setDisabledIcon(Icon)
         */
        default S setDisabledIcon(final Icon arg0) {
            return setup(result -> result.setDisabledIcon(arg0));
        }

        /**
         * @see JLabel#setDisplayedMnemonic(char)
         */
        default S setDisplayedMnemonic(final char arg0) {
            return setup(result -> result.setDisplayedMnemonic(arg0));
        }

        /**
         * @see JLabel#setDisplayedMnemonic(int)
         */
        default S setDisplayedMnemonic(final int arg0) {
            return setup(result -> result.setDisplayedMnemonic(arg0));
        }

        /**
         * @see JLabel#setDisplayedMnemonicIndex(int)
         */
        default S setDisplayedMnemonicIndex(final int arg0) {
            return setup(result -> result.setDisplayedMnemonicIndex(arg0));
        }

        /**
         * @see JLabel#setHorizontalAlignment(int)
         */
        default S setHorizontalAlignment(final int arg0) {
            return setup(result -> result.setHorizontalAlignment(arg0));
        }

        /**
         * @see JLabel#setHorizontalTextPosition(int)
         */
        default S setHorizontalTextPosition(final int arg0) {
            return setup(result -> result.setHorizontalTextPosition(arg0));
        }

        /**
         * @see JLabel#setIcon(Icon)
         */
        default S setIcon(final Icon arg0) {
            return setup(result -> result.setIcon(arg0));
        }

        /**
         * @see JLabel#setIconTextGap(int)
         */
        default S setIconTextGap(final int arg0) {
            return setup(result -> result.setIconTextGap(arg0));
        }

        /**
         * @see JLabel#setLabelFor(Component)
         */
        default S setLabelFor(final Component arg0) {
            return setup(result -> result.setLabelFor(arg0));
        }

        /**
         * @see JLabel#setText(String)
         */
        default S setText(final String arg0) {
            return setup(result -> result.setText(arg0));
        }

        /**
         * @see JLabel#setUI(LabelUI)
         */
        default S setUI(final LabelUI arg0) {
            return setup(result -> result.setUI(arg0));
        }

        /**
         * @see JLabel#setVerticalAlignment(int)
         */
        default S setVerticalAlignment(final int arg0) {
            return setup(result -> result.setVerticalAlignment(arg0));
        }

        /**
         * @see JLabel#setVerticalTextPosition(int)
         */
        default S setVerticalTextPosition(final int arg0) {
            return setup(result -> result.setVerticalTextPosition(arg0));
        }
    }
}
