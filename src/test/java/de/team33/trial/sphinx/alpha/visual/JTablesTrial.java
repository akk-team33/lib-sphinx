package de.team33.trial.sphinx.alpha.visual;

import de.team33.sphinx.alpha.activity.Event;
import de.team33.sphinx.alpha.option.BackedBounds;
import de.team33.sphinx.alpha.visual.JFrames;
import de.team33.sphinx.alpha.visual.JTables;

import javax.swing.*;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.prefs.Preferences;


class JTablesTrial {

    private static final String APP_NODE = JTablesTrial.class.getPackage().getName();
    private static final Preferences PREFERENCES = Preferences.userRoot().node(APP_NODE);
    private static final String WIN_NODE = JTablesTrial.class.getSimpleName();
    private static final Rectangle SIZE0 = new Rectangle(0, 0, 640, 480);

    private final JFrame frame;

    public JTablesTrial(final String[] args) {
        final Preferences preferences = PREFERENCES.node(WIN_NODE);
        this.frame = JFrames.builder()
                            .setTitle(JTablesTrial.class.getCanonicalName())
                            .setup(new BackedBounds(preferences, SIZE0)::setupFrame)
                            .setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE)
                            .add(jTable())
                            .setVisible(true)
                            .build();
    }

    private JTable jTable() {
        return JTables.builder()
                      .setModel(new TrialModel())
                      //.setColumnModel(new TrialColumnModel())
                      .addColumn(new TableColumn(0))
                      .addColumn(new TableColumn(1))
                      .addColumn(new TableColumn(2))
                      .addColumn(new TableColumn(3))
                      .build();
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> new JTablesTrial(args));
    }

    private class TrialModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return 10;
        }

        @Override
        public int getColumnCount() {
            return 0;
        }

        @Override
        public Object getValueAt(final int rowIndex, final int columnIndex) {
            return String.format("Cell @ (%d, %d)", rowIndex, columnIndex);
        }

        @Override
        public String getColumnName(final int column) {
            return "Column " + column;
        }
    }

    private class TrialColumnModel implements javax.swing.table.TableColumnModel {
        @Override
        public void addColumn(final TableColumn aColumn) {
            throw new UnsupportedOperationException("not yet implemented");
        }

        @Override
        public void removeColumn(final TableColumn column) {
            throw new UnsupportedOperationException("not yet implemented");
        }

        @Override
        public void moveColumn(final int columnIndex, final int newIndex) {
            throw new UnsupportedOperationException("not yet implemented");
        }

        @Override
        public void setColumnMargin(final int newMargin) {
            throw new UnsupportedOperationException("not yet implemented");
        }

        @Override
        public int getColumnCount() {
            throw new UnsupportedOperationException("not yet implemented");
        }

        @Override
        public Enumeration<TableColumn> getColumns() {
            throw new UnsupportedOperationException("not yet implemented");
        }

        @Override
        public int getColumnIndex(final Object columnIdentifier) {
            throw new UnsupportedOperationException("not yet implemented");
        }

        @Override
        public TableColumn getColumn(final int columnIndex) {
            throw new UnsupportedOperationException("not yet implemented");
        }

        @Override
        public int getColumnMargin() {
            throw new UnsupportedOperationException("not yet implemented");
        }

        @Override
        public int getColumnIndexAtX(final int xPosition) {
            throw new UnsupportedOperationException("not yet implemented");
        }

        @Override
        public int getTotalColumnWidth() {
            throw new UnsupportedOperationException("not yet implemented");
        }

        @Override
        public void setColumnSelectionAllowed(final boolean flag) {
            throw new UnsupportedOperationException("not yet implemented");
        }

        @Override
        public boolean getColumnSelectionAllowed() {
            throw new UnsupportedOperationException("not yet implemented");
        }

        @Override
        public int[] getSelectedColumns() {
            throw new UnsupportedOperationException("not yet implemented");
        }

        @Override
        public int getSelectedColumnCount() {
            throw new UnsupportedOperationException("not yet implemented");
        }

        @Override
        public void setSelectionModel(final ListSelectionModel newModel) {
            throw new UnsupportedOperationException("not yet implemented");
        }

        @Override
        public ListSelectionModel getSelectionModel() {
            throw new UnsupportedOperationException("not yet implemented");
        }

        @Override
        public void addColumnModelListener(final TableColumnModelListener x) {
            throw new UnsupportedOperationException("not yet implemented");
        }

        @Override
        public void removeColumnModelListener(final TableColumnModelListener x) {
            throw new UnsupportedOperationException("not yet implemented");
        }
    }
}
