package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import javax.swing.plaf.PopupMenuUI;
import java.awt.*;
import java.util.function.Supplier;

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
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JPopupMenu}.
     */
    public static <T extends JPopupMenu> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Returns a new {@link Setup} for a given {@link JPopupMenu} instance.
     */
    public static Setup<JPopupMenu, ?> setup(final JPopupMenu target) {
        return charger(target);
    }

    /**
     * Utility interface to set up a target instance of {@link JPopupMenu}.
     *
     * @param <T> The final type of the target instance, at least {@link JPopupMenu}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JPopupMenu, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JPopupMenu#add(Action)
         */
        default S add(final Action action) {
            return setup(result -> result.add(action));
        }

        /**
         * @see JPopupMenu#add(JMenuItem)
         */
        default S add(final JMenuItem item) {
            return setup(result -> result.add(item));
        }

        /**
         * @see JPopupMenu#add(String)
         */
        default S add(final String itemText) {
            return setup(result -> result.add(itemText));
        }

        /**
         * @see JPopupMenu#addSeparator()
         */
        default S addSeparator() {
            return setup(JPopupMenu::addSeparator);
        }

        /**
         * @see JPopupMenu#setBorderPainted(boolean)
         */
        default S setBorderPainted(final boolean painted) {
            return setup(result -> result.setBorderPainted(painted));
        }

        /**
         * @see JPopupMenu#setInvoker(Component)
         */
        default S setInvoker(final Component component) {
            return setup(result -> result.setInvoker(component));
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
        default S setLightWeightPopupEnabled(final boolean enabled) {
            return setup(result -> result.setLightWeightPopupEnabled(enabled));
        }

        /**
         * @see JPopupMenu#setPopupSize(Dimension)
         */
        default S setPopupSize(final Dimension size) {
            return setup(result -> result.setPopupSize(size));
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
        default S setSelected(final Component component) {
            return setup(result -> result.setSelected(component));
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
    }

    /**
     * Builder implementation to build target instances of {@link JPopupMenu}.
     *
     * @param <T> The final type of the target instances, at least {@link JPopupMenu}.
     */
    public static final class Builder<T extends JPopupMenu>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JPopupMenu}.
     *
     * @param <T> The final type of the target instance, at least {@link JPopupMenu}.
     */
    public static final class Charger<T extends JPopupMenu>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings("unchecked")
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }
}
