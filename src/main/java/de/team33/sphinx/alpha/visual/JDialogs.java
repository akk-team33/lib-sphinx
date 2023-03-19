package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.LayoutManager;
import java.util.function.Supplier;
import javax.swing.JDialog;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.TransferHandler;

/**
 * Utility class to handle {@link JDialog}s.
 */
@SuppressWarnings("unused")
public final class JDialogs {

    private JDialogs() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JDialog}.
     */
    public static Builder<JDialog, ?> builder() {
        return new Builder<>(JDialog::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JDialog}.
     */
    public static <T extends JDialog> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JDialog}.
     * 
     * @param <T> The final type of the target instances, at least {@link JDialog}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JDialog, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JDialog}.
     * 
     * @param <T> The final type of the target instance, at least {@link JDialog}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JDialog, S extends Setup<T, S>> extends Dialogs.Setup<T, S> {

        /**
         * @see JDialog#remove(Component)
         */
        default S remove(final Component arg0) {
            return setup(result -> result.remove(arg0));
        }

        /**
         * @see JDialog#setContentPane(Container)
         */
        default S setContentPane(final Container arg0) {
            return setup(result -> result.setContentPane(arg0));
        }

        /**
         * @see JDialog#setDefaultCloseOperation(int)
         */
        default S setDefaultCloseOperation(final int arg0) {
            return setup(result -> result.setDefaultCloseOperation(arg0));
        }

        /**
         * @see JDialog#setGlassPane(Component)
         */
        default S setGlassPane(final Component arg0) {
            return setup(result -> result.setGlassPane(arg0));
        }

        /**
         * @see JDialog#setJMenuBar(JMenuBar)
         */
        default S setJMenuBar(final JMenuBar arg0) {
            return setup(result -> result.setJMenuBar(arg0));
        }

        /**
         * @see JDialog#setLayeredPane(JLayeredPane)
         */
        default S setLayeredPane(final JLayeredPane arg0) {
            return setup(result -> result.setLayeredPane(arg0));
        }

        /**
         * @see JDialog#setLayout(LayoutManager)
         */
        default S setLayout(final LayoutManager arg0) {
            return setup(result -> result.setLayout(arg0));
        }

        /**
         * @see JDialog#setTransferHandler(TransferHandler)
         */
        default S setTransferHandler(final TransferHandler arg0) {
            return setup(result -> result.setTransferHandler(arg0));
        }
    }
}
