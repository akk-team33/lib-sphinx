package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Component;
import java.awt.Container;
import java.util.function.Supplier;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JRootPane;
import javax.swing.plaf.RootPaneUI;

/**
 * Utility class to handle {@link JRootPane}s.
 */
@SuppressWarnings("unused")
public final class JRootPanes {

    private JRootPanes() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JRootPane}.
     */
    public static Builder<JRootPane> builder() {
        return new Builder<>(JRootPane::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JRootPane}.
     */
    public static <T extends JRootPane> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JRootPane}.
     */
    public static <T extends JRootPane> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link JRootPane}.
     * 
     * @param <T> The final type of the target instances, at least {@link JRootPane}.
     */
    public static final class Builder<T extends JRootPane>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JRootPane}.
     * 
     * @param <T> The final type of the target instance, at least {@link JRootPane}.
     */
    public static final class Charger<T extends JRootPane>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JRootPane}.
     * 
     * @param <T> The final type of the target instance, at least {@link JRootPane}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JRootPane, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JRootPane#setContentPane(Container)
         */
        default S setContentPane(final Container arg0) {
            return setup(result -> result.setContentPane(arg0));
        }

        /**
         * @see JRootPane#setDefaultButton(JButton)
         */
        default S setDefaultButton(final JButton arg0) {
            return setup(result -> result.setDefaultButton(arg0));
        }

        /**
         * @see JRootPane#setGlassPane(Component)
         */
        default S setGlassPane(final Component arg0) {
            return setup(result -> result.setGlassPane(arg0));
        }

        /**
         * @see JRootPane#setJMenuBar(JMenuBar)
         */
        default S setJMenuBar(final JMenuBar arg0) {
            return setup(result -> result.setJMenuBar(arg0));
        }

        /**
         * @see JRootPane#setLayeredPane(JLayeredPane)
         */
        default S setLayeredPane(final JLayeredPane arg0) {
            return setup(result -> result.setLayeredPane(arg0));
        }

        /**
         * @see JRootPane#setUI(RootPaneUI)
         */
        default S setUI(final RootPaneUI arg0) {
            return setup(result -> result.setUI(arg0));
        }

        /**
         * @see JRootPane#setWindowDecorationStyle(int)
         */
        default S setWindowDecorationStyle(final int arg0) {
            return setup(result -> result.setWindowDecorationStyle(arg0));
        }
    }
}
