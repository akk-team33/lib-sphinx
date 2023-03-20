package de.team33.sphinx.alpha.activity;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

class Agent<C, L, M> {

    private final BiConsumer<C, L> addition;
    private final Function<Consumer<M>, L> mapping;

    Agent(final BiConsumer<C, L> addition, final Function<Consumer<M>, L> mapping) {
        this.addition = addition;
        this.mapping = mapping;
    }

    Event<C, M> event() {
        return (component, reaction) -> addition.accept(component, mapping.apply(reaction));
    }
}
