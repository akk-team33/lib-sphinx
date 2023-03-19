package de.team33.gen.sphinx.alpha.activity;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EventItem {

    private static final String FORMAT = "%n%n" +
            "    public static final Event<%1$s, %2$s> %3$s =%n" +
            "            new Agent<>(%1$s::%4$s, Listeners::%5$s);";

    private final Set<Class<?>> dependencies;
    private final String addListenerClassName;
    private final String eventClassName;
    private final String itemName;
    private final String addListenerMethodName;
    private final String toListenerMethodName;

    public EventItem(final Method addListenerMethod, final Method listenerMethod) {
        assert 1 == listenerMethod.getParameterCount();
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        final Class<?> addListenerClass = addListenerMethod.getDeclaringClass();
        final Class<?> eventClass = listenerMethod.getParameterTypes()[0];
        this.dependencies = new HashSet<>(Arrays.asList(addListenerClass, eventClass));
        this.addListenerClassName = addListenerClass.getSimpleName();
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
    public String toString() {
        return String.format(FORMAT,
                             addListenerClassName,
                             eventClassName,
                             itemName,
                             addListenerMethodName,
                             toListenerMethodName);
    }

    public static void main(String[] args) throws NoSuchMethodException {
        final Method addListenerMethod = Window.class.getMethod("addWindowListener",
                                                                WindowListener.class);
        final Method listenerMethod = WindowListener.class.getMethod("windowClosing",
                                                                     WindowEvent.class);
        final EventItem source = new EventItem(addListenerMethod, listenerMethod);
        System.out.println(source);
    }
}
