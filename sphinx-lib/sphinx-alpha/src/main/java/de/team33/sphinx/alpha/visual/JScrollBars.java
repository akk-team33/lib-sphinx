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
    public static Builder<JScrollBar> builder() {
        return new Builder<>(JScrollBar::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JScrollBar}.
     */
    public static <T extends JScrollBar> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JScrollBar}.
     */
    public static <T extends JScrollBar> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link JScrollBar}.
     * 
     * @param <T> The final type of the target instances, at least {@link JScrollBar}.
     */
    public static final class Builder<T extends JScrollBar>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JScrollBar}.
     * 
     * @param <T> The final type of the target instance, at least {@link JScrollBar}.
     */
    public static final class Charger<T extends JScrollBar>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JScrollBar}.
     * 
     * @param <T> The final type of the target instance, at least {@link JScrollBar}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JScrollBar, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JScrollBar#setBlockIncrement(int)
         */
        default S setBlockIncrement(final int arg0) {
            return setup(result -> result.setBlockIncrement(arg0));
        }

        /**
         * @see JScrollBar#setMaximum(int)
         */
        default S setMaximum(final int arg0) {
            return setup(result -> result.setMaximum(arg0));
        }

        /**
         * @see JScrollBar#setMinimum(int)
         */
        default S setMinimum(final int arg0) {
            return setup(result -> result.setMinimum(arg0));
        }

        /**
         * @see JScrollBar#setModel(BoundedRangeModel)
         */
        default S setModel(final BoundedRangeModel arg0) {
            return setup(result -> result.setModel(arg0));
        }

        /**
         * @see JScrollBar#setOrientation(int)
         */
        default S setOrientation(final int arg0) {
            return setup(result -> result.setOrientation(arg0));
        }

        /**
         * @see JScrollBar#setUI(ScrollBarUI)
         */
        default S setUI(final ScrollBarUI arg0) {
            return setup(result -> result.setUI(arg0));
        }

        /**
         * @see JScrollBar#setUnitIncrement(int)
         */
        default S setUnitIncrement(final int arg0) {
            return setup(result -> result.setUnitIncrement(arg0));
        }

        /**
         * @see JScrollBar#setValue(int)
         */
        default S setValue(final int arg0) {
            return setup(result -> result.setValue(arg0));
        }

        /**
         * @see JScrollBar#setValueIsAdjusting(boolean)
         */
        default S setValueIsAdjusting(final boolean arg0) {
            return setup(result -> result.setValueIsAdjusting(arg0));
        }

        /**
         * @see JScrollBar#setValues(int, int, int, int)
         */
        default S setValues(final int arg0, final int arg1, final int arg2, final int arg3) {
            return setup(result -> result.setValues(arg0, arg1, arg2, arg3));
        }

        /**
         * @see JScrollBar#setVisibleAmount(int)
         */
        default S setVisibleAmount(final int arg0) {
            return setup(result -> result.setVisibleAmount(arg0));
        }
    }
}
