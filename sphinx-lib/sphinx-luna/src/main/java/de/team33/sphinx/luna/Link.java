package de.team33.sphinx.luna;

import java.util.function.Consumer;

/**
 * @deprecated use {@link Subscription} instead.
 * @see Channel#add(Object, Consumer)
 * @see Channel#subscribe(Object, Consumer)
 */
@Deprecated
@FunctionalInterface
public interface Link {

    /**
     * Unlinks <em>this</em> {@link Link}.
     * After that, it’s best to forget about <em>this</em> {@link Link} (no longer refer it)!
     */
    void unlink();
}
