package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.util.function.Supplier;
import javax.swing.Action;
import javax.swing.ButtonModel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Utility class to handle {@link JMenu}s.
 */
@SuppressWarnings("unused")
public final class JMenus {

    private JMenus() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JMenu}.
     */
    public static Builder<JMenu, ?> builder() {
        return new Builder<>(JMenu::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JMenu}.
     */
    public static <T extends JMenu> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JMenu}.
     * 
     * @param <T> The final type of the target instances, at least {@link JMenu}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JMenu, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JMenu}.
     * 
     * @param <T> The final type of the target instance, at least {@link JMenu}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JMenu, S extends Setup<T, S>> extends JMenuItems.Setup<T, S> {

        /**
         * @see JMenu#add(Action)
         */
        default S add(final Action arg0) {
            return setup(result -> result.add(arg0));
        }

        /**
         * @see JMenu#add(Component)
         */
        default S add(final Component arg0) {
            return setup(result -> result.add(arg0));
        }

        /**
         * @see JMenu#add(Component, int)
         */
        default S add(final Component arg0, final int arg1) {
            return setup(result -> result.add(arg0, arg1));
        }

        /**
         * @see JMenu#add(JMenuItem)
         */
        default S add(final JMenuItem arg0) {
            return setup(result -> result.add(arg0));
        }

        /**
         * @see JMenu#add(String)
         */
        default S add(final String arg0) {
            return setup(result -> result.add(arg0));
        }

        /**
         * @see JMenu#addSeparator()
         */
        default S addSeparator() {
            return setup(JMenu::addSeparator);
        }

        /**
         * @see JMenu#remove(Component)
         */
        default S remove(final Component arg0) {
            return setup(result -> result.remove(arg0));
        }

        /**
         * @see JMenu#remove(JMenuItem)
         */
        default S remove(final JMenuItem arg0) {
            return setup(result -> result.remove(arg0));
        }

        /**
         * @see JMenu#remove(int)
         */
        default S remove(final int arg0) {
            return setup(result -> result.remove(arg0));
        }

        /**
         * @see JMenu#removeAll()
         */
        default S removeAll() {
            return setup(JMenu::removeAll);
        }

        /**
         * @see JMenu#setAccelerator(KeyStroke)
         */
        default S setAccelerator(final KeyStroke arg0) {
            return setup(result -> result.setAccelerator(arg0));
        }

        /**
         * @see JMenu#setComponentOrientation(ComponentOrientation)
         */
        default S setComponentOrientation(final ComponentOrientation arg0) {
            return setup(result -> result.setComponentOrientation(arg0));
        }

        /**
         * @see JMenu#setDelay(int)
         */
        default S setDelay(final int arg0) {
            return setup(result -> result.setDelay(arg0));
        }

        /**
         * @see JMenu#setMenuLocation(int, int)
         */
        default S setMenuLocation(final int arg0, final int arg1) {
            return setup(result -> result.setMenuLocation(arg0, arg1));
        }

        /**
         * @see JMenu#setModel(ButtonModel)
         */
        default S setModel(final ButtonModel arg0) {
            return setup(result -> result.setModel(arg0));
        }

        /**
         * @see JMenu#setPopupMenuVisible(boolean)
         */
        default S setPopupMenuVisible(final boolean arg0) {
            return setup(result -> result.setPopupMenuVisible(arg0));
        }

        /**
         * @see JMenu#setSelected(boolean)
         */
        default S setSelected(final boolean arg0) {
            return setup(result -> result.setSelected(arg0));
        }
    }
}
