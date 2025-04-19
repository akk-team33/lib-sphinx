package de.team33.sphinx.sample.alpha.services;

public interface Adaption<C, T> {

    Adapter<T> adapter(C context);
}
