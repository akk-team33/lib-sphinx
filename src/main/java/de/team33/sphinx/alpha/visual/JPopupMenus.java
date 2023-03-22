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
    public static Builder<JPopupMenu, ?> builder() {
        return new Builder<>(JPopupMenu::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JPopupMenu}.
     */
    public static <T extends JPopupMenu> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JPopupMenu}.
     * 
     * @param <T> The final type of the target instances, at least {@link JPopupMenu}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JPopupMenu, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JPopupMenu}.
     * 
     * @param <T> The final type of the target instance, at least {@link JPopupMenu}.
     * @param <S> The final type of the Setup implementation.
     */
    @FunctionalInterface
    public interface Setup<T extends JPopupMenu, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JPopupMenu#add(Action)
         */
        default S add(final Action a) {
            return setup(result -> result.add(a));
        }

        /**
         * @see JPopupMenu#add(JMenuItem)
         */
        default S add(final JMenuItem menuItem) {
            return setup(result -> result.add(menuItem));
        }

        /**
         * @see JPopupMenu#add(String)
         */
        default S add(final String s) {
            return setup(result -> result.add(s));
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
        default S remove(final int pos) {
            return setup(result -> result.remove(pos));
        }

        /**
         * @see JPopupMenu#setBorderPainted(boolean)
         */
        default S setBorderPainted(final boolean b) {
            return setup(result -> result.setBorderPainted(b));
        }

        /**
         * @see JPopupMenu#setInvoker(Component)
         */
        default S setInvoker(final Component invoker) {
            return setup(result -> result.setInvoker(invoker));
        }

        /**
         * @see JPopupMenu#setLabel(String)
         */
        default S setLabel(final String label) {
            return setup(result -> result.setLabel(label));
        }

        /**
         * @see JPopupMenu#setLightWeightPopupEnabled(boolean)
         */
        default S setLightWeightPopupEnabled(final boolean aFlag) {
            return setup(result -> result.setLightWeightPopupEnabled(aFlag));
        }

        /**
         * @see JPopupMenu#setLocation(int, int)
         */
        default S setLocation(final int x, final int y) {
            return setup(result -> result.setLocation(x, y));
        }

        /**
         * @see JPopupMenu#setPopupSize(Dimension)
         */
        default S setPopupSize(final Dimension d) {
            return setup(result -> result.setPopupSize(d));
        }

        /**
         * @see JPopupMenu#setPopupSize(int, int)
         */
        default S setPopupSize(final int width, final int height) {
            return setup(result -> result.setPopupSize(width, height));
        }

        /**
         * @see JPopupMenu#setSelected(Component)
         */
        default S setSelected(final Component sel) {
            return setup(result -> result.setSelected(sel));
        }

        /**
         * @see JPopupMenu#setSelectionModel(SingleSelectionModel)
         */
        default S setSelectionModel(final SingleSelectionModel model) {
            return setup(result -> result.setSelectionModel(model));
        }

        /**
         * @see JPopupMenu#setUI(PopupMenuUI)
         */
        default S setUI(final PopupMenuUI ui) {
            return setup(result -> result.setUI(ui));
        }

        /**
         * @see JPopupMenu#setVisible(boolean)
         */
        default S setVisible(final boolean b) {
            return setup(result -> result.setVisible(b));
        }
    }
}
