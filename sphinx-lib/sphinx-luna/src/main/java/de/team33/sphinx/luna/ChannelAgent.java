package de.team33.sphinx.luna;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

class ChannelAgent<C, L, M> implements Channel<C, M> {

    private final BiConsumer<? super C, ? super L> addition;
    private final Function<? super Consumer<M>, ? extends L> mapping;

    ChannelAgent(final BiConsumer<? super C, ? super L> addition,
                 final Function<? super Consumer<M>, ? extends L> mapping) {
        this.addition = addition;
        this.mapping = mapping;
    }

    @Override
    public final void add(final C component, final Consumer<M> reaction) {
        addition.accept(component, mapping.apply(reaction));
    }
}
