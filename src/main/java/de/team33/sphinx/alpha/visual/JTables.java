package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Color;
import java.awt.Dimension;
import java.util.function.Supplier;
import javax.swing.DropMode;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.plaf.TableUI;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 * Utility class to handle {@link JTable}s.
 */
@SuppressWarnings("unused")
public final class JTables {

    private JTables() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JTable}.
     */
    public static Builder<JTable, ?> builder() {
        return new Builder<>(JTable::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTable}.
     */
    public static <T extends JTable> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JTable}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTable}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JTable, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JTable}.
     * 
     * @param <T> The final type of the target instance, at least {@link JTable}.
     * @param <S> The final type of the Setup implementation.
     */
    @FunctionalInterface
    public interface Setup<T extends JTable, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JTable#addColumn(TableColumn)
         */
        default S addColumn(final TableColumn aColumn) {
            return setup(result -> result.addColumn(aColumn));
        }

        /**
         * @see JTable#addColumnSelectionInterval(int, int)
         */
        default S addColumnSelectionInterval(final int index0, final int index1) {
            return setup(result -> result.addColumnSelectionInterval(index0, index1));
        }

        /**
         * @see JTable#addRowSelectionInterval(int, int)
         */
        default S addRowSelectionInterval(final int index0, final int index1) {
            return setup(result -> result.addRowSelectionInterval(index0, index1));
        }

        /**
         * @see JTable#removeColumn(TableColumn)
         */
        default S removeColumn(final TableColumn aColumn) {
            return setup(result -> result.removeColumn(aColumn));
        }

        /**
         * @see JTable#removeColumnSelectionInterval(int, int)
         */
        default S removeColumnSelectionInterval(final int index0, final int index1) {
            return setup(result -> result.removeColumnSelectionInterval(index0, index1));
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
        default S removeRowSelectionInterval(final int index0, final int index1) {
            return setup(result -> result.removeRowSelectionInterval(index0, index1));
        }

        /**
         * @see JTable#setAutoCreateColumnsFromModel(boolean)
         */
        default S setAutoCreateColumnsFromModel(final boolean autoCreateColumnsFromModel) {
            return setup(result -> result.setAutoCreateColumnsFromModel(autoCreateColumnsFromModel));
        }

        /**
         * @see JTable#setAutoCreateRowSorter(boolean)
         */
        default S setAutoCreateRowSorter(final boolean autoCreateRowSorter) {
            return setup(result -> result.setAutoCreateRowSorter(autoCreateRowSorter));
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
        default S setCellEditor(final TableCellEditor anEditor) {
            return setup(result -> result.setCellEditor(anEditor));
        }

        /**
         * @see JTable#setCellSelectionEnabled(boolean)
         */
        default S setCellSelectionEnabled(final boolean cellSelectionEnabled) {
            return setup(result -> result.setCellSelectionEnabled(cellSelectionEnabled));
        }

        /**
         * @see JTable#setColumnModel(TableColumnModel)
         */
        default S setColumnModel(final TableColumnModel columnModel) {
            return setup(result -> result.setColumnModel(columnModel));
        }

        /**
         * @see JTable#setColumnSelectionAllowed(boolean)
         */
        default S setColumnSelectionAllowed(final boolean columnSelectionAllowed) {
            return setup(result -> result.setColumnSelectionAllowed(columnSelectionAllowed));
        }

        /**
         * @see JTable#setColumnSelectionInterval(int, int)
         */
        default S setColumnSelectionInterval(final int index0, final int index1) {
            return setup(result -> result.setColumnSelectionInterval(index0, index1));
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
        default S setDragEnabled(final boolean b) {
            return setup(result -> result.setDragEnabled(b));
        }

        /**
         * @see JTable#setDropMode(DropMode)
         */
        default S setDropMode(final DropMode dropMode) {
            return setup(result -> result.setDropMode(dropMode));
        }

        /**
         * @see JTable#setEditingColumn(int)
         */
        default S setEditingColumn(final int aColumn) {
            return setup(result -> result.setEditingColumn(aColumn));
        }

        /**
         * @see JTable#setEditingRow(int)
         */
        default S setEditingRow(final int aRow) {
            return setup(result -> result.setEditingRow(aRow));
        }

        /**
         * @see JTable#setFillsViewportHeight(boolean)
         */
        default S setFillsViewportHeight(final boolean fillsViewportHeight) {
            return setup(result -> result.setFillsViewportHeight(fillsViewportHeight));
        }

        /**
         * @see JTable#setGridColor(Color)
         */
        default S setGridColor(final Color gridColor) {
            return setup(result -> result.setGridColor(gridColor));
        }

        /**
         * @see JTable#setIntercellSpacing(Dimension)
         */
        default S setIntercellSpacing(final Dimension intercellSpacing) {
            return setup(result -> result.setIntercellSpacing(intercellSpacing));
        }

        /**
         * @see JTable#setModel(TableModel)
         */
        default S setModel(final TableModel dataModel) {
            return setup(result -> result.setModel(dataModel));
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
        default S setRowHeight(final int rowHeight) {
            return setup(result -> result.setRowHeight(rowHeight));
        }

        /**
         * @see JTable#setRowHeight(int, int)
         */
        default S setRowHeight(final int row, final int rowHeight) {
            return setup(result -> result.setRowHeight(row, rowHeight));
        }

        /**
         * @see JTable#setRowMargin(int)
         */
        default S setRowMargin(final int rowMargin) {
            return setup(result -> result.setRowMargin(rowMargin));
        }

        /**
         * @see JTable#setRowSelectionAllowed(boolean)
         */
        default S setRowSelectionAllowed(final boolean rowSelectionAllowed) {
            return setup(result -> result.setRowSelectionAllowed(rowSelectionAllowed));
        }

        /**
         * @see JTable#setRowSelectionInterval(int, int)
         */
        default S setRowSelectionInterval(final int index0, final int index1) {
            return setup(result -> result.setRowSelectionInterval(index0, index1));
        }

        /**
         * @see JTable#setRowSorter(RowSorter)
         */
        default S setRowSorter(final RowSorter<? extends javax.swing.table.TableModel> sorter) {
            return setup(result -> result.setRowSorter(sorter));
        }

        /**
         * @see JTable#setSelectionBackground(Color)
         */
        default S setSelectionBackground(final Color selectionBackground) {
            return setup(result -> result.setSelectionBackground(selectionBackground));
        }

        /**
         * @see JTable#setSelectionForeground(Color)
         */
        default S setSelectionForeground(final Color selectionForeground) {
            return setup(result -> result.setSelectionForeground(selectionForeground));
        }

        /**
         * @see JTable#setSelectionMode(int)
         */
        default S setSelectionMode(final int selectionMode) {
            return setup(result -> result.setSelectionMode(selectionMode));
        }

        /**
         * @see JTable#setSelectionModel(ListSelectionModel)
         */
        default S setSelectionModel(final ListSelectionModel newModel) {
            return setup(result -> result.setSelectionModel(newModel));
        }

        /**
         * @see JTable#setShowGrid(boolean)
         */
        default S setShowGrid(final boolean showGrid) {
            return setup(result -> result.setShowGrid(showGrid));
        }

        /**
         * @see JTable#setShowHorizontalLines(boolean)
         */
        default S setShowHorizontalLines(final boolean showHorizontalLines) {
            return setup(result -> result.setShowHorizontalLines(showHorizontalLines));
        }

        /**
         * @see JTable#setShowVerticalLines(boolean)
         */
        default S setShowVerticalLines(final boolean showVerticalLines) {
            return setup(result -> result.setShowVerticalLines(showVerticalLines));
        }

        /**
         * @see JTable#setSurrendersFocusOnKeystroke(boolean)
         */
        default S setSurrendersFocusOnKeystroke(final boolean surrendersFocusOnKeystroke) {
            return setup(result -> result.setSurrendersFocusOnKeystroke(surrendersFocusOnKeystroke));
        }

        /**
         * @see JTable#setTableHeader(JTableHeader)
         */
        default S setTableHeader(final JTableHeader tableHeader) {
            return setup(result -> result.setTableHeader(tableHeader));
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
        default S setValueAt(final Object aValue, final int row, final int column) {
            return setup(result -> result.setValueAt(aValue, row, column));
        }
    }
}
