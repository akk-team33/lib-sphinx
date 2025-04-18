package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.JButton;

/**
 * Utility class to handle {@link JButton}s.
 */
@SuppressWarnings("unused")
public final class JButtons {

    private JButtons() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JButton}.
     */
    public static Builder<JButton> builder() {
        return new Builder<>(JButton::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JButton}.
     */
    public static <T extends JButton> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JButton}.
     */
    public static <T extends JButton> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link JButton}.
     * 
     * @param <T> The final type of the target instances, at least {@link JButton}.
     */
    public static final class Builder<T extends JButton>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JButton}.
     * 
     * @param <T> The final type of the target instance, at least {@link JButton}.
     */
    public static final class Charger<T extends JButton>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JButton}.
     * 
     * @param <T> The final type of the target instance, at least {@link JButton}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JButton, S extends Setup<T, S>> extends AbstractButtons.Setup<T, S> {

        /**
         * @see JButton#setDefaultCapable(boolean)
         */
        default S setDefaultCapable(final boolean arg0) {
            return setup(result -> result.setDefaultCapable(arg0));
        }
    }
}
