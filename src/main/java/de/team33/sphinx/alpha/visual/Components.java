package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import de.team33.sphinx.alpha.activity.Event;

import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

import java.awt.dnd.DropTarget;
import java.util.Locale;
import java.util.Set;

/**
 * Utility class to handle {@link Component}s.
 */
@SuppressWarnings("unused")
public final class Components {

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link Component}.
     */
    public static <T extends Component> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link Component}.
     * 
     * @param <T> The final type of the target instances, at least {@link Component}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends Component, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link Component}.
     * 
     * @param <T> The final type of the target instance, at least {@link Component}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends Component, S extends Setup<T, S>>
            extends de.team33.patterns.building.elara.Setup<T, S> {

        /**
         * Adds a reaction on a specific event.
         */
        default <M> S on(final Event<? super T, M> event, final Consumer<M> reaction) {
            return setup(t -> event.add(t, reaction));
        }

        /**
         * @see Component#setLocale(Locale)
         */
        default S setLocale(final Locale arg0) {
            return setup(result -> result.setLocale(arg0));
        }

        /**
         * @see Component#setBackground(Color)
         */
        default S setBackground(final Color arg0) {
            return setup(result -> result.setBackground(arg0));
        }

        /**
         * @see Component#setVisible(boolean)
         */
        default S setVisible(final boolean arg0) {
            return setup(result -> result.setVisible(arg0));
        }

        /**
         * @see Component#setCursor(Cursor)
         */
        default S setCursor(final Cursor arg0) {
            return setup(result -> result.setCursor(arg0));
        }

        /**
         * @see Component#setMinimumSize(Dimension)
         */
        default S setMinimumSize(final Dimension arg0) {
            return setup(result -> result.setMinimumSize(arg0));
        }

        /**
         * @see Component#setLocation(int, int)
         */
        default S setLocation(final int arg0, final int arg1) {
            return setup(result -> result.setLocation(arg0, arg1));
        }

        /**
         * @see Component#setLocation(Point)
         */
        default S setLocation(final Point arg0) {
            return setup(result -> result.setLocation(arg0));
        }

        /**
         * @see Component#setBounds(Rectangle)
         */
        default S setBounds(final Rectangle arg0) {
            return setup(result -> result.setBounds(arg0));
        }

        /**
         * @see Component#setBounds(int, int, int, int)
         */
        default S setBounds(final int arg0, final int arg1, final int arg2, final int arg3) {
            return setup(result -> result.setBounds(arg0, arg1, arg2, arg3));
        }

        /**
         * @see Component#add(PopupMenu)
         */
        default S add(final PopupMenu arg0) {
            return setup(result -> result.add(arg0));
        }

        /**
         * @see Component#remove(MenuComponent)
         */
        default S remove(final MenuComponent arg0) {
            return setup(result -> result.remove(arg0));
        }

        /**
         * @see Component#setName(String)
         */
        default S setName(final String arg0) {
            return setup(result -> result.setName(arg0));
        }

        /**
         * @see Component#setSize(int, int)
         */
        default S setSize(final int arg0, final int arg1) {
            return setup(result -> result.setSize(arg0, arg1));
        }

        /**
         * @see Component#setSize(Dimension)
         */
        default S setSize(final Dimension arg0) {
            return setup(result -> result.setSize(arg0));
        }

        /**
         * @see Component#setFont(Font)
         */
        default S setFont(final Font arg0) {
            return setup(result -> result.setFont(arg0));
        }

        /**
         * @see Component#setFocusTraversalKeys(int, Set)
         */
        default S setFocusTraversalKeys(final int arg0, final Set<? extends AWTKeyStroke> arg1) {
            return setup(result -> result.setFocusTraversalKeys(arg0, arg1));
        }

        /**
         * @see Component#setDropTarget(DropTarget)
         */
        default S setDropTarget(final DropTarget arg0) {
            return setup(result -> result.setDropTarget(arg0));
        }

        /**
         * @see Component#setEnabled(boolean)
         */
        default S setEnabled(final boolean arg0) {
            return setup(result -> result.setEnabled(arg0));
        }

        /**
         * @see Component#setForeground(Color)
         */
        default S setForeground(final Color arg0) {
            return setup(result -> result.setForeground(arg0));
        }

        /**
         * @see Component#setPreferredSize(Dimension)
         */
        default S setPreferredSize(final Dimension arg0) {
            return setup(result -> result.setPreferredSize(arg0));
        }

        /**
         * @see Component#setMaximumSize(Dimension)
         */
        default S setMaximumSize(final Dimension arg0) {
            return setup(result -> result.setMaximumSize(arg0));
        }

        /**
         * @see Component#setIgnoreRepaint(boolean)
         */
        default S setIgnoreRepaint(final boolean arg0) {
            return setup(result -> result.setIgnoreRepaint(arg0));
        }

        /**
         * @see Component#setFocusable(boolean)
         */
        default S setFocusable(final boolean arg0) {
            return setup(result -> result.setFocusable(arg0));
        }

        /**
         * @see Component#setFocusTraversalKeysEnabled(boolean)
         */
        default S setFocusTraversalKeysEnabled(final boolean arg0) {
            return setup(result -> result.setFocusTraversalKeysEnabled(arg0));
        }

        /**
         * @see Component#setComponentOrientation(ComponentOrientation)
         */
        default S setComponentOrientation(final ComponentOrientation arg0) {
            return setup(result -> result.setComponentOrientation(arg0));
        }
    }
}
