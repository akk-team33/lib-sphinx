package de.team33.sphinx.generation.alpha.activity;

import de.team33.sphinx.generation.Classes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class EventGenerator {

    private final List<EventItems> content;

    EventGenerator(final Class<?> componentClass) {
        this.content = Stream.of(componentClass.getMethods())
                             .filter(method -> componentClass.equals(method.getDeclaringClass()))
                             .filter(method -> method.getName().startsWith("add"))
                             .filter(method -> method.getName().endsWith("Listener"))
                             .filter(method -> 1 == method.getParameterCount())
                             .map(EventItems::new)
                             .collect(Collectors.toList());
    }

    final boolean isStuff() {
        return 0 < content.size();
    }

    @Override
    public final String toString() {
        return content.stream()
                      .map(EventItems::toString)
                      .collect(Collectors.joining());
    }

    public static void main(final String[] args) {
        Classes.stream()
               .map(EventGenerator::new)
               .filter(EventGenerator::isStuff)
               .forEach(System.out::print);
    }
}
