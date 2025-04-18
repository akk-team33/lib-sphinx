package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.JComponent;
import javax.swing.JToolTip;

/**
 * Utility class to handle {@link JToolTip}s.
 */
@SuppressWarnings("unused")
public final class JToolTips {

    private JToolTips() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JToolTip}.
     */
    public static Builder<JToolTip> builder() {
        return new Builder<>(JToolTip::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JToolTip}.
     */
    public static <T extends JToolTip> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JToolTip}.
     */
    public static <T extends JToolTip> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link JToolTip}.
     * 
     * @param <T> The final type of the target instances, at least {@link JToolTip}.
     */
    public static final class Builder<T extends JToolTip>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JToolTip}.
     * 
     * @param <T> The final type of the target instance, at least {@link JToolTip}.
     */
    public static final class Charger<T extends JToolTip>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JToolTip}.
     * 
     * @param <T> The final type of the target instance, at least {@link JToolTip}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JToolTip, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JToolTip#setComponent(JComponent)
         */
        default S setComponent(final JComponent arg0) {
            return setup(result -> result.setComponent(arg0));
        }

        /**
         * @see JToolTip#setTipText(String)
         */
        default S setTipText(final String arg0) {
            return setup(result -> result.setTipText(arg0));
        }
    }
}
