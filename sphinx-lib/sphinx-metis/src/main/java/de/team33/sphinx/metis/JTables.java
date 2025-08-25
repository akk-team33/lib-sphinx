package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import javax.swing.plaf.TableUI;
import javax.swing.table.*;
import java.awt.*;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JTable}s.
 */
@SuppressWarnings("unused")
public final class JTables {

    private JTables() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JTable}.
     *
     * @see #builder(Supplier)
     * @see JTable#JTable()
     */
    public static Builder<JTable> builder() {
        return new Builder<>(JTable::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JTable}.
     *
     * @see #builder(Supplier)
     * @see JTable#JTable(TableModel)
     */
    public static Builder<JTable> builder(final TableModel model) {
        return new Builder<>(() -> new JTable(model), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JTable}.
     *
     * @see #builder(Supplier)
     * @see JTable#JTable(TableModel, TableColumnModel)
     */
    public static Builder<JTable> builder(final TableModel tableModel, final TableColumnModel columnModel) {
        return new Builder<>(() -> new JTable(tableModel, columnModel), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JTable}.
     *
     * @see #builder(Supplier)
     * @see JTable#JTable(TableModel, TableColumnModel, ListSelectionModel)
     */
    public static Builder<JTable> builder(final TableModel tableModel,
                                          final TableColumnModel columnModel,
                                          final ListSelectionModel selectionModel) {
        return new Builder<>(() -> new JTable(tableModel, columnModel, selectionModel), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     *
     * @param <T> The final type of the target instances, at least {@link JTable}.
     */
    public static <T extends JTable> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     *
     * @param <T> The final type of the target instance, at least {@link JTable}.
     */
    public static <T extends JTable> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Returns a new {@link Setup} for a given {@link JTable} instance.
     */
    public static Setup<JTable, ?> setup(final JTable target) {
        return charger(target);
    }

    /**
     * Utility interface to set up a target instance of {@link JTable}.
     *
     * @param <T> The final type of the target instance, at least {@link JTable}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JTable, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JTable#addColumn(TableColumn)
         */
        default S addColumn(final TableColumn column) {
            return setup(result -> result.addColumn(column));
        }

        /**
         * @see JTable#addColumnSelectionInterval(int, int)
         */
        default S addColumnSelectionInterval(final int minIndex, final int maxIndex) {
            return setup(result -> result.addColumnSelectionInterval(minIndex, maxIndex));
        }

        /**
         * @see JTable#addRowSelectionInterval(int, int)
         */
        default S addRowSelectionInterval(final int minIndex, final int maxIndex) {
            return setup(result -> result.addRowSelectionInterval(minIndex, maxIndex));
        }

        /**
         * @see JTable#removeColumn(TableColumn)
         */
        default S removeColumn(final TableColumn column) {
            return setup(result -> result.removeColumn(column));
        }

        /**
         * @see JTable#removeColumnSelectionInterval(int, int)
         */
        default S removeColumnSelectionInterval(final int minIndex, final int maxIndex) {
            return setup(result -> result.removeColumnSelectionInterval(minIndex, maxIndex));
        }

        /**
         * @see JTable#removeEditor()
         */
        default S removeEditor() {
            return setup(JTable::removeEditor);
        }

        /**
         * @see JTable#removeRowSelectionInterval(int, int)
         */
        default S removeRowSelectionInterval(final int minIndex, final int maxIndex) {
            return setup(result -> result.removeRowSelectionInterval(minIndex, maxIndex));
        }

        /**
         * @see JTable#setAutoCreateColumnsFromModel(boolean)
         */
        default S setAutoCreateColumnsFromModel(final boolean autoCreate) {
            return setup(result -> result.setAutoCreateColumnsFromModel(autoCreate));
        }

        /**
         * @see JTable#setAutoCreateRowSorter(boolean)
         */
        default S setAutoCreateRowSorter(final boolean autoCreate) {
            return setup(result -> result.setAutoCreateRowSorter(autoCreate));
        }

        /**
         * @see JTable#setAutoResizeMode(int)
         */
        default S setAutoResizeMode(final int mode) {
            return setup(result -> result.setAutoResizeMode(mode));
        }

        /**
         * @see JTable#setCellEditor(TableCellEditor)
         */
        default S setCellEditor(final TableCellEditor editor) {
            return setup(result -> result.setCellEditor(editor));
        }

        /**
         * @see JTable#setCellSelectionEnabled(boolean)
         */
        default S setCellSelectionEnabled(final boolean enabled) {
            return setup(result -> result.setCellSelectionEnabled(enabled));
        }

        /**
         * @see JTable#setColumnModel(TableColumnModel)
         */
        default S setColumnModel(final TableColumnModel model) {
            return setup(result -> result.setColumnModel(model));
        }

        /**
         * @see JTable#setColumnSelectionAllowed(boolean)
         */
        default S setColumnSelectionAllowed(final boolean allowed) {
            return setup(result -> result.setColumnSelectionAllowed(allowed));
        }

        /**
         * @see JTable#setColumnSelectionInterval(int, int)
         */
        default S setColumnSelectionInterval(final int minIndex, final int maxIndex) {
            return setup(result -> result.setColumnSelectionInterval(minIndex, maxIndex));
        }

        /**
         * @see JTable#setDefaultEditor(Class, TableCellEditor)
         */
        default S setDefaultEditor(final Class<?> columnClass, final TableCellEditor editor) {
            return setup(result -> result.setDefaultEditor(columnClass, editor));
        }

        /**
         * @see JTable#setDefaultRenderer(Class, TableCellRenderer)
         */
        default S setDefaultRenderer(final Class<?> columnClass, final TableCellRenderer renderer) {
            return setup(result -> result.setDefaultRenderer(columnClass, renderer));
        }

        /**
         * @see JTable#setDragEnabled(boolean)
         */
        default S setDragEnabled(final boolean enabled) {
            return setup(result -> result.setDragEnabled(enabled));
        }

        /**
         * @see JTable#setDropMode(DropMode)
         */
        default S setDropMode(final DropMode mode) {
            return setup(result -> result.setDropMode(mode));
        }

        /**
         * @see JTable#setEditingColumn(int)
         */
        default S setEditingColumn(final int index) {
            return setup(result -> result.setEditingColumn(index));
        }

        /**
         * @see JTable#setEditingRow(int)
         */
        default S setEditingRow(final int index) {
            return setup(result -> result.setEditingRow(index));
        }

        /**
         * @see JTable#setFillsViewportHeight(boolean)
         */
        default S setFillsViewportHeight(final boolean height) {
            return setup(result -> result.setFillsViewportHeight(height));
        }

        /**
         * @see JTable#setGridColor(Color)
         */
        default S setGridColor(final Color color) {
            return setup(result -> result.setGridColor(color));
        }

        /**
         * @see JTable#setIntercellSpacing(Dimension)
         */
        default S setInterCellSpacing(final Dimension spacing) {
            return setup(result -> result.setIntercellSpacing(spacing));
        }

        /**
         * @see JTable#setModel(TableModel)
         */
        default S setModel(final TableModel model) {
            return setup(result -> result.setModel(model));
        }

        /**
         * @see JTable#setPreferredScrollableViewportSize(Dimension)
         */
        default S setPreferredScrollableViewportSize(final Dimension size) {
            return setup(result -> result.setPreferredScrollableViewportSize(size));
        }

        /**
         * @see JTable#setRowHeight(int)
         */
        default S setRowHeight(final int height) {
            return setup(result -> result.setRowHeight(height));
        }

        /**
         * @see JTable#setRowHeight(int, int)
         */
        default S setRowHeight(final int index, final int height) {
            return setup(result -> result.setRowHeight(index, height));
        }

        /**
         * @see JTable#setRowMargin(int)
         */
        default S setRowMargin(final int margin) {
            return setup(result -> result.setRowMargin(margin));
        }

        /**
         * @see JTable#setRowSelectionAllowed(boolean)
         */
        default S setRowSelectionAllowed(final boolean allowed) {
            return setup(result -> result.setRowSelectionAllowed(allowed));
        }

        /**
         * @see JTable#setRowSelectionInterval(int, int)
         */
        default S setRowSelectionInterval(final int minIndex, final int maxIndex) {
            return setup(result -> result.setRowSelectionInterval(minIndex, maxIndex));
        }

        /**
         * @see JTable#setRowSorter(RowSorter)
         */
        default S setRowSorter(final RowSorter<? extends TableModel> sorter) {
            return setup(result -> result.setRowSorter(sorter));
        }

        /**
         * @see JTable#setSelectionBackground(Color)
         */
        default S setSelectionBackground(final Color color) {
            return setup(result -> result.setSelectionBackground(color));
        }

        /**
         * @see JTable#setSelectionForeground(Color)
         */
        default S setSelectionForeground(final Color color) {
            return setup(result -> result.setSelectionForeground(color));
        }

        /**
         * @see JTable#setSelectionMode(int)
         */
        default S setSelectionMode(final int mode) {
            return setup(result -> result.setSelectionMode(mode));
        }

        /**
         * @see JTable#setSelectionModel(ListSelectionModel)
         */
        default S setSelectionModel(final ListSelectionModel model) {
            return setup(result -> result.setSelectionModel(model));
        }

        /**
         * @see JTable#setShowGrid(boolean)
         */
        default S setShowGrid(final boolean show) {
            return setup(result -> result.setShowGrid(show));
        }

        /**
         * @see JTable#setShowHorizontalLines(boolean)
         */
        default S setShowHorizontalLines(final boolean show) {
            return setup(result -> result.setShowHorizontalLines(show));
        }

        /**
         * @see JTable#setShowVerticalLines(boolean)
         */
        default S setShowVerticalLines(final boolean show) {
            return setup(result -> result.setShowVerticalLines(show));
        }

        /**
         * @see JTable#setSurrendersFocusOnKeystroke(boolean)
         */
        default S setSurrendersFocusOnKeystroke(final boolean surrenders) {
            return setup(result -> result.setSurrendersFocusOnKeystroke(surrenders));
        }

        /**
         * @see JTable#setTableHeader(JTableHeader)
         */
        default S setTableHeader(final JTableHeader header) {
            return setup(result -> result.setTableHeader(header));
        }

        /**
         * @see JTable#setUI(TableUI)
         */
        default S setUI(final TableUI ui) {
            return setup(result -> result.setUI(ui));
        }

        /**
         * @see JTable#setUpdateSelectionOnSort(boolean)
         */
        default S setUpdateSelectionOnSort(final boolean update) {
            return setup(result -> result.setUpdateSelectionOnSort(update));
        }

        /**
         * @see JTable#setValueAt(Object, int, int)
         */
        default S setValueAt(final Object value, final int rowIndex, final int colIndex) {
            return setup(result -> result.setValueAt(value, rowIndex, colIndex));
        }
    }

    /**
     * Builder implementation to build target instances of {@link JTable}.
     *
     * @param <T> The final type of the target instances, at least {@link JTable}.
     */
    public static final class Builder<T extends JTable>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JTable}.
     *
     * @param <T> The final type of the target instance, at least {@link JTable}.
     */
    public static final class Charger<T extends JTable>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings("unchecked")
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }
}
