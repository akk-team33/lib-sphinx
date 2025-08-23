package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;
import de.team33.patterns.exceptional.dione.Conversion;

import javax.swing.*;
import javax.swing.JInternalFrame.JDesktopIcon;
import javax.swing.plaf.InternalFrameUI;
import java.awt.*;
import java.util.function.Supplier;

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
    public static Builder<JInternalFrame> builder() {
        return new Builder<>(JInternalFrame::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JInternalFrame}.
     */
    public static <T extends JInternalFrame> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JInternalFrame}.
     */
    public static <T extends JInternalFrame> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link JInternalFrame}.
     * 
     * @param <T> The final type of the target instances, at least {@link JInternalFrame}.
     */
    public static final class Builder<T extends JInternalFrame>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JInternalFrame}.
     * 
     * @param <T> The final type of the target instance, at least {@link JInternalFrame}.
     */
    public static final class Charger<T extends JInternalFrame>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JInternalFrame}.
     * 
     * @param <T> The final type of the target instance, at least {@link JInternalFrame}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JInternalFrame, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

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
