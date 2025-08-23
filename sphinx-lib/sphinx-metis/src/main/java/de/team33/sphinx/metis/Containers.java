package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import java.awt.*;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link Container}s.
 */
@SuppressWarnings("unused")
public final class Containers {

    private Containers() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link Container}.
     */
    public static Builder<Container> builder() {
        return new Builder<>(Container::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     *
     * @param <C> The final type of the target instances, at least {@link Container}.
     */
    public static <C extends Container> Builder<C> builder(final Supplier<C> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     *
     * @param <C> The final type of the target instance, at least {@link Container}.
     */
    public static <C extends Container> Charger<C> charger(final C target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Utility interface to set up a target instance of {@link Container}.
     *
     * @param <C> The final type of the target instance, at least {@link Container}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<C extends Container, S extends Setup<C, S>> extends Components.Setup<C, S> {

        /**
         * @see Container#add(Component)
         */
        default S add(final Component component) {
            return setup(result -> result.add(component));
        }

        /**
         * @see Container#add(Component, Object)
         */
        default S add(final Component component, final Object constraints) {
            return setup(result -> result.add(component, constraints));
        }

        /**
         * @see Container#add(Component, Object, int)
         */
        default S add(final Component component, final Object constraints, final int index) {
            return setup(result -> result.add(component, constraints, index));
        }

        /**
         * @see Container#add(Component, int)
         */
        default S add(final Component component, final int index) {
            return setup(result -> result.add(component, index));
        }

        /**
         * @see Container#add(String, Component)
         */
        default S add(final String name, final Component component) {
            return setup(result -> result.add(name, component));
        }

        /**
         * @see Container#remove(Component)
         */
        default S remove(final Component component) {
            return setup(result -> result.remove(component));
        }

        /**
         * @see Container#remove(int)
         */
        default S remove(final int index) {
            return setup(result -> result.remove(index));
        }

        /**
         * @see Container#removeAll()
         */
        default S removeAll() {
            return setup(Container::removeAll);
        }

        /**
         * @see Container#setComponentZOrder(Component, int)
         */
        default S setComponentZOrder(final Component component, final int index) {
            return setup(result -> result.setComponentZOrder(component, index));
        }

        /**
         * @see Container#setFocusCycleRoot(boolean)
         */
        default S setFocusCycleRoot(final boolean focusCycleRoot) {
            return setup(result -> result.setFocusCycleRoot(focusCycleRoot));
        }

        /**
         * @see Container#setFocusTraversalPolicy(FocusTraversalPolicy)
         */
        default S setFocusTraversalPolicy(final FocusTraversalPolicy policy) {
            return setup(result -> result.setFocusTraversalPolicy(policy));
        }

        /**
         * @see Container#setFocusTraversalPolicyProvider(boolean)
         */
        default S setFocusTraversalPolicyProvider(final boolean provider) {
            return setup(result -> result.setFocusTraversalPolicyProvider(provider));
        }

        /**
         * @see Container#setLayout(LayoutManager)
         */
        default S setLayout(final LayoutManager manager) {
            return setup(result -> result.setLayout(manager));
        }
    }

    /**
     * Builder implementation to build target instances of {@link Container}.
     *
     * @param <C> The final type of the target instances, at least {@link Container}.
     */
    public static final class Builder<C extends Container>
            extends LateBuilder<C, Builder<C>> implements Setup<C, Builder<C>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<C> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link Container}.
     *
     * @param <C> The final type of the target instance, at least {@link Container}.
     */
    public static final class Charger<C extends Container>
            extends de.team33.patterns.building.elara.Charger<C, Charger<C>>
            implements Setup<C, Charger<C>> {

        @SuppressWarnings("unchecked")
        private Charger(final C target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }
}
