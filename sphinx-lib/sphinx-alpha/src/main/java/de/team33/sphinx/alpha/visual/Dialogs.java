package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Dialog;
import java.awt.Dialog.ModalityType;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link Dialog}s.
 */
@SuppressWarnings("unused")
public final class Dialogs {

    private Dialogs() {
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link Dialog}.
     */
    public static <T extends Dialog> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link Dialog}.
     * 
     * @param <T> The final type of the target instances, at least {@link Dialog}.
     */
    public static final class Builder<T extends Dialog>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link Dialog}.
     * 
     * @param <T> The final type of the target instance, at least {@link Dialog}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends Dialog, S extends Setup<T, S>> extends Windows.Setup<T, S> {

        /**
         * @see Dialog#setModal(boolean)
         */
        default S setModal(final boolean arg0) {
            return setup(result -> result.setModal(arg0));
        }

        /**
         * @see Dialog#setModalityType(ModalityType)
         */
        default S setModalityType(final ModalityType arg0) {
            return setup(result -> result.setModalityType(arg0));
        }

        /**
         * @see Dialog#setResizable(boolean)
         */
        default S setResizable(final boolean arg0) {
            return setup(result -> result.setResizable(arg0));
        }

        /**
         * @see Dialog#setTitle(String)
         */
        default S setTitle(final String arg0) {
            return setup(result -> result.setTitle(arg0));
        }

        /**
         * @see Dialog#setUndecorated(boolean)
         */
        default S setUndecorated(final boolean arg0) {
            return setup(result -> result.setUndecorated(arg0));
        }
    }
}
