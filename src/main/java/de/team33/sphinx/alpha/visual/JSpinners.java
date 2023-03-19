package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.plaf.SpinnerUI;

/**
 * Utility class to handle {@link JSpinner}s.
 */
@SuppressWarnings("unused")
public final class JSpinners {

    private JSpinners() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JSpinner}.
     */
    public static Builder<JSpinner, ?> builder() {
        return new Builder<>(JSpinner::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JSpinner}.
     */
    public static <T extends JSpinner> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JSpinner}.
     * 
     * @param <T> The final type of the target instances, at least {@link JSpinner}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JSpinner, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JSpinner}.
     * 
     * @param <T> The final type of the target instance, at least {@link JSpinner}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JSpinner, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JSpinner#setEditor(JComponent)
         */
        default S setEditor(final JComponent arg0) {
            return setup(result -> result.setEditor(arg0));
        }

        /**
         * @see JSpinner#setModel(SpinnerModel)
         */
        default S setModel(final SpinnerModel arg0) {
            return setup(result -> result.setModel(arg0));
        }

        /**
         * @see JSpinner#setUI(SpinnerUI)
         */
        default S setUI(final SpinnerUI arg0) {
            return setup(result -> result.setUI(arg0));
        }

        /**
         * @see JSpinner#setValue(Object)
         */
        default S setValue(final Object arg0) {
            return setup(result -> result.setValue(arg0));
        }
    }
}
