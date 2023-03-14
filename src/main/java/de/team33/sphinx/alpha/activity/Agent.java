package de.team33.sphinx.alpha.activity;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class Agent<C, L, M> implements Context<C, M> {

    private final BiConsumer<C, L> addition;
    private final Function<Consumer<M>, L> mapping;

    public Agent(BiConsumer<C, L> addition, Function<Consumer<M>, L> mapping) {
        this.addition = addition;
        this.mapping = mapping;
    }

    @Override
    public void add(C component, Consumer<M> reaction) {
        addition.accept(component, mapping.apply(reaction));
    }
}
