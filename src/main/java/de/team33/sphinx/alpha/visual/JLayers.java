package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;

import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.JLayer;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.plaf.LayerUI;

/**
 * Utility class to handle {@link JLayer}s.
 */
public final class JLayers {

    /**
     * Returns a new {@link Builder} for target instances of type {@link JLayer}.
     */
    public static Builder<JLayer, ?> builder() {
        return new Builder<>(JLayer::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JLayer}.
     */
    public static <T extends JLayer> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JLayer}.
     * 
     * @param <T> The final type of the target instances, at least {@link JLayer}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JLayer, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JLayer}.
     * 
     * @param <T> The final type of the target instance, at least {@link JLayer}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JLayer, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JLayer#setUI(LayerUI)
         */
        default S setUI(final LayerUI arg0) {
            return setup(result -> result.setUI(arg0));
        }

        /**
         * @see JLayer#setBorder(Border)
         */
        default S setBorder(final Border arg0) {
            return setup(result -> result.setBorder(arg0));
        }

        /**
         * @see JLayer#setLayout(LayoutManager)
         */
        default S setLayout(final LayoutManager arg0) {
            return setup(result -> result.setLayout(arg0));
        }

        /**
         * @see JLayer#setGlassPane(JPanel)
         */
        default S setGlassPane(final JPanel arg0) {
            return setup(result -> result.setGlassPane(arg0));
        }

        /**
         * @see JLayer#remove(Component)
         */
        default S remove(final Component arg0) {
            return setup(result -> result.remove(arg0));
        }

        /**
         * @see JLayer#removeAll()
         */
        default S removeAll() {
            return setup(result -> result.removeAll());
        }

        /**
         * @see JLayer#setView(Component)
         */
        default S setView(final Component arg0) {
            return setup(result -> result.setView(arg0));
        }

        /**
         * @see JLayer#setLayerEventMask(long)
         */
        default S setLayerEventMask(final long arg0) {
            return setup(result -> result.setLayerEventMask(arg0));
        }
    }
}
