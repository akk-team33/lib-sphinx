package de.team33.sphinx.alpha.activity;

import java.util.function.Consumer;

/**
 * Abstracts the context of an activity or event.
 *
 * @param <C> The component type in whose context the activity or event takes place.
 * @param <M> The message type being transferred in the context of the activity or event.
 */
public interface Context<C, M> {

    /**
     * Adds an appropriate {@link Consumer} to a given component of type {@code <C>} to process the associated
     * message of type {@code <M>} when an activity or event as expected in this context occurs.
     */
    void add(final C component, final Consumer<M> reaction);
}
