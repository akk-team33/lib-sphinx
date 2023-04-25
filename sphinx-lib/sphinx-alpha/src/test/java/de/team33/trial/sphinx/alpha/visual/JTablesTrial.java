package de.team33.trial.sphinx.alpha.visual;

import de.team33.sphinx.alpha.option.BackedBounds;
import de.team33.sphinx.alpha.visual.JFrames;
import de.team33.sphinx.alpha.visual.JScrollPanes;
import de.team33.sphinx.alpha.visual.JTables;
import de.team33.sphinx.alpha.visual.JViewports;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.List;
import java.util.prefs.Preferences;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class JTablesTrial {

    private static final String APP_NODE = JTablesTrial.class.getPackage().getName();
    private static final Preferences PREFERENCES = Preferences.userRoot().node(APP_NODE);
    private static final String WIN_NODE = JTablesTrial.class.getSimpleName();
    private static final Rectangle SIZE0 = new Rectangle(0, 0, 640, 480);

    private final JFrame frame;
    private final List<File> files;

    public JTablesTrial(final String[] args) {
        try (final Stream<Path> stream = Files.list(Paths.get(".").normalize())) {
            this.files = stream.map(Path::toFile)
                               .collect(Collectors.toList());
        } catch (final IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        final Preferences preferences = PREFERENCES.node(WIN_NODE);
        this.frame = JFrames.builder()
                            .setTitle(JTablesTrial.class.getCanonicalName())
                            .setup(new BackedBounds(preferences, SIZE0)::setupFrame)
                            .setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE)
                            .add(jScrollPane())
                            .setVisible(true)
                            .build();
    }

    private JScrollPane jScrollPane() {
        JScrollPane pane = new JScrollPane(jTable());
        //pane.setColumnHeader(JViewports.builder().build());
        //pane.getViewport().setBackground(Color.WHITE);
        pane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        return JScrollPanes.builder()
                           .setViewport(JViewports.builder()
                                                  .setView(jTable())
                                                  .setBackground(Color.WHITE)
                                                  .build())
                           .build();
    }

    private JTable jTable() {
        return JTables.builder()
                      .setModel(new TrialModel())
                      //.setColumnModel(new TrialColumnModel())
                      .setFocusable(false)
                      .setAutoResizeMode(2)
                      .setRowHeight(19)
                      .setShowGrid(false)
                      .setRowSelectionAllowed(false)
                      .setColumnSelectionAllowed(false)
                      .addColumn(new TableColumn(0, 30))
                      .addColumn(new TableColumn(1, 15))
                      .addColumn(new TableColumn(2, 45))
                      .build();
    }

    private TableCellRenderer newCellRenderer() {
        return new DefaultTableCellRenderer() {

        };
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> new JTablesTrial(args));
    }

    private class TrialModel implements TableModel {

        @Override
        public int getRowCount() {
            return files.size();
        }

        @Override
        public int getColumnCount() {
            return 0;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return "Column " + columnIndex;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return File.class;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return files.get(rowIndex);
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            throw new UnsupportedOperationException("not yet implemented");
        }

        @Override
        public void addTableModelListener(TableModelListener l) {

        }

        @Override
        public void removeTableModelListener(TableModelListener l) {

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
