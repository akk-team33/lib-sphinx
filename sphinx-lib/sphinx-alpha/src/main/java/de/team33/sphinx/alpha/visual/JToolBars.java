package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.function.Supplier;
import javax.swing.Action;
import javax.swing.JToolBar;
import javax.swing.plaf.ToolBarUI;

/**
 * Utility class to handle {@link JToolBar}s.
 */
@SuppressWarnings("unused")
public final class JToolBars {

    private JToolBars() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JToolBar}.
     */
    public static Builder<JToolBar> builder() {
        return new Builder<>(JToolBar::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JToolBar}.
     */
    public static <T extends JToolBar> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JToolBar}.
     */
    public static <T extends JToolBar> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link JToolBar}.
     * 
     * @param <T> The final type of the target instances, at least {@link JToolBar}.
     */
    public static final class Builder<T extends JToolBar>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JToolBar}.
     * 
     * @param <T> The final type of the target instance, at least {@link JToolBar}.
     */
    public static final class Charger<T extends JToolBar>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JToolBar}.
     * 
     * @param <T> The final type of the target instance, at least {@link JToolBar}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JToolBar, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JToolBar#add(Action)
         */
        default S add(final Action arg0) {
            return setup(result -> result.add(arg0));
        }

        /**
         * @see JToolBar#addSeparator()
         */
        default S addSeparator() {
            return setup(result -> result.addSeparator());
        }

        /**
         * @see JToolBar#addSeparator(Dimension)
         */
        default S addSeparator(final Dimension arg0) {
            return setup(result -> result.addSeparator(arg0));
        }

        /**
         * @see JToolBar#setBorderPainted(boolean)
         */
        default S setBorderPainted(final boolean arg0) {
            return setup(result -> result.setBorderPainted(arg0));
        }

        /**
         * @see JToolBar#setFloatable(boolean)
         */
        default S setFloatable(final boolean arg0) {
            return setup(result -> result.setFloatable(arg0));
        }

        /**
         * @see JToolBar#setMargin(Insets)
         */
        default S setMargin(final Insets arg0) {
            return setup(result -> result.setMargin(arg0));
        }

        /**
         * @see JToolBar#setOrientation(int)
         */
        default S setOrientation(final int arg0) {
            return setup(result -> result.setOrientation(arg0));
        }

        /**
         * @see JToolBar#setRollover(boolean)
         */
        default S setRollover(final boolean arg0) {
            return setup(result -> result.setRollover(arg0));
        }

        /**
         * @see JToolBar#setUI(ToolBarUI)
         */
        default S setUI(final ToolBarUI arg0) {
            return setup(result -> result.setUI(arg0));
        }
    }
}
