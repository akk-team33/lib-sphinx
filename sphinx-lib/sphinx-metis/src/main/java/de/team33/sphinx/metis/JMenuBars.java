package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import javax.swing.plaf.MenuBarUI;
import java.awt.*;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JMenuBar}s.
 */
@SuppressWarnings("unused")
public final class JMenuBars {

    private JMenuBars() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JMenuBar}.
     */
    public static Builder<JMenuBar> builder() {
        return new Builder<>(JMenuBar::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JMenuBar}.
     */
    public static <T extends JMenuBar> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JMenuBar}.
     */
    public static <T extends JMenuBar> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link JMenuBar}.
     * 
     * @param <T> The final type of the target instances, at least {@link JMenuBar}.
     */
    public static final class Builder<T extends JMenuBar>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JMenuBar}.
     * 
     * @param <T> The final type of the target instance, at least {@link JMenuBar}.
     */
    public static final class Charger<T extends JMenuBar>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JMenuBar}.
     * 
     * @param <T> The final type of the target instance, at least {@link JMenuBar}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JMenuBar, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JMenuBar#add(JMenu)
         */
        default S add(final JMenu arg0) {
            return setup(result -> result.add(arg0));
        }

        /**
         * @see JMenuBar#setBorderPainted(boolean)
         */
        default S setBorderPainted(final boolean arg0) {
            return setup(result -> result.setBorderPainted(arg0));
        }

        /**
         * @see JMenuBar#setHelpMenu(JMenu)
         */
        default S setHelpMenu(final JMenu arg0) {
            return setup(result -> result.setHelpMenu(arg0));
        }

        /**
         * @see JMenuBar#setMargin(Insets)
         */
        default S setMargin(final Insets arg0) {
            return setup(result -> result.setMargin(arg0));
        }

        /**
         * @see JMenuBar#setSelected(Component)
         */
        default S setSelected(final Component arg0) {
            return setup(result -> result.setSelected(arg0));
        }

        /**
         * @see JMenuBar#setSelectionModel(SingleSelectionModel)
         */
        default S setSelectionModel(final SingleSelectionModel arg0) {
            return setup(result -> result.setSelectionModel(arg0));
        }

        /**
         * @see JMenuBar#setUI(MenuBarUI)
         */
        default S setUI(final MenuBarUI arg0) {
            return setup(result -> result.setUI(arg0));
        }
    }
}
