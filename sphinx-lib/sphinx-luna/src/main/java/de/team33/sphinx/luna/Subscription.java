package de.team33.sphinx.luna;

/**
 * Represents a subscription that may need to be {@link #cancel() canceled} later.
 */
@FunctionalInterface
public interface Subscription {

    /**
     * Cancels <em>this</em> {@link Subscription} and thus unlinks the involved instances.
     * <p>
     * After that, it’s best to forget about <em>this</em> {@link Subscription} (no longer refer it)!
     */
    void cancel();
}
