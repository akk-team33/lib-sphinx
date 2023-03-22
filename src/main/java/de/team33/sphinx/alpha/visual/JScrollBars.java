package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.BoundedRangeModel;
import javax.swing.JScrollBar;
import javax.swing.plaf.ScrollBarUI;

/**
 * Utility class to handle {@link JScrollBar}s.
 */
@SuppressWarnings("unused")
public final class JScrollBars {

    private JScrollBars() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JScrollBar}.
     */
    public static Builder<JScrollBar, ?> builder() {
        return new Builder<>(JScrollBar::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JScrollBar}.
     */
    public static <T extends JScrollBar> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JScrollBar}.
     * 
     * @param <T> The final type of the target instances, at least {@link JScrollBar}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JScrollBar, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JScrollBar}.
     * 
     * @param <T> The final type of the target instance, at least {@link JScrollBar}.
     * @param <S> The final type of the Setup implementation.
     */
    @FunctionalInterface
    public interface Setup<T extends JScrollBar, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JScrollBar#setBlockIncrement(int)
         */
        default S setBlockIncrement(final int blockIncrement) {
            return setup(result -> result.setBlockIncrement(blockIncrement));
        }

        /**
         * @see JScrollBar#setEnabled(boolean)
         */
        default S setEnabled(final boolean x) {
            return setup(result -> result.setEnabled(x));
        }

        /**
         * @see JScrollBar#setMaximum(int)
         */
        default S setMaximum(final int maximum) {
            return setup(result -> result.setMaximum(maximum));
        }

        /**
         * @see JScrollBar#setMinimum(int)
         */
        default S setMinimum(final int minimum) {
            return setup(result -> result.setMinimum(minimum));
        }

        /**
         * @see JScrollBar#setModel(BoundedRangeModel)
         */
        default S setModel(final BoundedRangeModel newModel) {
            return setup(result -> result.setModel(newModel));
        }

        /**
         * @see JScrollBar#setOrientation(int)
         */
        default S setOrientation(final int orientation) {
            return setup(result -> result.setOrientation(orientation));
        }

        /**
         * @see JScrollBar#setUI(ScrollBarUI)
         */
        default S setUI(final ScrollBarUI ui) {
            return setup(result -> result.setUI(ui));
        }

        /**
         * @see JScrollBar#setUnitIncrement(int)
         */
        default S setUnitIncrement(final int unitIncrement) {
            return setup(result -> result.setUnitIncrement(unitIncrement));
        }

        /**
         * @see JScrollBar#setValue(int)
         */
        default S setValue(final int value) {
            return setup(result -> result.setValue(value));
        }

        /**
         * @see JScrollBar#setValueIsAdjusting(boolean)
         */
        default S setValueIsAdjusting(final boolean b) {
            return setup(result -> result.setValueIsAdjusting(b));
        }

        /**
         * @see JScrollBar#setValues(int, int, int, int)
         */
        default S setValues(final int newValue, final int newExtent, final int newMin, final int newMax) {
            return setup(result -> result.setValues(newValue, newExtent, newMin, newMax));
        }

        /**
         * @see JScrollBar#setVisibleAmount(int)
         */
        default S setVisibleAmount(final int extent) {
            return setup(result -> result.setVisibleAmount(extent));
        }
    }
}
