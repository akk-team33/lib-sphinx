package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

/**
 * Utility class to handle {@link JRadioButton}s.
 */
@SuppressWarnings("unused")
public final class JRadioButtons {

    private JRadioButtons() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JRadioButton}.
     */
    public static Builder<JRadioButton, ?> builder() {
        return new Builder<>(JRadioButton::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JRadioButton}.
     */
    public static <T extends JRadioButton> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JRadioButton}.
     * 
     * @param <T> The final type of the target instances, at least {@link JRadioButton}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JRadioButton, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JRadioButton}.
     * 
     * @param <T> The final type of the target instance, at least {@link JRadioButton}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JRadioButton, S extends Setup<T, S>> extends JToggleButtons.Setup<T, S> {
    }
}
