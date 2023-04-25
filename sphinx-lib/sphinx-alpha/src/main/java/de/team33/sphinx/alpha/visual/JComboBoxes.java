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
@SuppressWarnings("unused")
public final class JComboBoxes {

    private JComboBoxes() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JComboBox}.
     *
     * @param <E> The element type.
     */
    public static <E> Builder<E, JComboBox<E>> builder(final ComboBoxModel<E> model) {
        return new Builder<>(() -> new JComboBox<>(model), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     *
     * @param <E> The element type.
     * @param <T> The final type of the target instances, at least {@link JComboBox}.
     */
    public static <E, T extends JComboBox<E>> Builder<E, T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JComboBox}.
     *
     * @param <E> The element type.
     * @param <T> The final type of the target instances, at least {@link JComboBox}.
     */
    public static final class Builder<E, T extends JComboBox<E>>
            extends LateBuilder<T, Builder<E, T>> implements Setup<E, T, Builder<E, T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JComboBox}.
     *
     * @param <E> The element type.
     * @param <T> The final type of the target instance, at least {@link JComboBox}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<E, T extends JComboBox<E>, S extends Setup<E, T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JComboBox#addItem(Object)
         */
        default S addItem(final E arg0) {
            return setup(result -> result.addItem(arg0));
        }

        /**
         * @see JComboBox#removeAllItems()
         */
        default S removeAllItems() {
            return setup(JComboBox::removeAllItems);
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
         * @see JComboBox#setAction(Action)
         */
        default S setAction(final Action arg0) {
            return setup(result -> result.setAction(arg0));
        }

        /**
         * @see JComboBox#setActionCommand(String)
         */
        default S setActionCommand(final String arg0) {
            return setup(result -> result.setActionCommand(arg0));
        }

        /**
         * @see JComboBox#setEditable(boolean)
         */
        default S setEditable(final boolean arg0) {
            return setup(result -> result.setEditable(arg0));
        }

        /**
         * @see JComboBox#setEditor(ComboBoxEditor)
         */
        default S setEditor(final ComboBoxEditor arg0) {
            return setup(result -> result.setEditor(arg0));
        }

        /**
         * @see JComboBox#setEnabled(boolean)
         */
        default S setEnabled(final boolean arg0) {
            return setup(result -> result.setEnabled(arg0));
        }

        /**
         * @see JComboBox#setKeySelectionManager(KeySelectionManager)
         */
        default S setKeySelectionManager(final KeySelectionManager arg0) {
            return setup(result -> result.setKeySelectionManager(arg0));
        }

        /**
         * @see JComboBox#setLightWeightPopupEnabled(boolean)
         */
        default S setLightWeightPopupEnabled(final boolean arg0) {
            return setup(result -> result.setLightWeightPopupEnabled(arg0));
        }

        /**
         * @see JComboBox#setMaximumRowCount(int)
         */
        default S setMaximumRowCount(final int arg0) {
            return setup(result -> result.setMaximumRowCount(arg0));
        }

        /**
         * @see JComboBox#setModel(ComboBoxModel)
         */
        default S setModel(final ComboBoxModel<E> arg0) {
            return setup(result -> result.setModel(arg0));
        }

        /**
         * @see JComboBox#setPopupVisible(boolean)
         */
        default S setPopupVisible(final boolean arg0) {
            return setup(result -> result.setPopupVisible(arg0));
        }

        /**
         * @see JComboBox#setPrototypeDisplayValue(Object)
         */
        default S setPrototypeDisplayValue(final E arg0) {
            return setup(result -> result.setPrototypeDisplayValue(arg0));
        }

        /**
         * @see JComboBox#setRenderer(ListCellRenderer)
         */
        default S setRenderer(final ListCellRenderer<? super E> arg0) {
            return setup(result -> result.setRenderer(arg0));
        }

        /**
         * @see JComboBox#setSelectedIndex(int)
         */
        default S setSelectedIndex(final int arg0) {
            return setup(result -> result.setSelectedIndex(arg0));
        }

        /**
         * @see JComboBox#setSelectedItem(Object)
         */
        default S setSelectedItem(final Object arg0) {
            return setup(result -> result.setSelectedItem(arg0));
        }

        /**
         * @see JComboBox#setUI(ComboBoxUI)
         */
        default S setUI(final ComboBoxUI arg0) {
            return setup(result -> result.setUI(arg0));
        }
    }
}
