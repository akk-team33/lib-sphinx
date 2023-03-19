package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Color;
import java.awt.Dimension;
import java.util.function.Supplier;
import javax.swing.DropMode;
import javax.swing.JComponent;
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
    public interface Setup<T extends JTable, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JTable#addColumn(TableColumn)
         */
        default S addColumn(final TableColumn arg0) {
            return setup(result -> result.addColumn(arg0));
        }

        /**
         * @see JTable#addColumnSelectionInterval(int, int)
         */
        default S addColumnSelectionInterval(final int arg0, final int arg1) {
            return setup(result -> result.addColumnSelectionInterval(arg0, arg1));
        }

        /**
         * @see JTable#addRowSelectionInterval(int, int)
         */
        default S addRowSelectionInterval(final int arg0, final int arg1) {
            return setup(result -> result.addRowSelectionInterval(arg0, arg1));
        }

        /**
         * @see JTable#removeColumn(TableColumn)
         */
        default S removeColumn(final TableColumn arg0) {
            return setup(result -> result.removeColumn(arg0));
        }

        /**
         * @see JTable#removeColumnSelectionInterval(int, int)
         */
        default S removeColumnSelectionInterval(final int arg0, final int arg1) {
            return setup(result -> result.removeColumnSelectionInterval(arg0, arg1));
        }

        /**
         * @see JTable#removeEditor()
         */
        default S removeEditor() {
            return setup(result -> result.removeEditor());
        }

        /**
         * @see JTable#removeRowSelectionInterval(int, int)
         */
        default S removeRowSelectionInterval(final int arg0, final int arg1) {
            return setup(result -> result.removeRowSelectionInterval(arg0, arg1));
        }

        /**
         * @see JTable#setAutoCreateColumnsFromModel(boolean)
         */
        default S setAutoCreateColumnsFromModel(final boolean arg0) {
            return setup(result -> result.setAutoCreateColumnsFromModel(arg0));
        }

        /**
         * @see JTable#setAutoCreateRowSorter(boolean)
         */
        default S setAutoCreateRowSorter(final boolean arg0) {
            return setup(result -> result.setAutoCreateRowSorter(arg0));
        }

        /**
         * @see JTable#setAutoResizeMode(int)
         */
        default S setAutoResizeMode(final int arg0) {
            return setup(result -> result.setAutoResizeMode(arg0));
        }

        /**
         * @see JTable#setCellEditor(TableCellEditor)
         */
        default S setCellEditor(final TableCellEditor arg0) {
            return setup(result -> result.setCellEditor(arg0));
        }

        /**
         * @see JTable#setCellSelectionEnabled(boolean)
         */
        default S setCellSelectionEnabled(final boolean arg0) {
            return setup(result -> result.setCellSelectionEnabled(arg0));
        }

        /**
         * @see JTable#setColumnModel(TableColumnModel)
         */
        default S setColumnModel(final TableColumnModel arg0) {
            return setup(result -> result.setColumnModel(arg0));
        }

        /**
         * @see JTable#setColumnSelectionAllowed(boolean)
         */
        default S setColumnSelectionAllowed(final boolean arg0) {
            return setup(result -> result.setColumnSelectionAllowed(arg0));
        }

        /**
         * @see JTable#setColumnSelectionInterval(int, int)
         */
        default S setColumnSelectionInterval(final int arg0, final int arg1) {
            return setup(result -> result.setColumnSelectionInterval(arg0, arg1));
        }

        /**
         * @see JTable#setDefaultEditor(Class, TableCellEditor)
         */
        default S setDefaultEditor(final Class<?> arg0, final TableCellEditor arg1) {
            return setup(result -> result.setDefaultEditor(arg0, arg1));
        }

        /**
         * @see JTable#setDefaultRenderer(Class, TableCellRenderer)
         */
        default S setDefaultRenderer(final Class<?> arg0, final TableCellRenderer arg1) {
            return setup(result -> result.setDefaultRenderer(arg0, arg1));
        }

        /**
         * @see JTable#setDragEnabled(boolean)
         */
        default S setDragEnabled(final boolean arg0) {
            return setup(result -> result.setDragEnabled(arg0));
        }

        /**
         * @see JTable#setDropMode(DropMode)
         */
        default S setDropMode(final DropMode arg0) {
            return setup(result -> result.setDropMode(arg0));
        }

        /**
         * @see JTable#setEditingColumn(int)
         */
        default S setEditingColumn(final int arg0) {
            return setup(result -> result.setEditingColumn(arg0));
        }

        /**
         * @see JTable#setEditingRow(int)
         */
        default S setEditingRow(final int arg0) {
            return setup(result -> result.setEditingRow(arg0));
        }

        /**
         * @see JTable#setFillsViewportHeight(boolean)
         */
        default S setFillsViewportHeight(final boolean arg0) {
            return setup(result -> result.setFillsViewportHeight(arg0));
        }

        /**
         * @see JTable#setGridColor(Color)
         */
        default S setGridColor(final Color arg0) {
            return setup(result -> result.setGridColor(arg0));
        }

        /**
         * @see JTable#setIntercellSpacing(Dimension)
         */
        default S setIntercellSpacing(final Dimension arg0) {
            return setup(result -> result.setIntercellSpacing(arg0));
        }

        /**
         * @see JTable#setModel(TableModel)
         */
        default S setModel(final TableModel arg0) {
            return setup(result -> result.setModel(arg0));
        }

        /**
         * @see JTable#setPreferredScrollableViewportSize(Dimension)
         */
        default S setPreferredScrollableViewportSize(final Dimension arg0) {
            return setup(result -> result.setPreferredScrollableViewportSize(arg0));
        }

        /**
         * @see JTable#setRowHeight(int)
         */
        default S setRowHeight(final int arg0) {
            return setup(result -> result.setRowHeight(arg0));
        }

        /**
         * @see JTable#setRowHeight(int, int)
         */
        default S setRowHeight(final int arg0, final int arg1) {
            return setup(result -> result.setRowHeight(arg0, arg1));
        }

        /**
         * @see JTable#setRowMargin(int)
         */
        default S setRowMargin(final int arg0) {
            return setup(result -> result.setRowMargin(arg0));
        }

        /**
         * @see JTable#setRowSelectionAllowed(boolean)
         */
        default S setRowSelectionAllowed(final boolean arg0) {
            return setup(result -> result.setRowSelectionAllowed(arg0));
        }

        /**
         * @see JTable#setRowSelectionInterval(int, int)
         */
        default S setRowSelectionInterval(final int arg0, final int arg1) {
            return setup(result -> result.setRowSelectionInterval(arg0, arg1));
        }

        /**
         * @see JTable#setRowSorter(RowSorter)
         */
        default S setRowSorter(final RowSorter<? extends javax.swing.table.TableModel> arg0) {
            return setup(result -> result.setRowSorter(arg0));
        }

        /**
         * @see JTable#setSelectionBackground(Color)
         */
        default S setSelectionBackground(final Color arg0) {
            return setup(result -> result.setSelectionBackground(arg0));
        }

        /**
         * @see JTable#setSelectionForeground(Color)
         */
        default S setSelectionForeground(final Color arg0) {
            return setup(result -> result.setSelectionForeground(arg0));
        }

        /**
         * @see JTable#setSelectionMode(int)
         */
        default S setSelectionMode(final int arg0) {
            return setup(result -> result.setSelectionMode(arg0));
        }

        /**
         * @see JTable#setSelectionModel(ListSelectionModel)
         */
        default S setSelectionModel(final ListSelectionModel arg0) {
            return setup(result -> result.setSelectionModel(arg0));
        }

        /**
         * @see JTable#setShowGrid(boolean)
         */
        default S setShowGrid(final boolean arg0) {
            return setup(result -> result.setShowGrid(arg0));
        }

        /**
         * @see JTable#setShowHorizontalLines(boolean)
         */
        default S setShowHorizontalLines(final boolean arg0) {
            return setup(result -> result.setShowHorizontalLines(arg0));
        }

        /**
         * @see JTable#setShowVerticalLines(boolean)
         */
        default S setShowVerticalLines(final boolean arg0) {
            return setup(result -> result.setShowVerticalLines(arg0));
        }

        /**
         * @see JTable#setSurrendersFocusOnKeystroke(boolean)
         */
        default S setSurrendersFocusOnKeystroke(final boolean arg0) {
            return setup(result -> result.setSurrendersFocusOnKeystroke(arg0));
        }

        /**
         * @see JTable#setTableHeader(JTableHeader)
         */
        default S setTableHeader(final JTableHeader arg0) {
            return setup(result -> result.setTableHeader(arg0));
        }

        /**
         * @see JTable#setUI(TableUI)
         */
        default S setUI(final TableUI arg0) {
            return setup(result -> result.setUI(arg0));
        }

        /**
         * @see JTable#setUpdateSelectionOnSort(boolean)
         */
        default S setUpdateSelectionOnSort(final boolean arg0) {
            return setup(result -> result.setUpdateSelectionOnSort(arg0));
        }

        /**
         * @see JTable#setValueAt(Object, int, int)
         */
        default S setValueAt(final Object arg0, final int arg1, final int arg2) {
            return setup(result -> result.setValueAt(arg0, arg1, arg2));
        }
    }
}
