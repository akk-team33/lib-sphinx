package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
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
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JTextArea}.
     */
    public static <T extends JTextArea> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
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
     * Charger implementation to charge target instances of {@link JTextArea}.
     * 
     * @param <T> The final type of the target instance, at least {@link JTextArea}.
     */
    public static final class Charger<T extends JTextArea>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
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
