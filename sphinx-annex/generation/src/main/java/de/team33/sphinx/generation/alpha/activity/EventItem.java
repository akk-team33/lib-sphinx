package de.team33.sphinx.generation.alpha.activity;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.Method;

public class EventItem {

    private static final String FORMAT = //
            "%n%n" +
            "    /**%n" +
            "     * Represents an event that can occur on {@link %1$s}s.%n" +
            "     *%n" +
            "     * @see %6$s#%5$s(%2$s)%n" +
            "     * @see %1$s#%4$s(%6$s)%n" +
            "     */%n" +
            "    Event<%1$s, %2$s> %3$s =%n" +
            "            new EventAgent<>(%1$s::%4$s, Listeners::%5$s).event();";

    private final String addListenerClassName;
    private final String eventClassName;
    private final String itemName;
    private final String addListenerMethodName;
    private final String toListenerMethodName;
    private final String listenerClassName;

    public EventItem(final Method addListenerMethod, final Method listenerMethod) {
        assert 1 == addListenerMethod.getParameterCount();
        assert 1 == listenerMethod.getParameterCount();
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        final Class<?> addListenerClass = addListenerMethod.getDeclaringClass();
        final Class<?> eventClass = listenerMethod.getParameterTypes()[0];
        final Class<?> listenerClass = addListenerMethod.getParameterTypes()[0];
        this.addListenerClassName = addListenerClass.getSimpleName();
        this.listenerClassName = listenerClass.getSimpleName();
        this.eventClassName = eventClass.getSimpleName();
        this.itemName = camelToUpperCase(listenerMethod.getName());
        this.addListenerMethodName = addListenerMethod.getName();
        this.toListenerMethodName = listenerMethod.getName();
    }

    private static String camelToUpperCase(final String input) {
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); ++i) {
            final char c = input.charAt(i);
            if (Character.isUpperCase(c)) {
                result.append('_')
                      .append(c);
            } else {
                result.append(Character.toUpperCase(c));
            }
        }
        return result.toString();
    }

    @Override
    public final String toString() {
        return String.format(FORMAT,
                             addListenerClassName,
                             eventClassName,
                             itemName,
                             addListenerMethodName,
                             toListenerMethodName,
                             listenerClassName);
    }

    public static void main(final String[] args) throws NoSuchMethodException {
        final Method addListenerMethod = Window.class.getMethod("addWindowListener",
                                                                WindowListener.class);
        final Method listenerMethod = WindowListener.class.getMethod("windowClosing",
                                                                     WindowEvent.class);
        final EventItem source = new EventItem(addListenerMethod, listenerMethod);
        System.out.println(source);
    }
}
