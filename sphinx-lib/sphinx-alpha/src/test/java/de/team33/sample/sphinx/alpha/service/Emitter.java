package de.team33.sample.sphinx.alpha.service;

import java.util.function.Consumer;

/**
 * Abstracts an instance that can notify an interested party of a change in a specific property of a service.
 *
 * @param <T> The type of the represented property.
 */
public interface Emitter<T> {

    /**
     * @param listener
     */
    void feed(Consumer<T> listener);
}
