package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

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
    public static Builder<JTableHeader, ?> builder() {
        return new Builder<>(JTableHeader::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTableHeader}.
     */
    public static <T extends JTableHeader> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JTableHeader}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTableHeader}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JTableHeader, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JTableHeader}.
     * 
     * @param <T> The final type of the target instance, at least {@link JTableHeader}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JTableHeader, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JTableHeader#setColumnModel(TableColumnModel)
         */
        default S setColumnModel(final TableColumnModel arg0) {
            return setup(result -> result.setColumnModel(arg0));
        }

        /**
         * @see JTableHeader#setDefaultRenderer(TableCellRenderer)
         */
        default S setDefaultRenderer(final TableCellRenderer arg0) {
            return setup(result -> result.setDefaultRenderer(arg0));
        }

        /**
         * @see JTableHeader#setDraggedColumn(TableColumn)
         */
        default S setDraggedColumn(final TableColumn arg0) {
            return setup(result -> result.setDraggedColumn(arg0));
        }

        /**
         * @see JTableHeader#setDraggedDistance(int)
         */
        default S setDraggedDistance(final int arg0) {
            return setup(result -> result.setDraggedDistance(arg0));
        }

        /**
         * @see JTableHeader#setReorderingAllowed(boolean)
         */
        default S setReorderingAllowed(final boolean arg0) {
            return setup(result -> result.setReorderingAllowed(arg0));
        }

        /**
         * @see JTableHeader#setResizingAllowed(boolean)
         */
        default S setResizingAllowed(final boolean arg0) {
            return setup(result -> result.setResizingAllowed(arg0));
        }

        /**
         * @see JTableHeader#setResizingColumn(TableColumn)
         */
        default S setResizingColumn(final TableColumn arg0) {
            return setup(result -> result.setResizingColumn(arg0));
        }

        /**
         * @see JTableHeader#setTable(JTable)
         */
        default S setTable(final JTable arg0) {
            return setup(result -> result.setTable(arg0));
        }

        /**
         * @see JTableHeader#setUI(TableHeaderUI)
         */
        default S setUI(final TableHeaderUI arg0) {
            return setup(result -> result.setUI(arg0));
        }

        /**
         * @see JTableHeader#setUpdateTableInRealTime(boolean)
         */
        default S setUpdateTableInRealTime(final boolean arg0) {
            return setup(result -> result.setUpdateTableInRealTime(arg0));
        }
    }
}
