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
    public static Builder<JTree> builder() {
        return new Builder<>(JTree::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTree}.
     */
    public static <T extends JTree> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JTree}.
     */
    public static <T extends JTree> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link JTree}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTree}.
     */
    public static final class Builder<T extends JTree>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JTree}.
     * 
     * @param <T> The final type of the target instance, at least {@link JTree}.
     */
    public static final class Charger<T extends JTree>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JTree}.
     * 
     * @param <T> The final type of the target instance, at least {@link JTree}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JTree, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JTree#addSelectionInterval(int, int)
         */
        default S addSelectionInterval(final int arg0, final int arg1) {
            return setup(result -> result.addSelectionInterval(arg0, arg1));
        }

        /**
         * @see JTree#addSelectionPath(TreePath)
         */
        default S addSelectionPath(final TreePath arg0) {
            return setup(result -> result.addSelectionPath(arg0));
        }

        /**
         * @see JTree#addSelectionPaths(TreePath[])
         */
        default S addSelectionPaths(final javax.swing.tree.TreePath[] arg0) {
            return setup(result -> result.addSelectionPaths(arg0));
        }

        /**
         * @see JTree#addSelectionRow(int)
         */
        default S addSelectionRow(final int arg0) {
            return setup(result -> result.addSelectionRow(arg0));
        }

        /**
         * @see JTree#addSelectionRows(int[])
         */
        default S addSelectionRows(final int[] arg0) {
            return setup(result -> result.addSelectionRows(arg0));
        }

        /**
         * @see JTree#removeSelectionInterval(int, int)
         */
        default S removeSelectionInterval(final int arg0, final int arg1) {
            return setup(result -> result.removeSelectionInterval(arg0, arg1));
        }

        /**
         * @see JTree#removeSelectionPath(TreePath)
         */
        default S removeSelectionPath(final TreePath arg0) {
            return setup(result -> result.removeSelectionPath(arg0));
        }

        /**
         * @see JTree#removeSelectionPaths(TreePath[])
         */
        default S removeSelectionPaths(final javax.swing.tree.TreePath[] arg0) {
            return setup(result -> result.removeSelectionPaths(arg0));
        }

        /**
         * @see JTree#removeSelectionRow(int)
         */
        default S removeSelectionRow(final int arg0) {
            return setup(result -> result.removeSelectionRow(arg0));
        }

        /**
         * @see JTree#removeSelectionRows(int[])
         */
        default S removeSelectionRows(final int[] arg0) {
            return setup(result -> result.removeSelectionRows(arg0));
        }

        /**
         * @see JTree#setAnchorSelectionPath(TreePath)
         */
        default S setAnchorSelectionPath(final TreePath arg0) {
            return setup(result -> result.setAnchorSelectionPath(arg0));
        }

        /**
         * @see JTree#setCellEditor(TreeCellEditor)
         */
        default S setCellEditor(final TreeCellEditor arg0) {
            return setup(result -> result.setCellEditor(arg0));
        }

        /**
         * @see JTree#setCellRenderer(TreeCellRenderer)
         */
        default S setCellRenderer(final TreeCellRenderer arg0) {
            return setup(result -> result.setCellRenderer(arg0));
        }

        /**
         * @see JTree#setDragEnabled(boolean)
         */
        default S setDragEnabled(final boolean arg0) {
            return setup(result -> result.setDragEnabled(arg0));
        }

        /**
         * @see JTree#setDropMode(DropMode)
         */
        default S setDropMode(final DropMode arg0) {
            return setup(result -> result.setDropMode(arg0));
        }

        /**
         * @see JTree#setEditable(boolean)
         */
        default S setEditable(final boolean arg0) {
            return setup(result -> result.setEditable(arg0));
        }

        /**
         * @see JTree#setExpandsSelectedPaths(boolean)
         */
        default S setExpandsSelectedPaths(final boolean arg0) {
            return setup(result -> result.setExpandsSelectedPaths(arg0));
        }

        /**
         * @see JTree#setInvokesStopCellEditing(boolean)
         */
        default S setInvokesStopCellEditing(final boolean arg0) {
            return setup(result -> result.setInvokesStopCellEditing(arg0));
        }

        /**
         * @see JTree#setLargeModel(boolean)
         */
        default S setLargeModel(final boolean arg0) {
            return setup(result -> result.setLargeModel(arg0));
        }

        /**
         * @see JTree#setLeadSelectionPath(TreePath)
         */
        default S setLeadSelectionPath(final TreePath arg0) {
            return setup(result -> result.setLeadSelectionPath(arg0));
        }

        /**
         * @see JTree#setModel(TreeModel)
         */
        default S setModel(final TreeModel arg0) {
            return setup(result -> result.setModel(arg0));
        }

        /**
         * @see JTree#setRootVisible(boolean)
         */
        default S setRootVisible(final boolean arg0) {
            return setup(result -> result.setRootVisible(arg0));
        }

        /**
         * @see JTree#setRowHeight(int)
         */
        default S setRowHeight(final int arg0) {
            return setup(result -> result.setRowHeight(arg0));
        }

        /**
         * @see JTree#setScrollsOnExpand(boolean)
         */
        default S setScrollsOnExpand(final boolean arg0) {
            return setup(result -> result.setScrollsOnExpand(arg0));
        }

        /**
         * @see JTree#setSelectionInterval(int, int)
         */
        default S setSelectionInterval(final int arg0, final int arg1) {
            return setup(result -> result.setSelectionInterval(arg0, arg1));
        }

        /**
         * @see JTree#setSelectionModel(TreeSelectionModel)
         */
        default S setSelectionModel(final TreeSelectionModel arg0) {
            return setup(result -> result.setSelectionModel(arg0));
        }

        /**
         * @see JTree#setSelectionPath(TreePath)
         */
        default S setSelectionPath(final TreePath arg0) {
            return setup(result -> result.setSelectionPath(arg0));
        }

        /**
         * @see JTree#setSelectionPaths(TreePath[])
         */
        default S setSelectionPaths(final javax.swing.tree.TreePath[] arg0) {
            return setup(result -> result.setSelectionPaths(arg0));
        }

        /**
         * @see JTree#setSelectionRow(int)
         */
        default S setSelectionRow(final int arg0) {
            return setup(result -> result.setSelectionRow(arg0));
        }

        /**
         * @see JTree#setSelectionRows(int[])
         */
        default S setSelectionRows(final int[] arg0) {
            return setup(result -> result.setSelectionRows(arg0));
        }

        /**
         * @see JTree#setShowsRootHandles(boolean)
         */
        default S setShowsRootHandles(final boolean arg0) {
            return setup(result -> result.setShowsRootHandles(arg0));
        }

        /**
         * @see JTree#setToggleClickCount(int)
         */
        default S setToggleClickCount(final int arg0) {
            return setup(result -> result.setToggleClickCount(arg0));
        }

        /**
         * @see JTree#setUI(TreeUI)
         */
        default S setUI(final TreeUI arg0) {
            return setup(result -> result.setUI(arg0));
        }

        /**
         * @see JTree#setVisibleRowCount(int)
         */
        default S setVisibleRowCount(final int arg0) {
            return setup(result -> result.setVisibleRowCount(arg0));
        }
    }
}
