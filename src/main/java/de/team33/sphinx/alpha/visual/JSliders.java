package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Font;
import java.util.Dictionary;
import java.util.function.Supplier;
import javax.swing.BoundedRangeModel;
import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.plaf.SliderUI;

/**
 * Utility class to handle {@link JSlider}s.
 */
@SuppressWarnings("unused")
public final class JSliders {

    private JSliders() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JSlider}.
     */
    public static Builder<JSlider, ?> builder() {
        return new Builder<>(JSlider::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JSlider}.
     */
    public static <T extends JSlider> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JSlider}.
     * 
     * @param <T> The final type of the target instances, at least {@link JSlider}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JSlider, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JSlider}.
     * 
     * @param <T> The final type of the target instance, at least {@link JSlider}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JSlider, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JSlider#setExtent(int)
         */
        default S setExtent(final int arg0) {
            return setup(result -> result.setExtent(arg0));
        }

        /**
         * @see JSlider#setFont(Font)
         */
        default S setFont(final Font arg0) {
            return setup(result -> result.setFont(arg0));
        }

        /**
         * @see JSlider#setInverted(boolean)
         */
        default S setInverted(final boolean arg0) {
            return setup(result -> result.setInverted(arg0));
        }

        /**
         * @see JSlider#setLabelTable(Dictionary)
         */
        default S setLabelTable(final Dictionary<?, ?> arg0) {
            return setup(result -> result.setLabelTable(arg0));
        }

        /**
         * @see JSlider#setMajorTickSpacing(int)
         */
        default S setMajorTickSpacing(final int arg0) {
            return setup(result -> result.setMajorTickSpacing(arg0));
        }

        /**
         * @see JSlider#setMaximum(int)
         */
        default S setMaximum(final int arg0) {
            return setup(result -> result.setMaximum(arg0));
        }

        /**
         * @see JSlider#setMinimum(int)
         */
        default S setMinimum(final int arg0) {
            return setup(result -> result.setMinimum(arg0));
        }

        /**
         * @see JSlider#setMinorTickSpacing(int)
         */
        default S setMinorTickSpacing(final int arg0) {
            return setup(result -> result.setMinorTickSpacing(arg0));
        }

        /**
         * @see JSlider#setModel(BoundedRangeModel)
         */
        default S setModel(final BoundedRangeModel arg0) {
            return setup(result -> result.setModel(arg0));
        }

        /**
         * @see JSlider#setOrientation(int)
         */
        default S setOrientation(final int arg0) {
            return setup(result -> result.setOrientation(arg0));
        }

        /**
         * @see JSlider#setPaintLabels(boolean)
         */
        default S setPaintLabels(final boolean arg0) {
            return setup(result -> result.setPaintLabels(arg0));
        }

        /**
         * @see JSlider#setPaintTicks(boolean)
         */
        default S setPaintTicks(final boolean arg0) {
            return setup(result -> result.setPaintTicks(arg0));
        }

        /**
         * @see JSlider#setPaintTrack(boolean)
         */
        default S setPaintTrack(final boolean arg0) {
            return setup(result -> result.setPaintTrack(arg0));
        }

        /**
         * @see JSlider#setSnapToTicks(boolean)
         */
        default S setSnapToTicks(final boolean arg0) {
            return setup(result -> result.setSnapToTicks(arg0));
        }

        /**
         * @see JSlider#setUI(SliderUI)
         */
        default S setUI(final SliderUI arg0) {
            return setup(result -> result.setUI(arg0));
        }

        /**
         * @see JSlider#setValue(int)
         */
        default S setValue(final int arg0) {
            return setup(result -> result.setValue(arg0));
        }

        /**
         * @see JSlider#setValueIsAdjusting(boolean)
         */
        default S setValueIsAdjusting(final boolean arg0) {
            return setup(result -> result.setValueIsAdjusting(arg0));
        }
    }
}
