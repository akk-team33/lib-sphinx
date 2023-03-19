package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dialog.ModalityType;
import java.awt.Shape;
import java.awt.Window;
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
    public static <T extends Dialog> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link Dialog}.
     * 
     * @param <T> The final type of the target instances, at least {@link Dialog}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends Dialog, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link Dialog}.
     * 
     * @param <T> The final type of the target instance, at least {@link Dialog}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends Dialog, S extends Setup<T, S>> extends Windows.Setup<T, S> {

        /**
         * @see Dialog#setBackground(Color)
         */
        default S setBackground(final Color arg0) {
            return setup(result -> result.setBackground(arg0));
        }

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
         * @see Dialog#setOpacity(float)
         */
        default S setOpacity(final float arg0) {
            return setup(result -> result.setOpacity(arg0));
        }

        /**
         * @see Dialog#setResizable(boolean)
         */
        default S setResizable(final boolean arg0) {
            return setup(result -> result.setResizable(arg0));
        }

        /**
         * @see Dialog#setShape(Shape)
         */
        default S setShape(final Shape arg0) {
            return setup(result -> result.setShape(arg0));
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

        /**
         * @see Dialog#setVisible(boolean)
         */
        default S setVisible(final boolean arg0) {
            return setup(result -> result.setVisible(arg0));
        }
    }
}
