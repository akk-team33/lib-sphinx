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
    public static Builder<JWindow> builder() {
        return new Builder<>(JWindow::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JWindow}.
     */
    public static <T extends JWindow> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JWindow}.
     * 
     * @param <T> The final type of the target instances, at least {@link JWindow}.
     */
    public static final class Builder<T extends JWindow>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JWindow}.
     * 
     * @param <T> The final type of the target instance, at least {@link JWindow}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JWindow, S extends Setup<T, S>> extends Windows.Setup<T, S> {

        /**
         * @see JWindow#remove(Component)
         */
        default S remove(final Component arg0) {
            return setup(result -> result.remove(arg0));
        }

        /**
         * @see JWindow#setContentPane(Container)
         */
        default S setContentPane(final Container arg0) {
            return setup(result -> result.setContentPane(arg0));
        }

        /**
         * @see JWindow#setGlassPane(Component)
         */
        default S setGlassPane(final Component arg0) {
            return setup(result -> result.setGlassPane(arg0));
        }

        /**
         * @see JWindow#setLayeredPane(JLayeredPane)
         */
        default S setLayeredPane(final JLayeredPane arg0) {
            return setup(result -> result.setLayeredPane(arg0));
        }

        /**
         * @see JWindow#setLayout(LayoutManager)
         */
        default S setLayout(final LayoutManager arg0) {
            return setup(result -> result.setLayout(arg0));
        }

        /**
         * @see JWindow#setTransferHandler(TransferHandler)
         */
        default S setTransferHandler(final TransferHandler arg0) {
            return setup(result -> result.setTransferHandler(arg0));
        }
    }
}
