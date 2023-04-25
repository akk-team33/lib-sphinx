package de.team33.gen.sphinx.alpha.activity;

import de.team33.gen.sphinx.alpha.Classes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ListenersGenerator {

    private final List<ListenersItems> content;

    ListenersGenerator(final Class<?> componentClass) {
        this.content = Stream.of(componentClass.getMethods())
                             .filter(method -> componentClass.equals(method.getDeclaringClass()))
                             .filter(method -> method.getName().startsWith("add"))
                             .filter(method -> method.getName().endsWith("Listener"))
                             .filter(method -> 1 == method.getParameterCount())
                             .map(ListenersItems::new)
                             .collect(Collectors.toList());
    }

    final boolean isStuff() {
        return 0 < content.size();
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
               .filter(ListenersGenerator::isStuff)
               .forEach(System.out::print);
    }
}
