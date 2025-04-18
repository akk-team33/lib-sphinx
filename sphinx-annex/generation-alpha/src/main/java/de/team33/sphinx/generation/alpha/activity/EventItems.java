package de.team33.sphinx.generation.alpha.activity;

import java.awt.*;
import java.awt.event.WindowListener;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EventItems {

    private final List<EventItem> items;

    public EventItems(final Method addListenerMethod) {
        assert 1 == addListenerMethod.getParameterCount();
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        items = Stream.of(addListenerMethod.getParameterTypes()[0].getMethods())
                      .map(listenerMethod -> new EventItem(addListenerMethod, listenerMethod))
                      .collect(Collectors.toList());
    }

    @Override
    public final String toString() {
        return items.stream()
                    .map(EventItem::toString)
                    .collect(Collectors.joining());
    }

    public static void main(final String[] args) throws NoSuchMethodException {
        final Method addListenerMethod = Window.class.getMethod("addWindowListener",
                                                                WindowListener.class);
        final EventItems source = new EventItems(addListenerMethod);
        System.out.println(source);
    }
}
