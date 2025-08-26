package de.team33.sphinx.luna;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

class ChannelAgent<C, L, M> implements Channel<C, M> {

    private final BiConsumer<? super C, ? super L> addition;
    private final BiConsumer<? super C, ? super L> removal;
    private final Function<? super Consumer<M>, ? extends L> mapping;

    ChannelAgent(final BiConsumer<? super C, ? super L> addition,
                 final BiConsumer<? super C, ? super L> removal,
                 final Function<? super Consumer<M>, ? extends L> mapping) {
        this.addition = addition;
        this.removal = removal;
        this.mapping = mapping;
    }

    @Override
    public final Subscription subscribe(final C component, final Consumer<M> listener) {
        final L swingListener = mapping.apply(listener);
        addition.accept(component, swingListener);
        return () -> removal.accept(component, swingListener);
    }
}
