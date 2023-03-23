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
     */
    public static <C extends Component> Builder<C, ?> builder(final Class<C> componentClass) {
        return new Builder<>(JLayer::new, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JLayer}.
     * 
     * @param <C> The final type of the layered component, at least {@link Component}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<C extends Component, B extends Builder<C, B>>
            extends LateBuilder<JLayer<C>, B> implements Setup<C, B> {

        protected Builder(final Supplier<JLayer<C>> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JLayer}.
     *
     * @param <C> The final type of the layered component, at least {@link Component}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings({"ClassNameSameAsAncestorName", "InterfaceWithOnlyOneDirectInheritor"})
    @FunctionalInterface
    public interface Setup<C extends Component, S extends Setup<C, S>>
            extends JComponents.Setup<JLayer<C>, S> {

        /**
         * @see JLayer#remove(Component)
         */
        default S remove(final Component comp) {
            return setup(result -> result.remove(comp));
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
        default S setBorder(final Border border) {
            return setup(result -> result.setBorder(border));
        }

        /**
         * @see JLayer#setGlassPane(JPanel)
         */
        default S setGlassPane(final JPanel glassPane) {
            return setup(result -> result.setGlassPane(glassPane));
        }

        /**
         * @see JLayer#setLayerEventMask(long)
         */
        default S setLayerEventMask(final long layerEventMask) {
            return setup(result -> result.setLayerEventMask(layerEventMask));
        }

        /**
         * @see JLayer#setLayout(LayoutManager)
         */
        default S setLayout(final LayoutManager mgr) {
            return setup(result -> result.setLayout(mgr));
        }

        /**
         * @see JLayer#setUI(LayerUI)
         */
        default S setUI(final LayerUI<? super C> ui) {
            return setup(result -> result.setUI(ui));
        }

        /**
         * @see JLayer#setView(Component)
         */
        default S setView(final C view) {
            return setup(result -> result.setView(view));
        }
    }
}
