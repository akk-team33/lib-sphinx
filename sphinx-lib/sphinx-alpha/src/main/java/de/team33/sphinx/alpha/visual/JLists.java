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
@SuppressWarnings("unused")
public final class JLists {

    private JLists() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JList}.
     *
     * @param <E> The element type.
     */
    public static <E> Builder<E, JList<E>> builder(final ListModel<E> model) {
        return new Builder<>(() -> new JList<>(model), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     *
     * @param <E> The element type.
     * @param <T> The final type of the target instances, at least {@link JList}.
     */
    public static <E, T extends JList<E>> Builder<E, T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JList}.
     * 
     * @param <T> The final type of the target instances, at least {@link JList}.
     */
    public static final class Builder<E, T extends JList<E>>
            extends LateBuilder<T, Builder<E, T>> implements Setup<E, T, Builder<E, T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JList}.
     *
     * @param <E> The element type.
     * @param <T> The final type of the target instance, at least {@link JList}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings({"ClassNameSameAsAncestorName", "ClassWithTooManyMethods"})
    @FunctionalInterface
    public interface Setup<E, T extends JList<E>, S extends Setup<E, T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JList#addSelectionInterval(int, int)
         */
        default S addSelectionInterval(final int arg0, final int arg1) {
            return setup(result -> result.addSelectionInterval(arg0, arg1));
        }

        /**
         * @see JList#removeSelectionInterval(int, int)
         */
        default S removeSelectionInterval(final int arg0, final int arg1) {
            return setup(result -> result.removeSelectionInterval(arg0, arg1));
        }

        /**
         * @see JList#setCellRenderer(ListCellRenderer)
         */
        default S setCellRenderer(final ListCellRenderer<? super E> arg0) {
            return setup(result -> result.setCellRenderer(arg0));
        }

        /**
         * @see JList#setDragEnabled(boolean)
         */
        default S setDragEnabled(final boolean arg0) {
            return setup(result -> result.setDragEnabled(arg0));
        }

        /**
         * @see JList#setDropMode(DropMode)
         */
        default S setDropMode(final DropMode arg0) {
            return setup(result -> result.setDropMode(arg0));
        }

        /**
         * @see JList#setFixedCellHeight(int)
         */
        default S setFixedCellHeight(final int arg0) {
            return setup(result -> result.setFixedCellHeight(arg0));
        }

        /**
         * @see JList#setFixedCellWidth(int)
         */
        default S setFixedCellWidth(final int arg0) {
            return setup(result -> result.setFixedCellWidth(arg0));
        }

        /**
         * @see JList#setLayoutOrientation(int)
         */
        default S setLayoutOrientation(final int arg0) {
            return setup(result -> result.setLayoutOrientation(arg0));
        }

        /**
         * @see JList#setListData(Object[])
         */
        default S setListData(final E[] arg0) {
            return setup(result -> result.setListData(arg0));
        }

        /**
         * @see JList#setListData(Vector)
         */
        default S setListData(final Vector<? extends E> arg0) {
            return setup(result -> result.setListData(arg0));
        }

        /**
         * @see JList#setModel(ListModel)
         */
        default S setModel(final ListModel<E> arg0) {
            return setup(result -> result.setModel(arg0));
        }

        /**
         * @see JList#setPrototypeCellValue(Object)
         */
        default S setPrototypeCellValue(final E arg0) {
            return setup(result -> result.setPrototypeCellValue(arg0));
        }

        /**
         * @see JList#setSelectedIndex(int)
         */
        default S setSelectedIndex(final int arg0) {
            return setup(result -> result.setSelectedIndex(arg0));
        }

        /**
         * @see JList#setSelectedIndices(int[])
         */
        default S setSelectedIndices(final int[] arg0) {
            return setup(result -> result.setSelectedIndices(arg0));
        }

        /**
         * @see JList#setSelectedValue(Object, boolean)
         */
        default S setSelectedValue(final Object item, final boolean shouldScroll) {
            return setup(result -> result.setSelectedValue(item, shouldScroll));
        }

        /**
         * @see JList#setSelectionBackground(Color)
         */
        default S setSelectionBackground(final Color arg0) {
            return setup(result -> result.setSelectionBackground(arg0));
        }

        /**
         * @see JList#setSelectionForeground(Color)
         */
        default S setSelectionForeground(final Color arg0) {
            return setup(result -> result.setSelectionForeground(arg0));
        }

        /**
         * @see JList#setSelectionInterval(int, int)
         */
        default S setSelectionInterval(final int arg0, final int arg1) {
            return setup(result -> result.setSelectionInterval(arg0, arg1));
        }

        /**
         * @see JList#setSelectionMode(int)
         */
        default S setSelectionMode(final int arg0) {
            return setup(result -> result.setSelectionMode(arg0));
        }

        /**
         * @see JList#setSelectionModel(ListSelectionModel)
         */
        default S setSelectionModel(final ListSelectionModel arg0) {
            return setup(result -> result.setSelectionModel(arg0));
        }

        /**
         * @see JList#setUI(ListUI)
         */
        default S setUI(final ListUI arg0) {
            return setup(result -> result.setUI(arg0));
        }

        /**
         * @see JList#setValueIsAdjusting(boolean)
         */
        default S setValueIsAdjusting(final boolean arg0) {
            return setup(result -> result.setValueIsAdjusting(arg0));
        }

        /**
         * @see JList#setVisibleRowCount(int)
         */
        default S setVisibleRowCount(final int arg0) {
            return setup(result -> result.setVisibleRowCount(arg0));
        }
    }
}
