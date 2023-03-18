package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JRootPane;
import javax.swing.plaf.RootPaneUI;

/**
 * Utility class to handle {@link JRootPane}s.
 */
public final class JRootPanes {

    /**
     * Returns a new {@link Builder} for target instances of type {@link JRootPane}.
     */
    public static Builder<JRootPane, ?> builder() {
        return new Builder<>(JRootPane::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JRootPane}.
     */
    public static <T extends JRootPane> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JRootPane}.
     * 
     * @param <T> The final type of the target instances, at least {@link JRootPane}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JRootPane, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JRootPane}.
     * 
     * @param <T> The final type of the target instance, at least {@link JRootPane}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JRootPane, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JRootPane#setDefaultButton(JButton)
         */
        default S setDefaultButton(final JButton arg0) {
            return setup(result -> result.setDefaultButton(arg0));
        }

        /**
         * @see JRootPane#setWindowDecorationStyle(int)
         */
        default S setWindowDecorationStyle(final int arg0) {
            return setup(result -> result.setWindowDecorationStyle(arg0));
        }

        /**
         * @see JRootPane#setJMenuBar(JMenuBar)
         */
        default S setJMenuBar(final JMenuBar arg0) {
            return setup(result -> result.setJMenuBar(arg0));
        }

        /**
         * @see JRootPane#setContentPane(Container)
         */
        default S setContentPane(final Container arg0) {
            return setup(result -> result.setContentPane(arg0));
        }

        /**
         * @see JRootPane#setLayeredPane(JLayeredPane)
         */
        default S setLayeredPane(final JLayeredPane arg0) {
            return setup(result -> result.setLayeredPane(arg0));
        }

        /**
         * @see JRootPane#setGlassPane(Component)
         */
        default S setGlassPane(final Component arg0) {
            return setup(result -> result.setGlassPane(arg0));
        }

        /**
         * @see JRootPane#setMenuBar(JMenuBar)
         */
        default S setMenuBar(final JMenuBar arg0) {
            return setup(result -> result.setMenuBar(arg0));
        }

        /**
         * @see JRootPane#setUI(RootPaneUI)
         */
        default S setUI(final RootPaneUI arg0) {
            return setup(result -> result.setUI(arg0));
        }

        /**
         * @see JRootPane#addNotify()
         */
        default S addNotify() {
            return setup(result -> result.addNotify());
        }

        /**
         * @see JRootPane#removeNotify()
         */
        default S removeNotify() {
            return setup(result -> result.removeNotify());
        }

        /**
         * @see JRootPane#setDoubleBuffered(boolean)
         */
        default S setDoubleBuffered(final boolean arg0) {
            return setup(result -> result.setDoubleBuffered(arg0));
        }
    }
}
