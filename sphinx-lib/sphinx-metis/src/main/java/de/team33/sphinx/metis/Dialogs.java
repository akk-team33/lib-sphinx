package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import java.awt.*;
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
     * @param <D> The final type of the target instances, at least {@link Dialog}.
     */
    public static <D extends Dialog> Builder<D> builder(final Supplier<D> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * @see #builder(Supplier)
     * @see Dialog#Dialog(Window)
     */
    public static Builder<Dialog> builder(final Window owner) {
        return new Builder<>(() -> new Dialog(owner), Builder.class);
    }

    /**
     * @see #builder(Supplier)
     * @see Dialog#Dialog(Window, String)
     */
    public static Builder<Dialog> builder(final Window owner, final String title) {
        return new Builder<>(() -> new Dialog(owner, title), Builder.class);
    }

    /**
     * @see #builder(Supplier)
     * @see Dialog#Dialog(Window, ModalityType)
     */
    public static Builder<Dialog> builder(final Window owner, final ModalityType type) {
        return new Builder<>(() -> new Dialog(owner, type), Builder.class);
    }

    /**
     * @see #builder(Supplier)
     * @see Dialog#Dialog(Window, String, ModalityType)
     */
    public static Builder<Dialog> builder(final Window owner, final String title, final ModalityType type) {
        return new Builder<>(() -> new Dialog(owner, title, type), Builder.class);
    }

    /**
     * @see #builder(Supplier)
     * @see Dialog#Dialog(Window, String, ModalityType, GraphicsConfiguration)
     */
    public static Builder<Dialog> builder(final Window owner, final String title,
                                          final ModalityType type, final GraphicsConfiguration gc) {
        return new Builder<>(() -> new Dialog(owner, title, type, gc), Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     *
     * @param <D> The final type of the target instance, at least {@link Dialog}.
     */
    public static <D extends Dialog> Charger<D> charger(final D target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Returns a new {@link Setup} for a given {@link Dialog} instance.
     */
    public static Setup<Dialog, ?> setup(final Dialog target) {
        return charger(target);
    }

    /**
     * Utility interface to set up a target instance of {@link Dialog}.
     *
     * @param <D> The final type of the target instance, at least {@link Dialog}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<D extends Dialog, S extends Setup<D, S>> extends Windows.Setup<D, S> {

        /**
         * @see Dialog#setModal(boolean)
         */
        default S setModal(final boolean modal) {
            return setup(result -> result.setModal(modal));
        }

        /**
         * @see Dialog#setModalityType(ModalityType)
         */
        default S setModalityType(final ModalityType type) {
            return setup(result -> result.setModalityType(type));
        }

        /**
         * @see Dialog#setResizable(boolean)
         */
        default S setResizable(final boolean resizable) {
            return setup(result -> result.setResizable(resizable));
        }

        /**
         * @see Dialog#setTitle(String)
         */
        default S setTitle(final String title) {
            return setup(result -> result.setTitle(title));
        }

        /**
         * @see Dialog#setUndecorated(boolean)
         */
        default S setUndecorated(final boolean undecorated) {
            return setup(result -> result.setUndecorated(undecorated));
        }
    }

    /**
     * Builder implementation to build target instances of {@link Dialog}.
     *
     * @param <D> The final type of the target instances, at least {@link Dialog}.
     */
    public static final class Builder<D extends Dialog>
            extends LateBuilder<D, Builder<D>> implements Setup<D, Builder<D>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<D> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link Dialog}.
     *
     * @param <D> The final type of the target instance, at least {@link Dialog}.
     */
    public static final class Charger<D extends Dialog>
            extends de.team33.patterns.building.elara.Charger<D, Charger<D>>
            implements Setup<D, Charger<D>> {

        @SuppressWarnings("unchecked")
        private Charger(final D target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }
}
