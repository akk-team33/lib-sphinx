package de.team33.gen.sphinx.alpha.visual;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class SetupInterfaceSource {

    private static final String FORMAT = //
            "%n%n" +
            "    /**%n" +
            "     * Utility interface to set up a target instance of {@link %1$s}.%n" +
            "     * %n" +
            "     * @param <T> The final type of the target instance, at least {@link %1$s}.%n" +
            "     * @param <S> The final type of the Setup implementation.%n" +
            "     */%n" +
            "    public interface Setup<T extends %1$s, S extends Setup<T, S>> extends %2$ss.Setup<T, S> {%3$s%n" +
            "    }";

    private final String target;
    private final String ancestor;
    private final String methods;
    private final Set<Class<?>> dependencies;

    public SetupInterfaceSource(final Class<?> componentClass) {
        this.dependencies = new HashSet<>(Arrays.asList(componentClass, componentClass.getSuperclass()));
        this.target = componentClass.getSimpleName();
        this.ancestor = componentClass.getSuperclass().getSimpleName();
        this.methods = Stream.of(componentClass.getMethods())
                             .filter(method -> !Modifier.isStatic(method.getModifiers()))
                             .filter(method -> method.getDeclaringClass().equals(componentClass))
                             .filter(method -> Stream.of("set", "add", "remove")
                                                     .anyMatch(prefix -> method.getName().startsWith(prefix)))
                             .filter(method -> !method.getName().endsWith("Listener"))
                             .filter(method -> !method.getName().endsWith("Notify"))
                             .map(SetupMethodSource::new)
                             .peek(source -> dependencies.addAll(source.getDependencies()))
                             .sorted(comparing(SetupMethodSource::getSignature))
                             .map(SetupMethodSource::toString)
                             .collect(Collectors.joining());
    }

    public Set<Class<?>> getDependencies() {
        return dependencies;
    }

    @Override
    public String toString() {
        return String.format(FORMAT, target, ancestor, methods);
    }

    public static void main(String[] args) {
        final SetupInterfaceSource source = new SetupInterfaceSource(Container.class);
        source.getDependencies().forEach(System.out::println);
        System.out.println(source);
    }
}
