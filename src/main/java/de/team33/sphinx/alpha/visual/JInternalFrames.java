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
        default S remove(final Component arg0) {
            return setup(result -> result.remove(arg0));
        }

        /**
         * @see JInternalFrame#setClosable(boolean)
         */
        default S setClosable(final boolean arg0) {
            return setup(result -> result.setClosable(arg0));
        }

        /**
         * @see JInternalFrame#setClosed(boolean)
         */
        default S setClosed(final boolean arg0) {
            return setup(Conversion.consumer(result -> result.setClosed(arg0)));
        }

        /**
         * @see JInternalFrame#setContentPane(Container)
         */
        default S setContentPane(final Container arg0) {
            return setup(result -> result.setContentPane(arg0));
        }

        /**
         * @see JInternalFrame#setCursor(Cursor)
         */
        default S setCursor(final Cursor arg0) {
            return setup(result -> result.setCursor(arg0));
        }

        /**
         * @see JInternalFrame#setDefaultCloseOperation(int)
         */
        default S setDefaultCloseOperation(final int arg0) {
            return setup(result -> result.setDefaultCloseOperation(arg0));
        }

        /**
         * @see JInternalFrame#setDesktopIcon(JDesktopIcon)
         */
        default S setDesktopIcon(final JDesktopIcon arg0) {
            return setup(result -> result.setDesktopIcon(arg0));
        }

        /**
         * @see JInternalFrame#setFocusCycleRoot(boolean)
         */
        default S setFocusCycleRoot(final boolean arg0) {
            return setup(result -> result.setFocusCycleRoot(arg0));
        }

        /**
         * @see JInternalFrame#setFrameIcon(Icon)
         */
        default S setFrameIcon(final Icon arg0) {
            return setup(result -> result.setFrameIcon(arg0));
        }

        /**
         * @see JInternalFrame#setGlassPane(Component)
         */
        default S setGlassPane(final Component arg0) {
            return setup(result -> result.setGlassPane(arg0));
        }

        /**
         * @see JInternalFrame#setIcon(boolean)
         */
        default S setIcon(final boolean arg0) {
            return setup(Conversion.consumer(result -> result.setIcon(arg0)));
        }

        /**
         * @see JInternalFrame#setIconifiable(boolean)
         */
        default S setIconifiable(final boolean arg0) {
            return setup(result -> result.setIconifiable(arg0));
        }

        /**
         * @see JInternalFrame#setJMenuBar(JMenuBar)
         */
        default S setJMenuBar(final JMenuBar arg0) {
            return setup(result -> result.setJMenuBar(arg0));
        }

        /**
         * @see JInternalFrame#setLayer(Integer)
         */
        default S setLayer(final Integer arg0) {
            return setup(result -> result.setLayer(arg0));
        }

        /**
         * @see JInternalFrame#setLayer(int)
         */
        default S setLayer(final int arg0) {
            return setup(result -> result.setLayer(arg0));
        }

        /**
         * @see JInternalFrame#setLayeredPane(JLayeredPane)
         */
        default S setLayeredPane(final JLayeredPane arg0) {
            return setup(result -> result.setLayeredPane(arg0));
        }

        /**
         * @see JInternalFrame#setLayout(LayoutManager)
         */
        default S setLayout(final LayoutManager arg0) {
            return setup(result -> result.setLayout(arg0));
        }

        /**
         * @see JInternalFrame#setMaximizable(boolean)
         */
        default S setMaximizable(final boolean arg0) {
            return setup(result -> result.setMaximizable(arg0));
        }

        /**
         * @see JInternalFrame#setMaximum(boolean)
         */
        default S setMaximum(final boolean arg0) {
            return setup(Conversion.consumer(result -> result.setMaximum(arg0)));
        }

        /**
         * @see JInternalFrame#setNormalBounds(Rectangle)
         */
        default S setNormalBounds(final Rectangle arg0) {
            return setup(result -> result.setNormalBounds(arg0));
        }

        /**
         * @see JInternalFrame#setResizable(boolean)
         */
        default S setResizable(final boolean arg0) {
            return setup(result -> result.setResizable(arg0));
        }

        /**
         * @see JInternalFrame#setSelected(boolean)
         */
        default S setSelected(final boolean arg0) {
            return setup(Conversion.consumer(result -> result.setSelected(arg0)));
        }

        /**
         * @see JInternalFrame#setTitle(String)
         */
        default S setTitle(final String arg0) {
            return setup(result -> result.setTitle(arg0));
        }

        /**
         * @see JInternalFrame#setUI(InternalFrameUI)
         */
        default S setUI(final InternalFrameUI arg0) {
            return setup(result -> result.setUI(arg0));
        }
    }
}
