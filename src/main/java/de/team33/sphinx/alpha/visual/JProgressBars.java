package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.BoundedRangeModel;
import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.plaf.ProgressBarUI;

/**
 * Utility class to handle {@link JProgressBar}s.
 */
@SuppressWarnings("unused")
public final class JProgressBars {

    private JProgressBars() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JProgressBar}.
     */
    public static Builder<JProgressBar, ?> builder() {
        return new Builder<>(JProgressBar::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JProgressBar}.
     */
    public static <T extends JProgressBar> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JProgressBar}.
     * 
     * @param <T> The final type of the target instances, at least {@link JProgressBar}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JProgressBar, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JProgressBar}.
     * 
     * @param <T> The final type of the target instance, at least {@link JProgressBar}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JProgressBar, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JProgressBar#setBorderPainted(boolean)
         */
        default S setBorderPainted(final boolean arg0) {
            return setup(result -> result.setBorderPainted(arg0));
        }

        /**
         * @see JProgressBar#setIndeterminate(boolean)
         */
        default S setIndeterminate(final boolean arg0) {
            return setup(result -> result.setIndeterminate(arg0));
        }

        /**
         * @see JProgressBar#setMaximum(int)
         */
        default S setMaximum(final int arg0) {
            return setup(result -> result.setMaximum(arg0));
        }

        /**
         * @see JProgressBar#setMinimum(int)
         */
        default S setMinimum(final int arg0) {
            return setup(result -> result.setMinimum(arg0));
        }

        /**
         * @see JProgressBar#setModel(BoundedRangeModel)
         */
        default S setModel(final BoundedRangeModel arg0) {
            return setup(result -> result.setModel(arg0));
        }

        /**
         * @see JProgressBar#setOrientation(int)
         */
        default S setOrientation(final int arg0) {
            return setup(result -> result.setOrientation(arg0));
        }

        /**
         * @see JProgressBar#setString(String)
         */
        default S setString(final String arg0) {
            return setup(result -> result.setString(arg0));
        }

        /**
         * @see JProgressBar#setStringPainted(boolean)
         */
        default S setStringPainted(final boolean arg0) {
            return setup(result -> result.setStringPainted(arg0));
        }

        /**
         * @see JProgressBar#setUI(ProgressBarUI)
         */
        default S setUI(final ProgressBarUI arg0) {
            return setup(result -> result.setUI(arg0));
        }

        /**
         * @see JProgressBar#setValue(int)
         */
        default S setValue(final int arg0) {
            return setup(result -> result.setValue(arg0));
        }
    }
}
