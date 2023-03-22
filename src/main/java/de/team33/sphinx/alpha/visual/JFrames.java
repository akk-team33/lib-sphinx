package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;

import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.LayoutManager;
import java.util.function.Supplier;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.TransferHandler;

/**
 * Utility class to handle {@link JFrame}s.
 */
@SuppressWarnings("unused")
public final class JFrames {

    private JFrames() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JFrame}.
     */
    public static Builder<JFrame, ?> builder() {
        return new Builder<>(JFrame::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JFrame}.
     */
    public static <T extends JFrame> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JFrame}.
     * 
     * @param <T> The final type of the target instances, at least {@link JFrame}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JFrame, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JFrame}.
     * 
     * @param <T> The final type of the target instance, at least {@link JFrame}.
     * @param <S> The final type of the Setup implementation.
     */
    @FunctionalInterface
    public interface Setup<T extends JFrame, S extends Setup<T, S>> extends Frames.Setup<T, S> {

        /**
         * @see JFrame#remove(Component)
         */
        default S remove(final Component comp) {
            return setup(result -> result.remove(comp));
        }

        /**
         * @see JFrame#setContentPane(Container)
         */
        default S setContentPane(final Container contentPane) {
            return setup(result -> result.setContentPane(contentPane));
        }

        /**
         * @see JFrame#setDefaultCloseOperation(int)
         */
        default S setDefaultCloseOperation(final int operation) {
            return setup(result -> result.setDefaultCloseOperation(operation));
        }

        /**
         * @see JFrame#setGlassPane(Component)
         */
        default S setGlassPane(final Component glassPane) {
            return setup(result -> result.setGlassPane(glassPane));
        }

        /**
         * @see JFrame#setIconImage(Image)
         */
        default S setIconImage(final Image image) {
            return setup(result -> result.setIconImage(image));
        }

        /**
         * @see JFrame#setJMenuBar(JMenuBar)
         */
        default S setJMenuBar(final JMenuBar menubar) {
            return setup(result -> result.setJMenuBar(menubar));
        }

        /**
         * @see JFrame#setLayeredPane(JLayeredPane)
         */
        default S setLayeredPane(final JLayeredPane layeredPane) {
            return setup(result -> result.setLayeredPane(layeredPane));
        }

        /**
         * @see JFrame#setLayout(LayoutManager)
         */
        default S setLayout(final LayoutManager manager) {
            return setup(result -> result.setLayout(manager));
        }

        /**
         * @see JFrame#setTransferHandler(TransferHandler)
         */
        default S setTransferHandler(final TransferHandler newHandler) {
            return setup(result -> result.setTransferHandler(newHandler));
        }
    }
}
