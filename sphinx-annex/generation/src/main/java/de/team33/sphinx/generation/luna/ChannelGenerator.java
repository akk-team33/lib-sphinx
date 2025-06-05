package de.team33.sphinx.generation.luna;

import de.team33.sphinx.generation.Classes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ChannelGenerator {

    private final List<ChannelItems> content;

    ChannelGenerator(final Class<?> componentClass) {
        this.content = Stream.of(componentClass.getMethods())
                             .filter(method -> componentClass.equals(method.getDeclaringClass()))
                             .filter(method -> method.getName().startsWith("add"))
                             .filter(method -> method.getName().endsWith("Listener"))
                             .filter(method -> 1 == method.getParameterCount())
                             .map(ChannelItems::new)
                             .collect(Collectors.toList());
    }

    final boolean isStuff() {
        return 0 < content.size();
    }

    @Override
    public final String toString() {
        return content.stream()
                      .map(ChannelItems::toString)
                      .collect(Collectors.joining());
    }

    public static void main(final String[] args) {
        Classes.stream()
               .map(ChannelGenerator::new)
               .filter(ChannelGenerator::isStuff)
               .forEach(System.out::print);
    }
}
