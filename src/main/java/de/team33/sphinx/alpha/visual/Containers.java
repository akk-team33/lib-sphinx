package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.Font;
import java.awt.LayoutManager;
import java.util.Set;
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
    public static Builder<Container, ?> builder() {
        return new Builder<>(Container::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link Container}.
     */
    public static <T extends Container> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link Container}.
     * 
     * @param <T> The final type of the target instances, at least {@link Container}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends Container, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link Container}.
     * 
     * @param <T> The final type of the target instance, at least {@link Container}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends Container, S extends Setup<T, S>> extends Components.Setup<T, S> {

        /**
         * @see Container#add(Component)
         */
        default S add(final Component comp) {
            return setup(result -> result.add(comp));
        }

        /**
         * @see Container#add(Component, Object)
         */
        default S add(final Component comp, final Object constraints) {
            return setup(result -> result.add(comp, constraints));
        }

        /**
         * @see Container#add(Component, Object, int)
         */
        default S add(final Component comp, final Object constraints, final int index) {
            return setup(result -> result.add(comp, constraints, index));
        }

        /**
         * @see Container#add(Component, int)
         */
        default S add(final Component comp, final int index) {
            return setup(result -> result.add(comp, index));
        }

        /**
         * @see Container#add(String, Component)
         */
        default S add(final String name, final Component comp) {
            return setup(result -> result.add(name, comp));
        }

        /**
         * @see Container#remove(Component)
         */
        default S remove(final Component comp) {
            return setup(result -> result.remove(comp));
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
        default S setComponentZOrder(final Component comp, final int index) {
            return setup(result -> result.setComponentZOrder(comp, index));
        }

        /**
         * @see Container#setFocusCycleRoot(boolean)
         */
        default S setFocusCycleRoot(final boolean focusCycleRoot) {
            return setup(result -> result.setFocusCycleRoot(focusCycleRoot));
        }

        /**
         * @see Container#setFocusTraversalKeys(int, Set)
         */
        default S setFocusTraversalKeys(final int id, final Set<? extends java.awt.AWTKeyStroke> keystrokes) {
            return setup(result -> result.setFocusTraversalKeys(id, keystrokes));
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
         * @see Container#setFont(Font)
         */
        default S setFont(final Font f) {
            return setup(result -> result.setFont(f));
        }

        /**
         * @see Container#setLayout(LayoutManager)
         */
        default S setLayout(final LayoutManager mgr) {
            return setup(result -> result.setLayout(mgr));
        }
    }
}
