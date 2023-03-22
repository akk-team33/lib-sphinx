package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Component;
import java.awt.Insets;
import java.util.function.Supplier;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SingleSelectionModel;
import javax.swing.plaf.MenuBarUI;

/**
 * Utility class to handle {@link JMenuBar}s.
 */
@SuppressWarnings("unused")
public final class JMenuBars {

    private JMenuBars() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JMenuBar}.
     */
    public static Builder<JMenuBar, ?> builder() {
        return new Builder<>(JMenuBar::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JMenuBar}.
     */
    public static <T extends JMenuBar> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JMenuBar}.
     * 
     * @param <T> The final type of the target instances, at least {@link JMenuBar}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JMenuBar, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JMenuBar}.
     * 
     * @param <T> The final type of the target instance, at least {@link JMenuBar}.
     * @param <S> The final type of the Setup implementation.
     */
    @FunctionalInterface
    public interface Setup<T extends JMenuBar, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JMenuBar#add(JMenu)
         */
        default S add(final JMenu c) {
            return setup(result -> result.add(c));
        }

        /**
         * @see JMenuBar#setBorderPainted(boolean)
         */
        default S setBorderPainted(final boolean b) {
            return setup(result -> result.setBorderPainted(b));
        }

        /**
         * @see JMenuBar#setHelpMenu(JMenu)
         */
        default S setHelpMenu(final JMenu menu) {
            return setup(result -> result.setHelpMenu(menu));
        }

        /**
         * @see JMenuBar#setMargin(Insets)
         */
        default S setMargin(final Insets m) {
            return setup(result -> result.setMargin(m));
        }

        /**
         * @see JMenuBar#setSelected(Component)
         */
        default S setSelected(final Component sel) {
            return setup(result -> result.setSelected(sel));
        }

        /**
         * @see JMenuBar#setSelectionModel(SingleSelectionModel)
         */
        default S setSelectionModel(final SingleSelectionModel model) {
            return setup(result -> result.setSelectionModel(model));
        }

        /**
         * @see JMenuBar#setUI(MenuBarUI)
         */
        default S setUI(final MenuBarUI ui) {
            return setup(result -> result.setUI(ui));
        }
    }
}
