package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import javax.swing.plaf.MenuItemUI;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JMenuItem}s.
 */
@SuppressWarnings("unused")
public final class JMenuItems {

    private JMenuItems() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JMenuItem}.
     */
    public static Builder<JMenuItem> builder() {
        return new Builder<>(JMenuItem::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JMenuItem}.
     */
    public static <T extends JMenuItem> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JMenuItem}.
     */
    public static <T extends JMenuItem> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Returns a new {@link Setup} for a given {@link JMenuItem} instance.
     */
    public static Setup<JMenuItem, ?> setup(final JMenuItem target) {
        return charger(target);
    }

    /**
     * Builder implementation to build target instances of {@link JMenuItem}.
     * 
     * @param <T> The final type of the target instances, at least {@link JMenuItem}.
     */
    public static final class Builder<T extends JMenuItem>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JMenuItem}.
     * 
     * @param <T> The final type of the target instance, at least {@link JMenuItem}.
     */
    public static final class Charger<T extends JMenuItem>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings("unchecked")
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JMenuItem}.
     * 
     * @param <T> The final type of the target instance, at least {@link JMenuItem}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JMenuItem, S extends Setup<T, S>> extends AbstractButtons.Setup<T, S> {

        /**
         * @see JMenuItem#setAccelerator(KeyStroke)
         */
        default S setAccelerator(final KeyStroke arg0) {
            return setup(result -> result.setAccelerator(arg0));
        }

        /**
         * @see JMenuItem#setArmed(boolean)
         */
        default S setArmed(final boolean arg0) {
            return setup(result -> result.setArmed(arg0));
        }

        /**
         * @see JMenuItem#setUI(MenuItemUI)
         */
        default S setUI(final MenuItemUI arg0) {
            return setup(result -> result.setUI(arg0));
        }
    }
}
