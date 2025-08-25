package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import javax.swing.plaf.TreeUI;
import javax.swing.tree.*;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JTree}s.
 */
@SuppressWarnings("unused")
public final class JTrees {

    private JTrees() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JTree}.
     *
     * @see #builder(Supplier)
     * @see JTree#JTree()
     */
    public static Builder<JTree> builder() {
        return new Builder<>(JTree::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JTree}.
     *
     * @see #builder(Supplier)
     * @see JTree#JTree(TreeNode)
     */
    public static Builder<JTree> builder(final TreeNode node) {
        return new Builder<>(() -> new JTree(node), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JTree}.
     *
     * @see #builder(Supplier)
     * @see JTree#JTree(TreeNode, boolean)
     */
    public static Builder<JTree> builder(final TreeNode node, final boolean asksAllowsChildren) {
        return new Builder<>(() -> new JTree(node, asksAllowsChildren), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JTree}.
     *
     * @see #builder(Supplier)
     * @see JTree#JTree(TreeModel)
     */
    public static Builder<JTree> builder(final TreeModel model) {
        return new Builder<>(() -> new JTree(model), Builder.class);
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
     * Returns a new {@link Setup} for a given {@link JTree} instance.
     */
    public static Setup<JTree, ?> setup(final JTree target) {
        return charger(target);
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
        default S addSelectionInterval(final int firstIndex, final int lastIndex) {
            return setup(result -> result.addSelectionInterval(firstIndex, lastIndex));
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
        default S addSelectionPaths(final TreePath[] paths) {
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
        default S removeSelectionInterval(final int firstIndex, final int lastIndex) {
            return setup(result -> result.removeSelectionInterval(firstIndex, lastIndex));
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
        default S removeSelectionPaths(final TreePath[] paths) {
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
        default S setAnchorSelectionPath(final TreePath path) {
            return setup(result -> result.setAnchorSelectionPath(path));
        }

        /**
         * @see JTree#setCellEditor(TreeCellEditor)
         */
        default S setCellEditor(final TreeCellEditor editor) {
            return setup(result -> result.setCellEditor(editor));
        }

        /**
         * @see JTree#setCellRenderer(TreeCellRenderer)
         */
        default S setCellRenderer(final TreeCellRenderer renderer) {
            return setup(result -> result.setCellRenderer(renderer));
        }

        /**
         * @see JTree#setDragEnabled(boolean)
         */
        default S setDragEnabled(final boolean enabled) {
            return setup(result -> result.setDragEnabled(enabled));
        }

        /**
         * @see JTree#setDropMode(DropMode)
         */
        default S setDropMode(final DropMode mode) {
            return setup(result -> result.setDropMode(mode));
        }

        /**
         * @see JTree#setEditable(boolean)
         */
        default S setEditable(final boolean editable) {
            return setup(result -> result.setEditable(editable));
        }

        /**
         * @see JTree#setExpandsSelectedPaths(boolean)
         */
        default S setExpandsSelectedPaths(final boolean expands) {
            return setup(result -> result.setExpandsSelectedPaths(expands));
        }

        /**
         * @see JTree#setInvokesStopCellEditing(boolean)
         */
        default S setInvokesStopCellEditing(final boolean invokes) {
            return setup(result -> result.setInvokesStopCellEditing(invokes));
        }

        /**
         * @see JTree#setLargeModel(boolean)
         */
        default S setLargeModel(final boolean large) {
            return setup(result -> result.setLargeModel(large));
        }

        /**
         * @see JTree#setLeadSelectionPath(TreePath)
         */
        default S setLeadSelectionPath(final TreePath path) {
            return setup(result -> result.setLeadSelectionPath(path));
        }

        /**
         * @see JTree#setModel(TreeModel)
         */
        default S setModel(final TreeModel model) {
            return setup(result -> result.setModel(model));
        }

        /**
         * @see JTree#setRootVisible(boolean)
         */
        default S setRootVisible(final boolean visible) {
            return setup(result -> result.setRootVisible(visible));
        }

        /**
         * @see JTree#setRowHeight(int)
         */
        default S setRowHeight(final int height) {
            return setup(result -> result.setRowHeight(height));
        }

        /**
         * @see JTree#setScrollsOnExpand(boolean)
         */
        default S setScrollsOnExpand(final boolean scrolls) {
            return setup(result -> result.setScrollsOnExpand(scrolls));
        }

        /**
         * @see JTree#setSelectionInterval(int, int)
         */
        default S setSelectionInterval(final int firstIndex, final int lastIndex) {
            return setup(result -> result.setSelectionInterval(firstIndex, lastIndex));
        }

        /**
         * @see JTree#setSelectionModel(TreeSelectionModel)
         */
        default S setSelectionModel(final TreeSelectionModel model) {
            return setup(result -> result.setSelectionModel(model));
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
        default S setSelectionPaths(final TreePath[] paths) {
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
        default S setShowsRootHandles(final boolean show) {
            return setup(result -> result.setShowsRootHandles(show));
        }

        /**
         * @see JTree#setToggleClickCount(int)
         */
        default S setToggleClickCount(final int count) {
            return setup(result -> result.setToggleClickCount(count));
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
        default S setVisibleRowCount(final int count) {
            return setup(result -> result.setVisibleRowCount(count));
        }
    }

    /**
     * Builder implementation to build target instances of {@link JTree}.
     *
     * @param <T> The final type of the target instances, at least {@link JTree}.
     */
    public static final class Builder<T extends JTree>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings("unchecked")
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

        @SuppressWarnings("unchecked")
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }
}
