package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Component;
import java.awt.Dimension;
import java.util.function.Supplier;
import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SingleSelectionModel;
import javax.swing.plaf.PopupMenuUI;

/**
 * Utility class to handle {@link JPopupMenu}s.
 */
@SuppressWarnings("unused")
public final class JPopupMenus {

    private JPopupMenus() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JPopupMenu}.
     */
    public static Builder<JPopupMenu> builder() {
        return new Builder<>(JPopupMenu::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JPopupMenu}.
     */
    public static <T extends JPopupMenu> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JPopupMenu}.
     * 
     * @param <T> The final type of the target instances, at least {@link JPopupMenu}.
     */
    public static final class Builder<T extends JPopupMenu>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JPopupMenu}.
     * 
     * @param <T> The final type of the target instance, at least {@link JPopupMenu}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings({"ClassNameSameAsAncestorName", "MethodOverloadsMethodOfSuperclass"})
    @FunctionalInterface
    public interface Setup<T extends JPopupMenu, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JPopupMenu#add(Action)
         */
        default S add(final Action arg0) {
            return setup(result -> result.add(arg0));
        }

        /**
         * @see JPopupMenu#add(JMenuItem)
         */
        default S add(final JMenuItem arg0) {
            return setup(result -> result.add(arg0));
        }

        /**
         * @see JPopupMenu#add(String)
         */
        default S add(final String arg0) {
            return setup(result -> result.add(arg0));
        }

        /**
         * @see JPopupMenu#addSeparator()
         */
        default S addSeparator() {
            return setup(JPopupMenu::addSeparator);
        }

        /**
         * @see JPopupMenu#remove(int)
         */
        default S remove(final int arg0) {
            return setup(result -> result.remove(arg0));
        }

        /**
         * @see JPopupMenu#setBorderPainted(boolean)
         */
        default S setBorderPainted(final boolean arg0) {
            return setup(result -> result.setBorderPainted(arg0));
        }

        /**
         * @see JPopupMenu#setInvoker(Component)
         */
        default S setInvoker(final Component arg0) {
            return setup(result -> result.setInvoker(arg0));
        }

        /**
         * @see JPopupMenu#setLabel(String)
         */
        default S setLabel(final String arg0) {
            return setup(result -> result.setLabel(arg0));
        }

        /**
         * @see JPopupMenu#setLightWeightPopupEnabled(boolean)
         */
        default S setLightWeightPopupEnabled(final boolean arg0) {
            return setup(result -> result.setLightWeightPopupEnabled(arg0));
        }

        /**
         * @see JPopupMenu#setLocation(int, int)
         */
        default S setLocation(final int arg0, final int arg1) {
            return setup(result -> result.setLocation(arg0, arg1));
        }

        /**
         * @see JPopupMenu#setPopupSize(Dimension)
         */
        default S setPopupSize(final Dimension arg0) {
            return setup(result -> result.setPopupSize(arg0));
        }

        /**
         * @see JPopupMenu#setPopupSize(int, int)
         */
        default S setPopupSize(final int arg0, final int arg1) {
            return setup(result -> result.setPopupSize(arg0, arg1));
        }

        /**
         * @see JPopupMenu#setSelected(Component)
         */
        default S setSelected(final Component arg0) {
            return setup(result -> result.setSelected(arg0));
        }

        /**
         * @see JPopupMenu#setSelectionModel(SingleSelectionModel)
         */
        default S setSelectionModel(final SingleSelectionModel arg0) {
            return setup(result -> result.setSelectionModel(arg0));
        }

        /**
         * @see JPopupMenu#setUI(PopupMenuUI)
         */
        default S setUI(final PopupMenuUI arg0) {
            return setup(result -> result.setUI(arg0));
        }

        /**
         * @see JPopupMenu#setVisible(boolean)
         */
        default S setVisible(final boolean arg0) {
            return setup(result -> result.setVisible(arg0));
        }
    }
}
