package de.team33.sphinx.generation.alpha.activity;

import de.team33.sphinx.generation.Classes;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ListenersGenerator {

    private final List<ListenersItems> content;

    ListenersGenerator(final Class<?> componentClass) {
        this.content = Stream.of(componentClass.getMethods())
                             .filter(method -> componentClass.equals(method.getDeclaringClass()))
                           //.filter(method -> Classes.isIntroducedBy(componentClass, method)) // <- TODO?
                             .filter(method -> method.getName().startsWith("add"))
                             .filter(method -> method.getName().endsWith("Listener"))
                             .filter(method -> 1 == method.getParameterCount())
                             .map(ListenersItems::new)
                             .collect(Collectors.toList());
    }

    final boolean isEmpty() {
        return content.isEmpty();
    }

    @Override
    public final String toString() {
        return content.stream()
                      .map(ListenersItems::toString)
                      .collect(Collectors.joining());
    }

    public static void main(final String[] args) {
        Classes.stream()
               .map(ListenersGenerator::new)
               .filter(not(ListenersGenerator::isEmpty))
               .forEach(System.out::print);
    }

    private static <T> Predicate<T> not(final Predicate<T> predicate) {
        return predicate.negate();
    }
}
