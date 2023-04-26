package de.team33.sample.services;

public interface Adaption<C, T> {

    Adapter<T> adapter(C context);
}
