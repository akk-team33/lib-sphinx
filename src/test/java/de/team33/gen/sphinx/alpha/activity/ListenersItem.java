package de.team33.gen.sphinx.alpha.activity;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ListenersItem {

    private static final String FORMAT = //
            "%n%n" +
            "    /**%n" +
            "     * Converts a given {@link Consumer} into a {@link %1$s}%n" +
            "     * that reacts on a specific {@link %3$s}.%n" +
            "     * %n" +
            "     * @see %1$s#%2$s(%3$s)%n" +
            "     */%n" +
            "    public static %1$s %2$s(final Consumer<%3$s> reaction) {%n" +
            "        return new %4$s() {%n" +
            "            @Override%n" +
            "            public void %2$s(final %3$s e) {%n" +
            "                reaction.accept(e);%n" +
            "            }%n" +
            "        };%n" +
            "    }";

    private final Set<Class<?>> dependencies;
    private final String eventClassName;
    private final String listenerClassName;
    private final String listenerMethodName;
    private final String adapterClassName;

    public ListenersItem(final Method listenerMethod) {
        assert 1 == listenerMethod.getParameterCount();
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        final Class<?> listenerClass = listenerMethod.getDeclaringClass();
        final Class<?> eventClass = listenerMethod.getParameterTypes()[0];
        this.dependencies = new HashSet<>(Arrays.asList(listenerClass, eventClass));
        this.eventClassName = eventClass.getSimpleName();
        this.listenerClassName = listenerClass.getSimpleName();
        this.listenerMethodName = listenerMethod.getName();
        this.adapterClassName = listenerClassName.replace("Listener", "Adapter");
    }

    @Override
    public String toString() {
        return String.format(FORMAT, listenerClassName, listenerMethodName, eventClassName, adapterClassName);
    }

    public static void main(String[] args) throws NoSuchMethodException {
        final Method listenerMethod = WindowListener.class.getMethod("windowClosing",
                                                                     WindowEvent.class);
        final ListenersItem source = new ListenersItem(listenerMethod);
        System.out.println(source);
    }
}
