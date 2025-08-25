package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import javax.swing.plaf.SliderUI;
import java.util.Dictionary;
import java.util.function.Supplier;

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
    public static Builder<JSlider> builder() {
        return new Builder<>(JSlider::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JSlider}.
     */
    public static <T extends JSlider> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JSlider}.
     */
    public static <T extends JSlider> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Returns a new {@link Setup} for a given {@link JSlider} instance.
     */
    public static Setup<JSlider, ?> setup(final JSlider target) {
        return charger(target);
    }

    /**
     * Builder implementation to build target instances of {@link JSlider}.
     * 
     * @param <T> The final type of the target instances, at least {@link JSlider}.
     */
    public static final class Builder<T extends JSlider>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JSlider}.
     * 
     * @param <T> The final type of the target instance, at least {@link JSlider}.
     */
    public static final class Charger<T extends JSlider>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings("unchecked")
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JSlider}.
     * 
     * @param <T> The final type of the target instance, at least {@link JSlider}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JSlider, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JSlider#setExtent(int)
         */
        default S setExtent(final int arg0) {
            return setup(result -> result.setExtent(arg0));
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
