package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JLayer}s.
 */
@SuppressWarnings("unused")
public final class JLayers {

    private JLayers() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JLayer}.
     *
     * @param <C> The type of the layered component, at least {@link Component}.
     */
    public static <C extends Component> Builder<C, JLayer<C>> builder(final C component) {
        return new Builder<>(() -> new JLayer<>(component), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     *
     * @param <C> The type of the layered component, at least {@link Component}.
     * @param <T> The final type of the target instances, at least {@link JLayer}.
     */
    public static <C extends Component, T extends JLayer<C>> Builder<C, T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     *
     * @param <C> The type of the layered component, at least {@link Component}.
     * @param <T> The final type of the target instance, at least {@link JLayer}.
     */
    public static <C extends Component, T extends JLayer<C>> Charger<C, T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Returns a new {@link Setup} for a given {@link JLayer} instance.
     *
     * @param <C> The type of the layered component, at least {@link Component}.
     */
    public static <C extends Component> Setup<C, JLayer<C>, ?> setup(final JLayer<C> target) {
        return charger(target);
    }

    /**
     * Builder implementation to build target instances of {@link JLayer}.
     *
     * @param <C> The type of the layered component, at least {@link Component}.
     * @param <T> The final type of the target instances, at least {@link JLayer}.
     */
    public static final class Builder<C extends Component, T extends JLayer<C>>
            extends LateBuilder<T, Builder<C, T>> implements Setup<C, T, Builder<C, T>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JLayer}.
     *
     * @param <C> The type of the layered component, at least {@link Component}.
     * @param <T> The final type of the target instance, at least {@link JLayer}.
     */
    public static final class Charger<C extends Component, T extends JLayer<C>>
            extends de.team33.patterns.building.elara.Charger<T, Charger<C, T>>
            implements Setup<C, T, Charger<C, T>> {

        @SuppressWarnings("unchecked")
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JLayer}.
     * 
     * @param <C> The type of the layered component, at least {@link Component}.
     * @param <T> The final type of the target instance, at least {@link JLayer}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<C extends Component, T extends JLayer<C>, S extends Setup<C, T, S>>
            extends JComponents.Setup<T, S> {

        /**
         * @see JLayer#setGlassPane(JPanel)
         */
        default S setGlassPane(final JPanel arg0) {
            return setup(result -> result.setGlassPane(arg0));
        }

        /**
         * @see JLayer#setLayerEventMask(long)
         */
        default S setLayerEventMask(final long arg0) {
            return setup(result -> result.setLayerEventMask(arg0));
        }

        /**
         * @see JLayer#setUI(LayerUI)
         */
        default S setUI(final LayerUI<? super C> arg0) {
            return setup(result -> result.setUI(arg0));
        }

        /**
         * @see JLayer#setView(Component)
         */
        default S setView(final C arg0) {
            return setup(result -> result.setView(arg0));
        }
    }
}
