package de.team33.sphinx.sample.alpha.services;

import de.team33.sphinx.sample.alpha.service.Emitter;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface Adapter<T> extends Consumer<T>, Supplier<T>, Emitter<T> {

    static <T> Adapter<T> compose(final Supplier<T> getter, final Consumer<T> setter, final Emitter<T> emitter) {
        return new Adapter<T>() {

            @Override
            public T get() {
                return getter.get();
            }

            @Override
            public void accept(final T value) {
                setter.accept(value);
            }

            @Override
            public void connect(final Consumer<T> listener) {
                emitter.connect(listener);
            }
        };
    }
}
