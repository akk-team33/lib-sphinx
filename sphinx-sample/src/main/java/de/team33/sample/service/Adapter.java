package de.team33.sample.service;

import java.util.function.Consumer;

public interface Adapter<T> extends Consumer<T>, Emitter<T> {

    static <T> Adapter<T> compose(final Consumer<T> consumer, final Emitter<T> emitter) {
        return new Adapter<T>() {

            @Override
            public void connect(final Consumer<T> listener) {
                emitter.connect(listener);
            }

            @Override
            public void accept(final T value) {
                consumer.accept(value);
            }
        };
    }
}
