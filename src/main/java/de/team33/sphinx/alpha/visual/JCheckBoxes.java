package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.JCheckBox;

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
     * Builder implementation to build target instances of {@link JCheckBox}.
     * 
     * @param <T> The final type of the target instances, at least {@link JCheckBox}.
     */
    public static final class Builder<T extends JCheckBox>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
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
