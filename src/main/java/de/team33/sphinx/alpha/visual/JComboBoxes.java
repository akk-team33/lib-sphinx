package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import javax.swing.plaf.ComboBoxUI;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JComboBox}es.
 */
@SuppressWarnings("unused")
public final class JComboBoxes {

    private JComboBoxes() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JComboBox}.
     */
    public static <E> Builder<E, JComboBox<E>, ?> builder(final ComboBoxModel<E> aModel) {
        return builder(() -> new JComboBox<E>()).setModel(aModel);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JComboBox}.
     */
    public static <E, T extends JComboBox<E>> Builder<E, T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JComboBox}.
     * 
     * @param <T> The final type of the target instances, at least {@link JComboBox}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<E, T extends JComboBox<E>, B extends Builder<E, T, B>>
            extends LateBuilder<T, B> implements Setup<E, T, B> {

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
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<E, T extends JComboBox<E>, S extends Setup<E, T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JComboBox#addItem(Object)
         */
        default S addItem(final E item) {
            return setup(result -> result.addItem(item));
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
        default S removeItem(final Object anObject) {
            return setup(result -> result.removeItem(anObject));
        }

        /**
         * @see JComboBox#removeItemAt(int)
         */
        default S removeItemAt(final int anIndex) {
            return setup(result -> result.removeItemAt(anIndex));
        }

        /**
         * @see JComboBox#setAction(Action)
         */
        default S setAction(final Action a) {
            return setup(result -> result.setAction(a));
        }

        /**
         * @see JComboBox#setActionCommand(String)
         */
        default S setActionCommand(final String aCommand) {
            return setup(result -> result.setActionCommand(aCommand));
        }

        /**
         * @see JComboBox#setEditable(boolean)
         */
        default S setEditable(final boolean aFlag) {
            return setup(result -> result.setEditable(aFlag));
        }

        /**
         * @see JComboBox#setEditor(ComboBoxEditor)
         */
        default S setEditor(final ComboBoxEditor anEditor) {
            return setup(result -> result.setEditor(anEditor));
        }

        /**
         * @see JComboBox#setKeySelectionManager(JComboBox.KeySelectionManager)
         */
        default S setKeySelectionManager(final JComboBox.KeySelectionManager aManager) {
            return setup(result -> result.setKeySelectionManager(aManager));
        }

        /**
         * @see JComboBox#setLightWeightPopupEnabled(boolean)
         */
        default S setLightWeightPopupEnabled(final boolean aFlag) {
            return setup(result -> result.setLightWeightPopupEnabled(aFlag));
        }

        /**
         * @see JComboBox#setMaximumRowCount(int)
         */
        default S setMaximumRowCount(final int count) {
            return setup(result -> result.setMaximumRowCount(count));
        }

        /**
         * @see JComboBox#setModel(ComboBoxModel)
         */
        default S setModel(final ComboBoxModel<E> aModel) {
            return setup(result -> result.setModel(aModel));
        }

        /**
         * @see JComboBox#setPopupVisible(boolean)
         */
        default S setPopupVisible(final boolean v) {
            return setup(result -> result.setPopupVisible(v));
        }

        /**
         * @see JComboBox#setPrototypeDisplayValue(Object)
         */
        default S setPrototypeDisplayValue(final E prototypeDisplayValue) {
            return setup(result -> result.setPrototypeDisplayValue(prototypeDisplayValue));
        }

        /**
         * @see JComboBox#setRenderer(ListCellRenderer)
         */
        default S setRenderer(final ListCellRenderer<? super E> aRenderer) {
            return setup(result -> result.setRenderer(aRenderer));
        }

        /**
         * @see JComboBox#setSelectedIndex(int)
         */
        default S setSelectedIndex(final int anIndex) {
            return setup(result -> result.setSelectedIndex(anIndex));
        }

        /**
         * @see JComboBox#setSelectedItem(Object)
         */
        default S setSelectedItem(final Object anObject) {
            return setup(result -> result.setSelectedItem(anObject));
        }

        /**
         * @see JComboBox#setUI(ComboBoxUI)
         */
        default S setUI(final ComboBoxUI ui) {
            return setup(result -> result.setUI(ui));
        }
    }
}
