package de.team33.sphinx.luna;

/**
 * Represents a link between two instances that may need to be {@link #unlink() unlinked} later.
 */
@FunctionalInterface
public interface Link {

    /**
     * Unlinks <em>this</em> {@link Link}.
     * After that, it’s best to forget about <em>this</em> {@link Link} (no longer refer it)!
     */
    void unlink();
}
