package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Component;
import java.awt.LayoutManager;
import java.util.function.Supplier;
import javax.swing.JLayer;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.plaf.LayerUI;

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
    public static <C extends Component> Builder<C> builder(final C component) {
        return new Builder<>(() -> new JLayer<>(component), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     *
     * @param <C> The type of the layered component, at least {@link Component}.
     */
    public static <C extends Component> Builder<C> builder(final Supplier<JLayer<C>> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JLayer}.
     *
     * @param <C> The type of the layered component, at least {@link Component}.
     */
    public static final class Builder<C extends Component>
            extends LateBuilder<JLayer<C>, Builder<C>> implements Setup<C, Builder<C>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<JLayer<C>> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JLayer}.
     *
     * @param <C> The type of the layered component, at least {@link Component}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<C extends Component, S extends Setup<C, S>>
            extends JComponents.Setup<JLayer<C>, S> {

        /**
         * @see JLayer#remove(Component)
         */
        default S remove(final Component arg0) {
            return setup(result -> result.remove(arg0));
        }

        /**
         * @see JLayer#removeAll()
         */
        default S removeAll() {
            return setup(JLayer::removeAll);
        }

        /**
         * @see JLayer#setBorder(Border)
         */
        default S setBorder(final Border arg0) {
            return setup(result -> result.setBorder(arg0));
        }

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
         * @see JLayer#setLayout(LayoutManager)
         */
        default S setLayout(final LayoutManager arg0) {
            return setup(result -> result.setLayout(arg0));
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
