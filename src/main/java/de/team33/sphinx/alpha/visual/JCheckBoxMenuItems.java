package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.JCheckBoxMenuItem;

/**
 * Utility class to handle {@link JCheckBoxMenuItem}s.
 */
@SuppressWarnings("unused")
public final class JCheckBoxMenuItems {

    private JCheckBoxMenuItems() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JCheckBoxMenuItem}.
     */
    public static Builder<JCheckBoxMenuItem, ?> builder() {
        return new Builder<>(JCheckBoxMenuItem::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JCheckBoxMenuItem}.
     */
    public static <T extends JCheckBoxMenuItem> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JCheckBoxMenuItem}.
     * 
     * @param <T> The final type of the target instances, at least {@link JCheckBoxMenuItem}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JCheckBoxMenuItem, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JCheckBoxMenuItem}.
     * 
     * @param <T> The final type of the target instance, at least {@link JCheckBoxMenuItem}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JCheckBoxMenuItem, S extends Setup<T, S>> extends JMenuItems.Setup<T, S> {

        /**
         * @see JCheckBoxMenuItem#setState(boolean)
         */
        default S setState(final boolean b) {
            return setup(result -> result.setState(b));
        }
    }
}
