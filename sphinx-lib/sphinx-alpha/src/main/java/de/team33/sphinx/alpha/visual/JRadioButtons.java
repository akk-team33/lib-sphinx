package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.JRadioButton;

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
    public static Builder<JRadioButton> builder() {
        return new Builder<>(JRadioButton::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JRadioButton}.
     */
    public static <T extends JRadioButton> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JRadioButton}.
     */
    public static <T extends JRadioButton> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link JRadioButton}.
     * 
     * @param <T> The final type of the target instances, at least {@link JRadioButton}.
     */
    public static final class Builder<T extends JRadioButton>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JRadioButton}.
     * 
     * @param <T> The final type of the target instance, at least {@link JRadioButton}.
     */
    public static final class Charger<T extends JRadioButton>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JRadioButton}.
     * 
     * @param <T> The final type of the target instance, at least {@link JRadioButton}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JRadioButton, S extends Setup<T, S>> extends JToggleButtons.Setup<T, S> {
    }
}
