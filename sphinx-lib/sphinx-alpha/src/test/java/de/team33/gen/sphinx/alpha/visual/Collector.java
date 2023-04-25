package de.team33.gen.sphinx.alpha.visual;

import de.team33.gen.sphinx.alpha.ClassPath;

import java.awt.*;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Collector {

    private static final Logger LOG = Logger.getLogger(Collector.class.getCanonicalName());

    public static void main(final String[] args) {
        final Set<? extends Class<?>> classes = ClassPath.classNames()
                                                         .filter(name -> name.startsWith("javax.swing"))
                                                         .map(Collector::toClass)
                                                         .filter(Objects::nonNull)
                                                         .filter(c -> c.getSimpleName().startsWith("J"))
                                                         .filter(Component.class::isAssignableFrom)
                                                         .collect(Collectors.toSet());
        //classes.forEach(System.out::println);
        final String collected = classes.stream()
                                        .map(Class::getSimpleName)
                                        .map(name -> name + ".class")
                                        .collect(Collectors.joining(String.format(",%n"), "CANDIDATES = Arrays.asList(", ");"));
        System.out.println(collected);
    }

    private static Class<?> toClass(final String name) {
        try {
            return Class.forName(name);
        } catch (final ClassNotFoundException e) {
            LOG.info("cannot load class " + name);
            return null;
        }
    }
}
