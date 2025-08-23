package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JCheckBoxMenuItem}s.
 */
@SuppressWarnings("unused")
public final class JCheckBoxMenuItems {

    private JCheckBoxMenuItems() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JCheckBoxMenuItem}.
     */
    public static Builder<JCheckBoxMenuItem> builder() {
        return new Builder<>(JCheckBoxMenuItem::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JCheckBoxMenuItem}.
     */
    public static <T extends JCheckBoxMenuItem> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JCheckBoxMenuItem}.
     */
    public static <T extends JCheckBoxMenuItem> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link JCheckBoxMenuItem}.
     * 
     * @param <T> The final type of the target instances, at least {@link JCheckBoxMenuItem}.
     */
    public static final class Builder<T extends JCheckBoxMenuItem>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JCheckBoxMenuItem}.
     * 
     * @param <T> The final type of the target instance, at least {@link JCheckBoxMenuItem}.
     */
    public static final class Charger<T extends JCheckBoxMenuItem>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JCheckBoxMenuItem}.
     * 
     * @param <T> The final type of the target instance, at least {@link JCheckBoxMenuItem}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JCheckBoxMenuItem, S extends Setup<T, S>> extends JMenuItems.Setup<T, S> {

        /**
         * @see JCheckBoxMenuItem#setState(boolean)
         */
        default S setState(final boolean arg0) {
            return setup(result -> result.setState(arg0));
        }
    }
}
