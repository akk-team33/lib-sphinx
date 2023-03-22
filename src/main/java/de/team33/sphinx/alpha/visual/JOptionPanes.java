package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;

/**
 * Utility class to handle {@link JOptionPane}s.
 */
@SuppressWarnings("unused")
public final class JOptionPanes {

    private JOptionPanes() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JOptionPane}.
     */
    public static Builder<JOptionPane, ?> builder() {
        return new Builder<>(JOptionPane::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JOptionPane}.
     */
    public static <T extends JOptionPane> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JOptionPane}.
     * 
     * @param <T> The final type of the target instances, at least {@link JOptionPane}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JOptionPane, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JOptionPane}.
     * 
     * @param <T> The final type of the target instance, at least {@link JOptionPane}.
     * @param <S> The final type of the Setup implementation.
     */
    @FunctionalInterface
    public interface Setup<T extends JOptionPane, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JOptionPane#setIcon(Icon)
         */
        default S setIcon(final Icon newIcon) {
            return setup(result -> result.setIcon(newIcon));
        }

        /**
         * @see JOptionPane#setInitialSelectionValue(Object)
         */
        default S setInitialSelectionValue(final Object newValue) {
            return setup(result -> result.setInitialSelectionValue(newValue));
        }

        /**
         * @see JOptionPane#setInitialValue(Object)
         */
        default S setInitialValue(final Object newInitialValue) {
            return setup(result -> result.setInitialValue(newInitialValue));
        }

        /**
         * @see JOptionPane#setInputValue(Object)
         */
        default S setInputValue(final Object newValue) {
            return setup(result -> result.setInputValue(newValue));
        }

        /**
         * @see JOptionPane#setMessage(Object)
         */
        default S setMessage(final Object newMessage) {
            return setup(result -> result.setMessage(newMessage));
        }

        /**
         * @see JOptionPane#setMessageType(int)
         */
        default S setMessageType(final int newType) {
            return setup(result -> result.setMessageType(newType));
        }

        /**
         * @see JOptionPane#setOptionType(int)
         */
        default S setOptionType(final int newType) {
            return setup(result -> result.setOptionType(newType));
        }

        /**
         * @see JOptionPane#setOptions(Object[])
         */
        default S setOptions(final java.lang.Object[] newOptions) {
            return setup(result -> result.setOptions(newOptions));
        }

        /**
         * @see JOptionPane#setSelectionValues(Object[])
         */
        default S setSelectionValues(final java.lang.Object[] newValues) {
            return setup(result -> result.setSelectionValues(newValues));
        }

        /**
         * @see JOptionPane#setUI(OptionPaneUI)
         */
        default S setUI(final OptionPaneUI ui) {
            return setup(result -> result.setUI(ui));
        }

        /**
         * @see JOptionPane#setValue(Object)
         */
        default S setValue(final Object newValue) {
            return setup(result -> result.setValue(newValue));
        }

        /**
         * @see JOptionPane#setWantsInput(boolean)
         */
        default S setWantsInput(final boolean newValue) {
            return setup(result -> result.setWantsInput(newValue));
        }
    }
}
