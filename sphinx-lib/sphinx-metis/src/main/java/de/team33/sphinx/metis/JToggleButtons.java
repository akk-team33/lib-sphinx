package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JToggleButton}s.
 */
@SuppressWarnings("unused")
public final class JToggleButtons {

    private JToggleButtons() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JToggleButton}.
     *
     * @see #builder(Supplier)
     * @see JToggleButton#JToggleButton()
     */
    public static Builder<JToggleButton> builder() {
        return new Builder<>(JToggleButton::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JToggleButton}.
     *
     * @see #builder(Supplier)
     * @see JToggleButton#JToggleButton(String, boolean)
     */
    public static Builder<JToggleButton> builder(final String text, final boolean selected) {
        return new Builder<>(() -> new JToggleButton(text, selected), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JToggleButton}.
     *
     * @see #builder(Supplier)
     * @see JToggleButton#JToggleButton(Icon, boolean)
     */
    public static Builder<JToggleButton> builder(final Icon icon, final boolean selected) {
        return new Builder<>(() -> new JToggleButton(icon, selected), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JToggleButton}.
     *
     * @see #builder(Supplier)
     * @see JToggleButton#JToggleButton(String)
     */
    public static Builder<JToggleButton> builder(final String text) {
        return new Builder<>(() -> new JToggleButton(text), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JToggleButton}.
     *
     * @see #builder(Supplier)
     * @see JToggleButton#JToggleButton(Icon)
     */
    public static Builder<JToggleButton> builder(final Icon icon) {
        return new Builder<>(() -> new JToggleButton(icon), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JToggleButton}.
     *
     * @see #builder(Supplier)
     * @see JToggleButton#JToggleButton(String, Icon)
     */
    public static Builder<JToggleButton> builder(final String text, final Icon icon) {
        return new Builder<>(() -> new JToggleButton(text, icon), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JToggleButton}.
     *
     * @see #builder(Supplier)
     * @see JToggleButton#JToggleButton(String, Icon, boolean)
     */
    public static Builder<JToggleButton> builder(final String text, final Icon icon, final boolean selected) {
        return new Builder<>(() -> new JToggleButton(text, icon, selected), Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     *
     * @param <T> The final type of the target instances, at least {@link JToggleButton}.
     */
    public static <T extends JToggleButton> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     *
     * @param <T> The final type of the target instance, at least {@link JToggleButton}.
     */
    public static <T extends JToggleButton> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Returns a new {@link Setup} for a given {@link JToggleButton} instance.
     */
    public static Setup<JToggleButton, ?> setup(final JToggleButton target) {
        return charger(target);
    }

    /**
     * Utility interface to set up a target instance of {@link JToggleButton}.
     *
     * @param <T> The final type of the target instance, at least {@link JToggleButton}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JToggleButton, S extends Setup<T, S>> extends AbstractButtons.Setup<T, S> {
    }

    /**
     * Builder implementation to build target instances of {@link JToggleButton}.
     *
     * @param <T> The final type of the target instances, at least {@link JToggleButton}.
     */
    public static final class Builder<T extends JToggleButton>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JToggleButton}.
     *
     * @param <T> The final type of the target instance, at least {@link JToggleButton}.
     */
    public static final class Charger<T extends JToggleButton>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings("unchecked")
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }
}
