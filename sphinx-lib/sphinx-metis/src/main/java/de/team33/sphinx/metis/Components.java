package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;
import de.team33.sphinx.luna.Channel;
import de.team33.sphinx.luna.Subscription;

import java.awt.*;
import java.awt.dnd.DropTarget;
import java.util.Locale;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link Component}s.
 */
@SuppressWarnings("unused")
public final class Components {

    private Components() {
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     *
     * @param <C> The final type of the target instances, at least {@link Component}.
     */
    public static <C extends Component> Builder<C> builder(final Supplier<C> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     *
     * @param <T> The final type of the target instance, at least {@link Component}.
     */
    public static <T extends Component> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Returns a new {@link Setup} for a given {@link Component} instance.
     */
    public static Setup<Component, ?> setup(final Component target) {
        return charger(target);
    }

    /**
     * Utility interface to set up a target instance of {@link Component}.
     *
     * @param <C> The final type of the target instance, at least {@link Component}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings({"ClassNameSameAsAncestorName", "ClassWithTooManyMethods"})
    @FunctionalInterface
    public interface Setup<C extends Component, S extends Setup<C, S>>
            extends de.team33.patterns.building.elara.Setup<C, S> {

        /**
         * Subscribes to messages of type {@code <M>} sent by the underlying target instance in case of an event
         * specified by the given <em>channel</em> and provides a suitable <em>listener</em> for message processing.
         *
         * @see #subscribe(Channel, Consumer, Consumer)
         */
        default <M> S subscribe(final Channel<? super C, M> channel, final Consumer<M> listener) {
            return setup(c -> channel.subscribe(c, listener));
        }

        /**
         * Subscribes to messages of type {@code <M>} sent by the underlying target instance in case of an event
         * specified by the given <em>channel</em> and provides a suitable <em>listener</em> for message processing.
         * <p>
         * Additionally, collects a resulting {@link Subscription} that can be {@link Subscription#cancel() canceled}
         * later to stop processing further messages.
         *
         * @see #subscribe(Channel, Consumer)
         */
        default <M> S subscribe(final Channel<? super C, M> channel,
                                final Consumer<M> listener,
                                final Consumer<Subscription> collector) {
            return setup(c -> collector.accept(channel.subscribe(c, listener)));
        }

        /**
         * @see Component#add(PopupMenu)
         */
        default S add(final PopupMenu popup) {
            return setup(result -> result.add(popup));
        }

        /**
         * @see Component#remove(MenuComponent)
         */
        default S remove(final MenuComponent popup) {
            return setup(result -> result.remove(popup));
        }

        /**
         * @see Component#setBackground(Color)
         */
        default S setBackground(final Color color) {
            return setup(result -> result.setBackground(color));
        }

        /**
         * @see Component#setBounds(Rectangle)
         */
        default S setBounds(final Rectangle r) {
            return setup(result -> result.setBounds(r));
        }

        /**
         * @see Component#setBounds(int, int, int, int)
         */
        default S setBounds(final int x, final int y, final int width, final int height) {
            return setup(result -> result.setBounds(x, y, width, height));
        }

        /**
         * @see Component#setComponentOrientation(ComponentOrientation)
         */
        default S setComponentOrientation(final ComponentOrientation o) {
            return setup(result -> result.setComponentOrientation(o));
        }

        /**
         * @see Component#setCursor(Cursor)
         */
        default S setCursor(final Cursor cursor) {
            return setup(result -> result.setCursor(cursor));
        }

        /**
         * @see Component#setDropTarget(DropTarget)
         */
        default S setDropTarget(final DropTarget dt) {
            return setup(result -> result.setDropTarget(dt));
        }

        /**
         * @see Component#setEnabled(boolean)
         */
        default S setEnabled(final boolean enabled) {
            return setup(result -> result.setEnabled(enabled));
        }

        /**
         * @see Component#setFocusTraversalKeys(int, Set)
         */
        default S setFocusTraversalKeys(final int id, final Set<? extends java.awt.AWTKeyStroke> keystrokes) {
            return setup(result -> result.setFocusTraversalKeys(id, keystrokes));
        }

        /**
         * @see Component#setFocusTraversalKeysEnabled(boolean)
         */
        default S setFocusTraversalKeysEnabled(final boolean focusTraversalKeysEnabled) {
            return setup(result -> result.setFocusTraversalKeysEnabled(focusTraversalKeysEnabled));
        }

        /**
         * @see Component#setFocusable(boolean)
         */
        default S setFocusable(final boolean focusable) {
            return setup(result -> result.setFocusable(focusable));
        }

        /**
         * @see Component#setFont(Font)
         */
        default S setFont(final Font font) {
            return setup(result -> result.setFont(font));
        }

        /**
         * @see Component#setForeground(Color)
         */
        default S setForeground(final Color color) {
            return setup(result -> result.setForeground(color));
        }

        /**
         * @see Component#setIgnoreRepaint(boolean)
         */
        default S setIgnoreRepaint(final boolean ignoreRepaint) {
            return setup(result -> result.setIgnoreRepaint(ignoreRepaint));
        }

        /**
         * @see Component#setLocale(Locale)
         */
        default S setLocale(final Locale locale) {
            return setup(result -> result.setLocale(locale));
        }

        /**
         * @see Component#setLocation(Point)
         */
        default S setLocation(final Point p) {
            return setup(result -> result.setLocation(p));
        }

        /**
         * @see Component#setLocation(int, int)
         */
        default S setLocation(final int x, final int y) {
            return setup(result -> result.setLocation(x, y));
        }

        /**
         * @see Component#setMaximumSize(Dimension)
         */
        default S setMaximumSize(final Dimension maximumSize) {
            return setup(result -> result.setMaximumSize(maximumSize));
        }

        /**
         * @see Component#setMinimumSize(Dimension)
         */
        default S setMinimumSize(final Dimension minimumSize) {
            return setup(result -> result.setMinimumSize(minimumSize));
        }

        /**
         * @see Component#setName(String)
         */
        default S setName(final String name) {
            return setup(result -> result.setName(name));
        }

        /**
         * @see Component#setPreferredSize(Dimension)
         */
        default S setPreferredSize(final Dimension preferredSize) {
            return setup(result -> result.setPreferredSize(preferredSize));
        }

        /**
         * @see Component#setSize(Dimension)
         */
        default S setSize(final Dimension size) {
            return setup(result -> result.setSize(size));
        }

        /**
         * @see Component#setSize(int, int)
         */
        default S setSize(final int width, final int height) {
            return setup(result -> result.setSize(width, height));
        }

        /**
         * @see Component#setVisible(boolean)
         */
        default S setVisible(final boolean visible) {
            return setup(result -> result.setVisible(visible));
        }
    }

    /**
     * Builder implementation to build target instances of {@link Component}.
     *
     * @param <C> The final type of the target instances, at least {@link Component}.
     */
    public static final class Builder<C extends Component>
            extends LateBuilder<C, Builder<C>>
            implements Setup<C, Builder<C>> {

        @SuppressWarnings("unchecked")
        private Builder(final Supplier<C> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link Component}.
     *
     * @param <C> The final type of the target instance, at least {@link Component}.
     */
    public static final class Charger<C extends Component>
            extends de.team33.patterns.building.elara.Charger<C, Charger<C>>
            implements Setup<C, Charger<C>> {

        @SuppressWarnings("unchecked")
        private Charger(final C target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }
}
