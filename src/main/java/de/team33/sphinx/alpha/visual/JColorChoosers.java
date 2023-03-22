package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Color;
import java.util.function.Supplier;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.plaf.ColorChooserUI;

/**
 * Utility class to handle {@link JColorChooser}s.
 */
@SuppressWarnings("unused")
public final class JColorChoosers {

    private JColorChoosers() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JColorChooser}.
     */
    public static Builder<JColorChooser, ?> builder() {
        return new Builder<>(JColorChooser::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JColorChooser}.
     */
    public static <T extends JColorChooser> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JColorChooser}.
     * 
     * @param <T> The final type of the target instances, at least {@link JColorChooser}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JColorChooser, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JColorChooser}.
     * 
     * @param <T> The final type of the target instance, at least {@link JColorChooser}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JColorChooser, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JColorChooser#addChooserPanel(AbstractColorChooserPanel)
         */
        default S addChooserPanel(final AbstractColorChooserPanel panel) {
            return setup(result -> result.addChooserPanel(panel));
        }

        /**
         * @see JColorChooser#removeChooserPanel(AbstractColorChooserPanel)
         */
        default S removeChooserPanel(final AbstractColorChooserPanel panel) {
            return setup(result -> result.removeChooserPanel(panel));
        }

        /**
         * @see JColorChooser#setChooserPanels(AbstractColorChooserPanel[])
         */
        default S setChooserPanels(final javax.swing.colorchooser.AbstractColorChooserPanel[] panels) {
            return setup(result -> result.setChooserPanels(panels));
        }

        /**
         * @see JColorChooser#setColor(Color)
         */
        default S setColor(final Color color) {
            return setup(result -> result.setColor(color));
        }

        /**
         * @see JColorChooser#setColor(int)
         */
        default S setColor(final int c) {
            return setup(result -> result.setColor(c));
        }

        /**
         * @see JColorChooser#setColor(int, int, int)
         */
        default S setColor(final int r, final int g, final int b) {
            return setup(result -> result.setColor(r, g, b));
        }

        /**
         * @see JColorChooser#setDragEnabled(boolean)
         */
        default S setDragEnabled(final boolean b) {
            return setup(result -> result.setDragEnabled(b));
        }

        /**
         * @see JColorChooser#setPreviewPanel(JComponent)
         */
        default S setPreviewPanel(final JComponent preview) {
            return setup(result -> result.setPreviewPanel(preview));
        }

        /**
         * @see JColorChooser#setSelectionModel(ColorSelectionModel)
         */
        default S setSelectionModel(final ColorSelectionModel newModel) {
            return setup(result -> result.setSelectionModel(newModel));
        }

        /**
         * @see JColorChooser#setUI(ColorChooserUI)
         */
        default S setUI(final ColorChooserUI ui) {
            return setup(result -> result.setUI(ui));
        }
    }
}
