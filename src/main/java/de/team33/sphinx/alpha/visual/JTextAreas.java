package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Font;
import java.util.function.Supplier;
import javax.swing.JTextArea;

/**
 * Utility class to handle {@link JTextArea}s.
 */
@SuppressWarnings("unused")
public final class JTextAreas {

    private JTextAreas() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JTextArea}.
     */
    public static Builder<JTextArea> builder() {
        return new Builder<>(JTextArea::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTextArea}.
     */
    public static <T extends JTextArea> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JTextArea}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTextArea}.
     */
    public static final class Builder<T extends JTextArea>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JTextArea}.
     * 
     * @param <T> The final type of the target instance, at least {@link JTextArea}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JTextArea, S extends Setup<T, S>> extends JTextComponents.Setup<T, S> {

        /**
         * @see JTextArea#setColumns(int)
         */
        default S setColumns(final int arg0) {
            return setup(result -> result.setColumns(arg0));
        }

        /**
         * @see JTextArea#setFont(Font)
         */
        default S setFont(final Font arg0) {
            return setup(result -> result.setFont(arg0));
        }

        /**
         * @see JTextArea#setLineWrap(boolean)
         */
        default S setLineWrap(final boolean arg0) {
            return setup(result -> result.setLineWrap(arg0));
        }

        /**
         * @see JTextArea#setRows(int)
         */
        default S setRows(final int arg0) {
            return setup(result -> result.setRows(arg0));
        }

        /**
         * @see JTextArea#setTabSize(int)
         */
        default S setTabSize(final int arg0) {
            return setup(result -> result.setTabSize(arg0));
        }

        /**
         * @see JTextArea#setWrapStyleWord(boolean)
         */
        default S setWrapStyleWord(final boolean arg0) {
            return setup(result -> result.setWrapStyleWord(arg0));
        }
    }
}
