package de.team33.sphinx.luna;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

class ChannelAgent<C, L, M> implements Channel<C, M> {

    private final BiConsumer<? super C, ? super L> addition;
    private final BiConsumer<? super C, ? super L> removal;
    private final Function<? super Consumer<M>, ? extends L> mapping;

    ChannelAgent(final BiConsumer<? super C, ? super L> addition,
                 final Function<? super Consumer<M>, ? extends L> mapping) {
        this(addition, null, mapping);
    }

    ChannelAgent(final BiConsumer<? super C, ? super L> addition,
                 final BiConsumer<? super C, ? super L> removal,
                 final Function<? super Consumer<M>, ? extends L> mapping) {
        this.addition = addition;
        this.removal = removal;
        this.mapping = mapping;
    }

    @SuppressWarnings("ReturnOfNull")
    @Override
    public final Link add(final C component, final Consumer<M> reaction) {
        final L swingListener = mapping.apply(reaction);
        addition.accept(component, swingListener);
        return (null == removal) ? null : () -> removal.accept(component, swingListener);
    }
}
