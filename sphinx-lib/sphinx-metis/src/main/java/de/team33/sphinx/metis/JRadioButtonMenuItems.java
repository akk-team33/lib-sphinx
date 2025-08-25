package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JRadioButtonMenuItem}s.
 */
@SuppressWarnings("unused")
public final class JRadioButtonMenuItems {

    private JRadioButtonMenuItems() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JRadioButtonMenuItem}.
     */
    public static Builder<JRadioButtonMenuItem> builder() {
        return new Builder<>(JRadioButtonMenuItem::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JRadioButtonMenuItem}.
     */
    public static <T extends JRadioButtonMenuItem> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JRadioButtonMenuItem}.
     */
    public static <T extends JRadioButtonMenuItem> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Returns a new {@link Setup} for a given {@link JRadioButtonMenuItem} instance.
     */
    public static Setup<JRadioButtonMenuItem, ?> setup(final JRadioButtonMenuItem target) {
        return charger(target);
    }

    /**
     * Builder implementation to build target instances of {@link JRadioButtonMenuItem}.
     * 
     * @param <T> The final type of the target instances, at least {@link JRadioButtonMenuItem}.
     */
    public static final class Builder<T extends JRadioButtonMenuItem>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JRadioButtonMenuItem}.
     * 
     * @param <T> The final type of the target instance, at least {@link JRadioButtonMenuItem}.
     */
    public static final class Charger<T extends JRadioButtonMenuItem>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings("unchecked")
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JRadioButtonMenuItem}.
     * 
     * @param <T> The final type of the target instance, at least {@link JRadioButtonMenuItem}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JRadioButtonMenuItem, S extends Setup<T, S>> extends JMenuItems.Setup<T, S> {
    }
}
