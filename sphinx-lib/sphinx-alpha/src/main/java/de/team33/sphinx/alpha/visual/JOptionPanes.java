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
    public static Builder<JOptionPane> builder() {
        return new Builder<>(JOptionPane::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JOptionPane}.
     */
    public static <T extends JOptionPane> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JOptionPane}.
     */
    public static <T extends JOptionPane> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link JOptionPane}.
     * 
     * @param <T> The final type of the target instances, at least {@link JOptionPane}.
     */
    public static final class Builder<T extends JOptionPane>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JOptionPane}.
     * 
     * @param <T> The final type of the target instance, at least {@link JOptionPane}.
     */
    public static final class Charger<T extends JOptionPane>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JOptionPane}.
     * 
     * @param <T> The final type of the target instance, at least {@link JOptionPane}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JOptionPane, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JOptionPane#setIcon(Icon)
         */
        default S setIcon(final Icon arg0) {
            return setup(result -> result.setIcon(arg0));
        }

        /**
         * @see JOptionPane#setInitialSelectionValue(Object)
         */
        default S setInitialSelectionValue(final Object arg0) {
            return setup(result -> result.setInitialSelectionValue(arg0));
        }

        /**
         * @see JOptionPane#setInitialValue(Object)
         */
        default S setInitialValue(final Object arg0) {
            return setup(result -> result.setInitialValue(arg0));
        }

        /**
         * @see JOptionPane#setInputValue(Object)
         */
        default S setInputValue(final Object arg0) {
            return setup(result -> result.setInputValue(arg0));
        }

        /**
         * @see JOptionPane#setMessage(Object)
         */
        default S setMessage(final Object arg0) {
            return setup(result -> result.setMessage(arg0));
        }

        /**
         * @see JOptionPane#setMessageType(int)
         */
        default S setMessageType(final int arg0) {
            return setup(result -> result.setMessageType(arg0));
        }

        /**
         * @see JOptionPane#setOptionType(int)
         */
        default S setOptionType(final int arg0) {
            return setup(result -> result.setOptionType(arg0));
        }

        /**
         * @see JOptionPane#setOptions(Object[])
         */
        default S setOptions(final java.lang.Object[] arg0) {
            return setup(result -> result.setOptions(arg0));
        }

        /**
         * @see JOptionPane#setSelectionValues(Object[])
         */
        default S setSelectionValues(final java.lang.Object[] arg0) {
            return setup(result -> result.setSelectionValues(arg0));
        }

        /**
         * @see JOptionPane#setUI(OptionPaneUI)
         */
        default S setUI(final OptionPaneUI arg0) {
            return setup(result -> result.setUI(arg0));
        }

        /**
         * @see JOptionPane#setValue(Object)
         */
        default S setValue(final Object arg0) {
            return setup(result -> result.setValue(arg0));
        }

        /**
         * @see JOptionPane#setWantsInput(boolean)
         */
        default S setWantsInput(final boolean arg0) {
            return setup(result -> result.setWantsInput(arg0));
        }
    }
}
