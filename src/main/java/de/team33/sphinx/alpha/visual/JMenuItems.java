package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.plaf.MenuItemUI;

/**
 * Utility class to handle {@link JMenuItem}s.
 */
@SuppressWarnings("unused")
public final class JMenuItems {

    private JMenuItems() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JMenuItem}.
     */
    public static Builder<JMenuItem, ?> builder() {
        return new Builder<>(JMenuItem::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JMenuItem}.
     */
    public static <T extends JMenuItem> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JMenuItem}.
     * 
     * @param <T> The final type of the target instances, at least {@link JMenuItem}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JMenuItem, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JMenuItem}.
     * 
     * @param <T> The final type of the target instance, at least {@link JMenuItem}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JMenuItem, S extends Setup<T, S>> extends AbstractButtons.Setup<T, S> {

        /**
         * @see JMenuItem#setAccelerator(KeyStroke)
         */
        default S setAccelerator(final KeyStroke arg0) {
            return setup(result -> result.setAccelerator(arg0));
        }

        /**
         * @see JMenuItem#setArmed(boolean)
         */
        default S setArmed(final boolean arg0) {
            return setup(result -> result.setArmed(arg0));
        }

        /**
         * @see JMenuItem#setEnabled(boolean)
         */
        default S setEnabled(final boolean arg0) {
            return setup(result -> result.setEnabled(arg0));
        }

        /**
         * @see JMenuItem#setModel(ButtonModel)
         */
        default S setModel(final ButtonModel arg0) {
            return setup(result -> result.setModel(arg0));
        }

        /**
         * @see JMenuItem#setUI(MenuItemUI)
         */
        default S setUI(final MenuItemUI arg0) {
            return setup(result -> result.setUI(arg0));
        }
    }
}
