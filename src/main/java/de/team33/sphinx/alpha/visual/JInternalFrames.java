package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import de.team33.patterns.exceptional.e1.Conversion;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.util.function.Supplier;
import javax.swing.Icon;
import javax.swing.JInternalFrame;
import javax.swing.JInternalFrame.JDesktopIcon;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.plaf.InternalFrameUI;

/**
 * Utility class to handle {@link JInternalFrame}s.
 */
@SuppressWarnings("unused")
public final class JInternalFrames {

    private JInternalFrames() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JInternalFrame}.
     */
    public static Builder<JInternalFrame, ?> builder() {
        return new Builder<>(JInternalFrame::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JInternalFrame}.
     */
    public static <T extends JInternalFrame> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JInternalFrame}.
     * 
     * @param <T> The final type of the target instances, at least {@link JInternalFrame}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JInternalFrame, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JInternalFrame}.
     * 
     * @param <T> The final type of the target instance, at least {@link JInternalFrame}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JInternalFrame, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JInternalFrame#remove(Component)
         */
        default S remove(final Component comp) {
            return setup(result -> result.remove(comp));
        }

        /**
         * @see JInternalFrame#setClosable(boolean)
         */
        default S setClosable(final boolean b) {
            return setup(result -> result.setClosable(b));
        }

        /**
         * @see JInternalFrame#setClosed(boolean)
         */
        default S setClosed(final boolean b) {
            return setup(Conversion.consumer(result -> result.setClosed(b)));
        }

        /**
         * @see JInternalFrame#setContentPane(Container)
         */
        default S setContentPane(final Container c) {
            return setup(result -> result.setContentPane(c));
        }

        /**
         * @see JInternalFrame#setCursor(Cursor)
         */
        default S setCursor(final Cursor cursor) {
            return setup(result -> result.setCursor(cursor));
        }

        /**
         * @see JInternalFrame#setDefaultCloseOperation(int)
         */
        default S setDefaultCloseOperation(final int operation) {
            return setup(result -> result.setDefaultCloseOperation(operation));
        }

        /**
         * @see JInternalFrame#setDesktopIcon(JDesktopIcon)
         */
        default S setDesktopIcon(final JDesktopIcon d) {
            return setup(result -> result.setDesktopIcon(d));
        }

        /**
         * @see JInternalFrame#setFocusCycleRoot(boolean)
         */
        default S setFocusCycleRoot(final boolean focusCycleRoot) {
            return setup(result -> result.setFocusCycleRoot(focusCycleRoot));
        }

        /**
         * @see JInternalFrame#setFrameIcon(Icon)
         */
        default S setFrameIcon(final Icon icon) {
            return setup(result -> result.setFrameIcon(icon));
        }

        /**
         * @see JInternalFrame#setGlassPane(Component)
         */
        default S setGlassPane(final Component glass) {
            return setup(result -> result.setGlassPane(glass));
        }

        /**
         * @see JInternalFrame#setIcon(boolean)
         */
        default S setIcon(final boolean b) {
            return setup(Conversion.consumer(result -> result.setIcon(b)));
        }

        /**
         * @see JInternalFrame#setIconifiable(boolean)
         */
        default S setIconifiable(final boolean b) {
            return setup(result -> result.setIconifiable(b));
        }

        /**
         * @see JInternalFrame#setJMenuBar(JMenuBar)
         */
        default S setJMenuBar(final JMenuBar m) {
            return setup(result -> result.setJMenuBar(m));
        }

        /**
         * @see JInternalFrame#setLayer(Integer)
         */
        default S setLayer(final Integer layer) {
            return setup(result -> result.setLayer(layer));
        }

        /**
         * @see JInternalFrame#setLayer(int)
         */
        default S setLayer(final int layer) {
            return setup(result -> result.setLayer(layer));
        }

        /**
         * @see JInternalFrame#setLayeredPane(JLayeredPane)
         */
        default S setLayeredPane(final JLayeredPane layered) {
            return setup(result -> result.setLayeredPane(layered));
        }

        /**
         * @see JInternalFrame#setLayout(LayoutManager)
         */
        default S setLayout(final LayoutManager manager) {
            return setup(result -> result.setLayout(manager));
        }

        /**
         * @see JInternalFrame#setMaximizable(boolean)
         */
        default S setMaximizable(final boolean b) {
            return setup(result -> result.setMaximizable(b));
        }

        /**
         * @see JInternalFrame#setMaximum(boolean)
         */
        default S setMaximum(final boolean b) {
            return setup(Conversion.consumer(result -> result.setMaximum(b)));
        }

        /**
         * @see JInternalFrame#setNormalBounds(Rectangle)
         */
        default S setNormalBounds(final Rectangle r) {
            return setup(result -> result.setNormalBounds(r));
        }

        /**
         * @see JInternalFrame#setResizable(boolean)
         */
        default S setResizable(final boolean b) {
            return setup(result -> result.setResizable(b));
        }

        /**
         * @see JInternalFrame#setSelected(boolean)
         */
        default S setSelected(final boolean selected) {
            return setup(Conversion.consumer(result -> result.setSelected(selected)));
        }

        /**
         * @see JInternalFrame#setTitle(String)
         */
        default S setTitle(final String title) {
            return setup(result -> result.setTitle(title));
        }

        /**
         * @see JInternalFrame#setUI(InternalFrameUI)
         */
        default S setUI(final InternalFrameUI ui) {
            return setup(result -> result.setUI(ui));
        }
    }
}
