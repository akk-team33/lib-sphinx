package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.DropMode;
import javax.swing.JTree;
import javax.swing.plaf.TreeUI;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 * Utility class to handle {@link JTree}s.
 */
@SuppressWarnings("unused")
public final class JTrees {

    private JTrees() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JTree}.
     */
    public static Builder<JTree, ?> builder() {
        return new Builder<>(JTree::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTree}.
     */
    public static <T extends JTree> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JTree}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTree}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JTree, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JTree}.
     * 
     * @param <T> The final type of the target instance, at least {@link JTree}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JTree, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JTree#addSelectionInterval(int, int)
         */
        default S addSelectionInterval(final int index0, final int index1) {
            return setup(result -> result.addSelectionInterval(index0, index1));
        }

        /**
         * @see JTree#addSelectionPath(TreePath)
         */
        default S addSelectionPath(final TreePath path) {
            return setup(result -> result.addSelectionPath(path));
        }

        /**
         * @see JTree#addSelectionPaths(TreePath[])
         */
        default S addSelectionPaths(final javax.swing.tree.TreePath[] paths) {
            return setup(result -> result.addSelectionPaths(paths));
        }

        /**
         * @see JTree#addSelectionRow(int)
         */
        default S addSelectionRow(final int row) {
            return setup(result -> result.addSelectionRow(row));
        }

        /**
         * @see JTree#addSelectionRows(int[])
         */
        default S addSelectionRows(final int[] rows) {
            return setup(result -> result.addSelectionRows(rows));
        }

        /**
         * @see JTree#removeSelectionInterval(int, int)
         */
        default S removeSelectionInterval(final int index0, final int index1) {
            return setup(result -> result.removeSelectionInterval(index0, index1));
        }

        /**
         * @see JTree#removeSelectionPath(TreePath)
         */
        default S removeSelectionPath(final TreePath path) {
            return setup(result -> result.removeSelectionPath(path));
        }

        /**
         * @see JTree#removeSelectionPaths(TreePath[])
         */
        default S removeSelectionPaths(final javax.swing.tree.TreePath[] paths) {
            return setup(result -> result.removeSelectionPaths(paths));
        }

        /**
         * @see JTree#removeSelectionRow(int)
         */
        default S removeSelectionRow(final int row) {
            return setup(result -> result.removeSelectionRow(row));
        }

        /**
         * @see JTree#removeSelectionRows(int[])
         */
        default S removeSelectionRows(final int[] rows) {
            return setup(result -> result.removeSelectionRows(rows));
        }

        /**
         * @see JTree#setAnchorSelectionPath(TreePath)
         */
        default S setAnchorSelectionPath(final TreePath newPath) {
            return setup(result -> result.setAnchorSelectionPath(newPath));
        }

        /**
         * @see JTree#setCellEditor(TreeCellEditor)
         */
        default S setCellEditor(final TreeCellEditor cellEditor) {
            return setup(result -> result.setCellEditor(cellEditor));
        }

        /**
         * @see JTree#setCellRenderer(TreeCellRenderer)
         */
        default S setCellRenderer(final TreeCellRenderer x) {
            return setup(result -> result.setCellRenderer(x));
        }

        /**
         * @see JTree#setDragEnabled(boolean)
         */
        default S setDragEnabled(final boolean b) {
            return setup(result -> result.setDragEnabled(b));
        }

        /**
         * @see JTree#setDropMode(DropMode)
         */
        default S setDropMode(final DropMode dropMode) {
            return setup(result -> result.setDropMode(dropMode));
        }

        /**
         * @see JTree#setEditable(boolean)
         */
        default S setEditable(final boolean flag) {
            return setup(result -> result.setEditable(flag));
        }

        /**
         * @see JTree#setExpandsSelectedPaths(boolean)
         */
        default S setExpandsSelectedPaths(final boolean newValue) {
            return setup(result -> result.setExpandsSelectedPaths(newValue));
        }

        /**
         * @see JTree#setInvokesStopCellEditing(boolean)
         */
        default S setInvokesStopCellEditing(final boolean newValue) {
            return setup(result -> result.setInvokesStopCellEditing(newValue));
        }

        /**
         * @see JTree#setLargeModel(boolean)
         */
        default S setLargeModel(final boolean newValue) {
            return setup(result -> result.setLargeModel(newValue));
        }

        /**
         * @see JTree#setLeadSelectionPath(TreePath)
         */
        default S setLeadSelectionPath(final TreePath newPath) {
            return setup(result -> result.setLeadSelectionPath(newPath));
        }

        /**
         * @see JTree#setModel(TreeModel)
         */
        default S setModel(final TreeModel newModel) {
            return setup(result -> result.setModel(newModel));
        }

        /**
         * @see JTree#setRootVisible(boolean)
         */
        default S setRootVisible(final boolean rootVisible) {
            return setup(result -> result.setRootVisible(rootVisible));
        }

        /**
         * @see JTree#setRowHeight(int)
         */
        default S setRowHeight(final int rowHeight) {
            return setup(result -> result.setRowHeight(rowHeight));
        }

        /**
         * @see JTree#setScrollsOnExpand(boolean)
         */
        default S setScrollsOnExpand(final boolean newValue) {
            return setup(result -> result.setScrollsOnExpand(newValue));
        }

        /**
         * @see JTree#setSelectionInterval(int, int)
         */
        default S setSelectionInterval(final int index0, final int index1) {
            return setup(result -> result.setSelectionInterval(index0, index1));
        }

        /**
         * @see JTree#setSelectionModel(TreeSelectionModel)
         */
        default S setSelectionModel(final TreeSelectionModel selectionModel) {
            return setup(result -> result.setSelectionModel(selectionModel));
        }

        /**
         * @see JTree#setSelectionPath(TreePath)
         */
        default S setSelectionPath(final TreePath path) {
            return setup(result -> result.setSelectionPath(path));
        }

        /**
         * @see JTree#setSelectionPaths(TreePath[])
         */
        default S setSelectionPaths(final javax.swing.tree.TreePath[] paths) {
            return setup(result -> result.setSelectionPaths(paths));
        }

        /**
         * @see JTree#setSelectionRow(int)
         */
        default S setSelectionRow(final int row) {
            return setup(result -> result.setSelectionRow(row));
        }

        /**
         * @see JTree#setSelectionRows(int[])
         */
        default S setSelectionRows(final int[] rows) {
            return setup(result -> result.setSelectionRows(rows));
        }

        /**
         * @see JTree#setShowsRootHandles(boolean)
         */
        default S setShowsRootHandles(final boolean newValue) {
            return setup(result -> result.setShowsRootHandles(newValue));
        }

        /**
         * @see JTree#setToggleClickCount(int)
         */
        default S setToggleClickCount(final int clickCount) {
            return setup(result -> result.setToggleClickCount(clickCount));
        }

        /**
         * @see JTree#setUI(TreeUI)
         */
        default S setUI(final TreeUI ui) {
            return setup(result -> result.setUI(ui));
        }

        /**
         * @see JTree#setVisibleRowCount(int)
         */
        default S setVisibleRowCount(final int newCount) {
            return setup(result -> result.setVisibleRowCount(newCount));
        }
    }
}
