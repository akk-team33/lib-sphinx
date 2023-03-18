package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;

import javax.swing.Action;
import javax.swing.ComboBoxEditor;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComboBox.KeySelectionManager;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.ComboBoxUI;

/**
 * Utility class to handle {@link JComboBox}s.
 */
public final class JComboBoxs {

    /**
     * Returns a new {@link Builder} for target instances of type {@link JComboBox}.
     */
    public static Builder<JComboBox, ?> builder() {
        return new Builder<>(JComboBox::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JComboBox}.
     */
    public static <T extends JComboBox> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JComboBox}.
     * 
     * @param <T> The final type of the target instances, at least {@link JComboBox}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JComboBox, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JComboBox}.
     * 
     * @param <T> The final type of the target instance, at least {@link JComboBox}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JComboBox, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JComboBox#setAction(Action)
         */
        default S setAction(final Action arg0) {
            return setup(result -> result.setAction(arg0));
        }

        /**
         * @see JComboBox#setModel(ComboBoxModel)
         */
        default S setModel(final ComboBoxModel arg0) {
            return setup(result -> result.setModel(arg0));
        }

        /**
         * @see JComboBox#setUI(ComboBoxUI)
         */
        default S setUI(final ComboBoxUI arg0) {
            return setup(result -> result.setUI(arg0));
        }

        /**
         * @see JComboBox#setActionCommand(String)
         */
        default S setActionCommand(final String arg0) {
            return setup(result -> result.setActionCommand(arg0));
        }

        /**
         * @see JComboBox#setLightWeightPopupEnabled(boolean)
         */
        default S setLightWeightPopupEnabled(final boolean arg0) {
            return setup(result -> result.setLightWeightPopupEnabled(arg0));
        }

        /**
         * @see JComboBox#setEditable(boolean)
         */
        default S setEditable(final boolean arg0) {
            return setup(result -> result.setEditable(arg0));
        }

        /**
         * @see JComboBox#setMaximumRowCount(int)
         */
        default S setMaximumRowCount(final int arg0) {
            return setup(result -> result.setMaximumRowCount(arg0));
        }

        /**
         * @see JComboBox#setRenderer(ListCellRenderer)
         */
        default S setRenderer(final ListCellRenderer arg0) {
            return setup(result -> result.setRenderer(arg0));
        }

        /**
         * @see JComboBox#setEditor(ComboBoxEditor)
         */
        default S setEditor(final ComboBoxEditor arg0) {
            return setup(result -> result.setEditor(arg0));
        }

        /**
         * @see JComboBox#setSelectedItem(Object)
         */
        default S setSelectedItem(final Object arg0) {
            return setup(result -> result.setSelectedItem(arg0));
        }

        /**
         * @see JComboBox#setSelectedIndex(int)
         */
        default S setSelectedIndex(final int arg0) {
            return setup(result -> result.setSelectedIndex(arg0));
        }

        /**
         * @see JComboBox#setPrototypeDisplayValue(Object)
         */
        default S setPrototypeDisplayValue(final Object arg0) {
            return setup(result -> result.setPrototypeDisplayValue(arg0));
        }

        /**
         * @see JComboBox#addItem(Object)
         */
        default S addItem(final Object arg0) {
            return setup(result -> result.addItem(arg0));
        }

        /**
         * @see JComboBox#removeItem(Object)
         */
        default S removeItem(final Object arg0) {
            return setup(result -> result.removeItem(arg0));
        }

        /**
         * @see JComboBox#removeItemAt(int)
         */
        default S removeItemAt(final int arg0) {
            return setup(result -> result.removeItemAt(arg0));
        }

        /**
         * @see JComboBox#removeAllItems()
         */
        default S removeAllItems() {
            return setup(result -> result.removeAllItems());
        }

        /**
         * @see JComboBox#setPopupVisible(boolean)
         */
        default S setPopupVisible(final boolean arg0) {
            return setup(result -> result.setPopupVisible(arg0));
        }

        /**
         * @see JComboBox#setKeySelectionManager(KeySelectionManager)
         */
        default S setKeySelectionManager(final KeySelectionManager arg0) {
            return setup(result -> result.setKeySelectionManager(arg0));
        }

        /**
         * @see JComboBox#setEnabled(boolean)
         */
        default S setEnabled(final boolean arg0) {
            return setup(result -> result.setEnabled(arg0));
        }
    }
}
