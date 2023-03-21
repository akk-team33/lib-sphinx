package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;
import java.util.function.Supplier;
import javax.swing.JLayeredPane;
import javax.swing.JWindow;
import javax.swing.TransferHandler;

/**
 * Utility class to handle {@link JWindow}s.
 */
@SuppressWarnings("unused")
public final class JWindows {

    private JWindows() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JWindow}.
     */
    public static Builder<JWindow, ?> builder() {
        return new Builder<>(JWindow::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JWindow}.
     */
    public static <T extends JWindow> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JWindow}.
     * 
     * @param <T> The final type of the target instances, at least {@link JWindow}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JWindow, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JWindow}.
     * 
     * @param <T> The final type of the target instance, at least {@link JWindow}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JWindow, S extends Setup<T, S>> extends Windows.Setup<T, S> {

        /**
         * @see JWindow#remove(Component)
         */
        default S remove(final Component comp) {
            return setup(result -> result.remove(comp));
        }

        /**
         * @see JWindow#setContentPane(Container)
         */
        default S setContentPane(final Container contentPane) {
            return setup(result -> result.setContentPane(contentPane));
        }

        /**
         * @see JWindow#setGlassPane(Component)
         */
        default S setGlassPane(final Component glassPane) {
            return setup(result -> result.setGlassPane(glassPane));
        }

        /**
         * @see JWindow#setLayeredPane(JLayeredPane)
         */
        default S setLayeredPane(final JLayeredPane layeredPane) {
            return setup(result -> result.setLayeredPane(layeredPane));
        }

        /**
         * @see JWindow#setLayout(LayoutManager)
         */
        default S setLayout(final LayoutManager manager) {
            return setup(result -> result.setLayout(manager));
        }

        /**
         * @see JWindow#setTransferHandler(TransferHandler)
         */
        default S setTransferHandler(final TransferHandler newHandler) {
            return setup(result -> result.setTransferHandler(newHandler));
        }
    }
}
