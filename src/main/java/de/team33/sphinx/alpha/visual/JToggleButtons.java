package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.AbstractButton;
import javax.swing.JToggleButton;

/**
 * Utility class to handle {@link JToggleButton}s.
 */
@SuppressWarnings("unused")
public final class JToggleButtons {

    private JToggleButtons() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JToggleButton}.
     */
    public static Builder<JToggleButton, ?> builder() {
        return new Builder<>(JToggleButton::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JToggleButton}.
     */
    public static <T extends JToggleButton> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JToggleButton}.
     * 
     * @param <T> The final type of the target instances, at least {@link JToggleButton}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JToggleButton, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JToggleButton}.
     * 
     * @param <T> The final type of the target instance, at least {@link JToggleButton}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JToggleButton, S extends Setup<T, S>> extends AbstractButtons.Setup<T, S> {
    }
}
