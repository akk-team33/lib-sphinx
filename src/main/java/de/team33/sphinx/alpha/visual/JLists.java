package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Color;
import java.util.Vector;
import java.util.function.Supplier;
import javax.swing.DropMode;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.ListUI;

/**
 * Utility class to handle {@link JList}s.
 */
@SuppressWarnings({"unused", "InterfaceWithOnlyOneDirectInheritor", "BooleanParameter"})
public final class JLists {

    private JLists() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JList}.
     */
    public static <E> Builder<E, JList<E>, ?> builder(final ListModel<E> model) {
        return builder(() -> new JList<>(model)).setModel(model);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JList}.
     */
    public static <E, T extends JList<E>> Builder<E, T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JList}.
     * 
     * @param <T> The final type of the target instances, at least {@link JList}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<E, T extends JList<E>, B extends Builder<E, T, B>>
            extends LateBuilder<T, B> implements Setup<E, T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JList}.
     * 
     * @param <T> The final type of the target instance, at least {@link JList}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings({"ClassNameSameAsAncestorName", "ClassWithTooManyMethods"})
    @FunctionalInterface
    public interface Setup<E, T extends JList<E>, S extends Setup<E, T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JList#addSelectionInterval(int, int)
         */
        default S addSelectionInterval(final int anchor, final int lead) {
            return setup(result -> result.addSelectionInterval(anchor, lead));
        }

        /**
         * @see JList#removeSelectionInterval(int, int)
         */
        default S removeSelectionInterval(final int index0, final int index1) {
            return setup(result -> result.removeSelectionInterval(index0, index1));
        }

        /**
         * @see JList#setCellRenderer(ListCellRenderer)
         */
        default S setCellRenderer(final ListCellRenderer<? super E> cellRenderer) {
            return setup(result -> result.setCellRenderer(cellRenderer));
        }

        /**
         * @see JList#setDragEnabled(boolean)
         */
        default S setDragEnabled(final boolean b) {
            return setup(result -> result.setDragEnabled(b));
        }

        /**
         * @see JList#setDropMode(DropMode)
         */
        default S setDropMode(final DropMode dropMode) {
            return setup(result -> result.setDropMode(dropMode));
        }

        /**
         * @see JList#setFixedCellHeight(int)
         */
        default S setFixedCellHeight(final int height) {
            return setup(result -> result.setFixedCellHeight(height));
        }

        /**
         * @see JList#setFixedCellWidth(int)
         */
        default S setFixedCellWidth(final int width) {
            return setup(result -> result.setFixedCellWidth(width));
        }

        /**
         * @see JList#setLayoutOrientation(int)
         */
        default S setLayoutOrientation(final int layoutOrientation) {
            return setup(result -> result.setLayoutOrientation(layoutOrientation));
        }

        /**
         * @see JList#setListData(Object[])
         */
        default S setListData(final E[] listData) {
            return setup(result -> result.setListData(listData));
        }

        /**
         * @see JList#setListData(Vector)
         */
        default S setListData(final Vector<? extends E> listData) {
            return setup(result -> result.setListData(listData));
        }

        /**
         * @see JList#setModel(ListModel)
         */
        default S setModel(final ListModel<E> model) {
            return setup(result -> result.setModel(model));
        }

        /**
         * @see JList#setPrototypeCellValue(Object)
         */
        default S setPrototypeCellValue(final E prototypeCellValue) {
            return setup(result -> result.setPrototypeCellValue(prototypeCellValue));
        }

        /**
         * @see JList#setSelectedIndex(int)
         */
        default S setSelectedIndex(final int index) {
            return setup(result -> result.setSelectedIndex(index));
        }

        /**
         * @see JList#setSelectedIndices(int[])
         */
        default S setSelectedIndices(final int[] indices) {
            return setup(result -> result.setSelectedIndices(indices));
        }

        /**
         * @see JList#setSelectedValue(Object, boolean)
         */
        default S setSelectedValue(final Object anObject, final boolean shouldScroll) {
            return setup(result -> result.setSelectedValue(anObject, shouldScroll));
        }

        /**
         * @see JList#setSelectionBackground(Color)
         */
        default S setSelectionBackground(final Color selectionBackground) {
            return setup(result -> result.setSelectionBackground(selectionBackground));
        }

        /**
         * @see JList#setSelectionForeground(Color)
         */
        default S setSelectionForeground(final Color selectionForeground) {
            return setup(result -> result.setSelectionForeground(selectionForeground));
        }

        /**
         * @see JList#setSelectionInterval(int, int)
         */
        default S setSelectionInterval(final int anchor, final int lead) {
            return setup(result -> result.setSelectionInterval(anchor, lead));
        }

        /**
         * @see JList#setSelectionMode(int)
         */
        default S setSelectionMode(final int selectionMode) {
            return setup(result -> result.setSelectionMode(selectionMode));
        }

        /**
         * @see JList#setSelectionModel(ListSelectionModel)
         */
        default S setSelectionModel(final ListSelectionModel selectionModel) {
            return setup(result -> result.setSelectionModel(selectionModel));
        }

        /**
         * @see JList#setUI(ListUI)
         */
        default S setUI(final ListUI ui) {
            return setup(result -> result.setUI(ui));
        }

        /**
         * @see JList#setValueIsAdjusting(boolean)
         */
        default S setValueIsAdjusting(final boolean b) {
            return setup(result -> result.setValueIsAdjusting(b));
        }

        /**
         * @see JList#setVisibleRowCount(int)
         */
        default S setVisibleRowCount(final int visibleRowCount) {
            return setup(result -> result.setVisibleRowCount(visibleRowCount));
        }
    }
}
