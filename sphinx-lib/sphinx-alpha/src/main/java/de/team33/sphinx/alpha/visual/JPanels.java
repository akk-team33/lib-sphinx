package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.JPanel;
import javax.swing.plaf.PanelUI;

/**
 * Utility class to handle {@link JPanel}s.
 */
@SuppressWarnings("unused")
public final class JPanels {

    private JPanels() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JPanel}.
     */
    public static Builder<JPanel> builder() {
        return new Builder<>(JPanel::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JPanel}.
     */
    public static <T extends JPanel> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JPanel}.
     * 
     * @param <T> The final type of the target instances, at least {@link JPanel}.
     */
    public static final class Builder<T extends JPanel>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JPanel}.
     * 
     * @param <T> The final type of the target instance, at least {@link JPanel}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JPanel, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JPanel#setUI(PanelUI)
         */
        default S setUI(final PanelUI arg0) {
            return setup(result -> result.setUI(arg0));
        }
    }
}
