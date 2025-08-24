package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import javax.swing.plaf.LabelUI;
import java.awt.*;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JLabel}s.
 */
@SuppressWarnings("unused")
public final class JLabels {

    private JLabels() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JLabel}.
     *
     * @see #builder(Supplier)
     * @see JLabel#JLabel()
     */
    public static Builder<JLabel> builder() {
        return new Builder<>(JLabel::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JLabel}.
     *
     * @see #builder(Supplier)
     * @see JLabel#JLabel(String)
     */
    public static Builder<JLabel> builder(final String text) {
        return new Builder<>(() -> new JLabel(text), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JLabel}.
     *
     * @see #builder(Supplier)
     * @see JLabel#JLabel(String, int)
     */
    public static Builder<JLabel> builder(final String text, final int alignment) {
        return new Builder<>(() -> new JLabel(text, alignment), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JLabel}.
     *
     * @see #builder(Supplier)
     * @see JLabel#JLabel(Icon)
     */
    public static Builder<JLabel> builder(final Icon icon) {
        return new Builder<>(() -> new JLabel(icon), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JLabel}.
     *
     * @see #builder(Supplier)
     * @see JLabel#JLabel(Icon, int)
     */
    public static Builder<JLabel> builder(final Icon icon, final int alignment) {
        return new Builder<>(() -> new JLabel(icon, alignment), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JLabel}.
     *
     * @see #builder(Supplier)
     * @see JLabel#JLabel(String, Icon, int)
     */
    public static Builder<JLabel> builder(final String text, final Icon icon, final int alignment) {
        return new Builder<>(() -> new JLabel(text, icon, alignment), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     *
     * @param <L> The final type of the target instances, at least {@link JLabel}.
     */
    public static <L extends JLabel> Builder<L> builder(final Supplier<L> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     *
     * @param <L> The final type of the target instance, at least {@link JLabel}.
     */
    public static <L extends JLabel> Charger<L> charger(final L target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Returns a new {@link Setup} for a given {@link JLabel} instance.
     */
    public static Setup<JLabel, ?> setup(final JLabel target) {
        return charger(target);
    }

    /**
     * Utility interface to set up a target instance of {@link JLabel}.
     *
     * @param <L> The final type of the target instance, at least {@link JLabel}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<L extends JLabel, S extends Setup<L, S>> extends JComponents.Setup<L, S> {

        /**
         * @see JLabel#setDisabledIcon(Icon)
         */
        default S setDisabledIcon(final Icon icon) {
            return setup(result -> result.setDisabledIcon(icon));
        }

        /**
         * @see JLabel#setDisplayedMnemonic(char)
         */
        default S setDisplayedMnemonic(final char mnemonic) {
            return setup(result -> result.setDisplayedMnemonic(mnemonic));
        }

        /**
         * @see JLabel#setDisplayedMnemonic(int)
         */
        default S setDisplayedMnemonic(final int mnemonic) {
            return setup(result -> result.setDisplayedMnemonic(mnemonic));
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
        default S setHorizontalTextPosition(final int position) {
            return setup(result -> result.setHorizontalTextPosition(position));
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
        default S setIconTextGap(final int gap) {
            return setup(result -> result.setIconTextGap(gap));
        }

        /**
         * @see JLabel#setLabelFor(Component)
         */
        default S setLabelFor(final Component component) {
            return setup(result -> result.setLabelFor(component));
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
        default S setVerticalTextPosition(final int position) {
            return setup(result -> result.setVerticalTextPosition(position));
        }
    }

    /**
     * Builder implementation to build target instances of {@link JLabel}.
     *
     * @param <L> The final type of the target instances, at least {@link JLabel}.
     */
    public static final class Builder<L extends JLabel>
            extends LateBuilder<L, Builder<L>> implements Setup<L, Builder<L>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<L> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JLabel}.
     *
     * @param <L> The final type of the target instance, at least {@link JLabel}.
     */
    public static final class Charger<L extends JLabel>
            extends de.team33.patterns.building.elara.Charger<L, Charger<L>>
            implements Setup<L, Charger<L>> {

        @SuppressWarnings("unchecked")
        private Charger(final L target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }
}
