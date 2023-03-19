package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/**
 * Utility class to handle {@link JRadioButtonMenuItem}s.
 */
@SuppressWarnings("unused")
public final class JRadioButtonMenuItems {

    private JRadioButtonMenuItems() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JRadioButtonMenuItem}.
     */
    public static Builder<JRadioButtonMenuItem, ?> builder() {
        return new Builder<>(JRadioButtonMenuItem::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JRadioButtonMenuItem}.
     */
    public static <T extends JRadioButtonMenuItem> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JRadioButtonMenuItem}.
     * 
     * @param <T> The final type of the target instances, at least {@link JRadioButtonMenuItem}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JRadioButtonMenuItem, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JRadioButtonMenuItem}.
     * 
     * @param <T> The final type of the target instance, at least {@link JRadioButtonMenuItem}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JRadioButtonMenuItem, S extends Setup<T, S>> extends JMenuItems.Setup<T, S> {
    }
}
