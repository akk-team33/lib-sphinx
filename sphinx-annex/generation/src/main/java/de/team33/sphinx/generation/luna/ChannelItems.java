package de.team33.sphinx.generation.luna;

import java.awt.*;
import java.awt.event.WindowListener;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ChannelItems {

    private final List<ChannelItem> items;

    ChannelItems(final Method addListenerMethod) {
        assert 1 == addListenerMethod.getParameterCount();
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        items = Stream.of(addListenerMethod.getParameterTypes()[0].getMethods())
                      .map(listenerMethod -> new ChannelItem(addListenerMethod, listenerMethod))
                      .collect(Collectors.toList());
    }

    @Override
    public final String toString() {
        return items.stream()
                    .map(ChannelItem::toString)
                    .collect(Collectors.joining());
    }

    public static void main(final String[] args) throws NoSuchMethodException {
        final Method addListenerMethod = Window.class.getMethod("addWindowListener",
                                                                WindowListener.class);
        final ChannelItems source = new ChannelItems(addListenerMethod);
        System.out.println(source);
    }
}
