package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;

import java.awt.Component;
import javax.swing.DesktopManager;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.plaf.DesktopPaneUI;

/**
 * Utility class to handle {@link JDesktopPane}s.
 */
public final class JDesktopPanes {

    /**
     * Returns a new {@link Builder} for target instances of type {@link JDesktopPane}.
     */
    public static Builder<JDesktopPane, ?> builder() {
        return new Builder<>(JDesktopPane::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JDesktopPane}.
     */
    public static <T extends JDesktopPane> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JDesktopPane}.
     * 
     * @param <T> The final type of the target instances, at least {@link JDesktopPane}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JDesktopPane, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JDesktopPane}.
     * 
     * @param <T> The final type of the target instance, at least {@link JDesktopPane}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JDesktopPane, S extends Setup<T, S>> extends JLayeredPanes.Setup<T, S> {

        /**
         * @see JDesktopPane#setUI(DesktopPaneUI)
         */
        default S setUI(final DesktopPaneUI arg0) {
            return setup(result -> result.setUI(arg0));
        }

        /**
         * @see JDesktopPane#remove(int)
         */
        default S remove(final int arg0) {
            return setup(result -> result.remove(arg0));
        }

        /**
         * @see JDesktopPane#remove(Component)
         */
        default S remove(final Component arg0) {
            return setup(result -> result.remove(arg0));
        }

        /**
         * @see JDesktopPane#removeAll()
         */
        default S removeAll() {
            return setup(result -> result.removeAll());
        }

        /**
         * @see JDesktopPane#setDragMode(int)
         */
        default S setDragMode(final int arg0) {
            return setup(result -> result.setDragMode(arg0));
        }

        /**
         * @see JDesktopPane#setDesktopManager(DesktopManager)
         */
        default S setDesktopManager(final DesktopManager arg0) {
            return setup(result -> result.setDesktopManager(arg0));
        }

        /**
         * @see JDesktopPane#setSelectedFrame(JInternalFrame)
         */
        default S setSelectedFrame(final JInternalFrame arg0) {
            return setup(result -> result.setSelectedFrame(arg0));
        }

        /**
         * @see JDesktopPane#setComponentZOrder(Component, int)
         */
        default S setComponentZOrder(final Component arg0, final int arg1) {
            return setup(result -> result.setComponentZOrder(arg0, arg1));
        }
    }
}
