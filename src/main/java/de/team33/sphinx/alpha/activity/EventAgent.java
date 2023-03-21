package de.team33.sphinx.alpha.activity;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

class EventAgent<C, L, M> {

    private final BiConsumer<? super C, ? super L> addition;
    private final Function<? super Consumer<M>, ? extends L> mapping;

    EventAgent(final BiConsumer<? super C, ? super L> addition,
               final Function<? super Consumer<M>, ? extends L> mapping) {
        this.addition = addition;
        this.mapping = mapping;
    }

    final void add(final C component, final Consumer<M> reaction) {
        addition.accept(component, mapping.apply(reaction));
    }
}
