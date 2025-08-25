package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JCheckBox}s.
 */
@SuppressWarnings("unused")
public final class JCheckBoxes {

    private JCheckBoxes() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JCheckBox}.
     */
    public static Builder<JCheckBox> builder() {
        return new Builder<>(JCheckBox::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JCheckBox}.
     */
    public static <T extends JCheckBox> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JCheckBox}.
     */
    public static <T extends JCheckBox> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Returns a new {@link Setup} for a given {@link JCheckBox} instance.
     */
    public static Setup<JCheckBox, ?> setup(final JCheckBox target) {
        return charger(target);
    }

    /**
     * Builder implementation to build target instances of {@link JCheckBox}.
     * 
     * @param <T> The final type of the target instances, at least {@link JCheckBox}.
     */
    public static final class Builder<T extends JCheckBox>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JCheckBox}.
     * 
     * @param <T> The final type of the target instance, at least {@link JCheckBox}.
     */
    public static final class Charger<T extends JCheckBox>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings("unchecked")
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JCheckBox}.
     * 
     * @param <T> The final type of the target instance, at least {@link JCheckBox}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JCheckBox, S extends Setup<T, S>> extends JToggleButtons.Setup<T, S> {

        /**
         * @see JCheckBox#setBorderPaintedFlat(boolean)
         */
        default S setBorderPaintedFlat(final boolean arg0) {
            return setup(result -> result.setBorderPaintedFlat(arg0));
        }
    }
}
