package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

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
    public static Builder<JMenu> builder() {
        return new Builder<>(JMenu::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JMenu}.
     */
    public static <T extends JMenu> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JMenu}.
     */
    public static <T extends JMenu> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link JMenu}.
     * 
     * @param <T> The final type of the target instances, at least {@link JMenu}.
     */
    public static final class Builder<T extends JMenu>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JMenu}.
     * 
     * @param <T> The final type of the target instance, at least {@link JMenu}.
     */
    public static final class Charger<T extends JMenu>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JMenu}.
     * 
     * @param <T> The final type of the target instance, at least {@link JMenu}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JMenu, S extends Setup<T, S>> extends JMenuItems.Setup<T, S> {

        /**
         * @see JMenu#add(Action)
         */
        default S add(final Action arg0) {
            return setup(result -> result.add(arg0));
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
            return setup(result -> result.addSeparator());
        }

        /**
         * @see JMenu#remove(JMenuItem)
         */
        default S remove(final JMenuItem arg0) {
            return setup(result -> result.remove(arg0));
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
         * @see JMenu#setPopupMenuVisible(boolean)
         */
        default S setPopupMenuVisible(final boolean arg0) {
            return setup(result -> result.setPopupMenuVisible(arg0));
        }
    }
}
