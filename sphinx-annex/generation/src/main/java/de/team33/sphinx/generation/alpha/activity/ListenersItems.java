package de.team33.sphinx.generation.alpha.activity;

import java.awt.*;
import java.awt.event.WindowListener;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListenersItems {

    private final List<ListenersItem> items;

    public ListenersItems(final Method addListenerMethod) {
        assert 1 == addListenerMethod.getParameterCount();
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        items = Stream.of(addListenerMethod.getParameterTypes()[0].getMethods())
                      .map(ListenersItem::new)
                      .collect(Collectors.toList());
    }

    @Override
    public final String toString() {
        return items.stream()
                    .map(ListenersItem::toString)
                    .collect(Collectors.joining());
    }

    public static void main(final String[] args) throws NoSuchMethodException {
        final Method addListenerMethod = Window.class.getMethod("addWindowListener",
                                                                WindowListener.class);
        final ListenersItems source = new ListenersItems(addListenerMethod);
        System.out.println(source);
    }
}
