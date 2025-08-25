package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JTableHeader}s.
 */
@SuppressWarnings("unused")
public final class JTableHeaders {

    private JTableHeaders() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JTableHeader}.
     */
    public static Builder<JTableHeader> builder() {
        return new Builder<>(JTableHeader::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTableHeader}.
     */
    public static <T extends JTableHeader> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JTableHeader}.
     */
    public static <T extends JTableHeader> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Returns a new {@link Setup} for a given {@link JTableHeader} instance.
     */
    public static Setup<JTableHeader, ?> setup(final JTableHeader target) {
        return charger(target);
    }

    /**
     * Utility interface to set up a target instance of {@link JTableHeader}.
     *
     * @param <T> The final type of the target instance, at least {@link JTableHeader}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JTableHeader, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JTableHeader#setColumnModel(TableColumnModel)
         */
        default S setColumnModel(final TableColumnModel model) {
            return setup(result -> result.setColumnModel(model));
        }

        /**
         * @see JTableHeader#setDefaultRenderer(TableCellRenderer)
         */
        default S setDefaultRenderer(final TableCellRenderer renderer) {
            return setup(result -> result.setDefaultRenderer(renderer));
        }

        /**
         * @see JTableHeader#setDraggedColumn(TableColumn)
         */
        default S setDraggedColumn(final TableColumn column) {
            return setup(result -> result.setDraggedColumn(column));
        }

        /**
         * @see JTableHeader#setDraggedDistance(int)
         */
        default S setDraggedDistance(final int distance) {
            return setup(result -> result.setDraggedDistance(distance));
        }

        /**
         * @see JTableHeader#setReorderingAllowed(boolean)
         */
        default S setReorderingAllowed(final boolean allowed) {
            return setup(result -> result.setReorderingAllowed(allowed));
        }

        /**
         * @see JTableHeader#setResizingAllowed(boolean)
         */
        default S setResizingAllowed(final boolean allowed) {
            return setup(result -> result.setResizingAllowed(allowed));
        }

        /**
         * @see JTableHeader#setResizingColumn(TableColumn)
         */
        default S setResizingColumn(final TableColumn column) {
            return setup(result -> result.setResizingColumn(column));
        }

        /**
         * @see JTableHeader#setTable(JTable)
         */
        default S setTable(final JTable table) {
            return setup(result -> result.setTable(table));
        }

        /**
         * @see JTableHeader#setUI(TableHeaderUI)
         */
        default S setUI(final TableHeaderUI ui) {
            return setup(result -> result.setUI(ui));
        }

        /**
         * @see JTableHeader#setUpdateTableInRealTime(boolean)
         */
        default S setUpdateTableInRealTime(final boolean updateInRealTime) {
            return setup(result -> result.setUpdateTableInRealTime(updateInRealTime));
        }
    }

    /**
     * Builder implementation to build target instances of {@link JTableHeader}.
     *
     * @param <T> The final type of the target instances, at least {@link JTableHeader}.
     */
    public static final class Builder<T extends JTableHeader>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JTableHeader}.
     *
     * @param <T> The final type of the target instance, at least {@link JTableHeader}.
     */
    public static final class Charger<T extends JTableHeader>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings("unchecked")
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }
}
