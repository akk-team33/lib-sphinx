package de.team33.sphinx.generation.alpha.visual;

import de.team33.sphinx.generation.alpha.Classes;

import java.awt.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.function.Predicate.not;

public class SetupInterfaceSource {

    private static final String FORMAT = //
            "%n%n" +
            "    /**%n" +
            "     * Utility interface to set up a target instance of {@link %1$s}.%n" +
            "     * %n" +
            "     * @param <T> The final type of the target instance, at least {@link %1$s}.%n" +
            "     * @param <S> The final type of the Setup implementation.%n" +
            "     */%n" +
            "    @SuppressWarnings(\"ClassNameSameAsAncestorName\")%n" +
            "    @FunctionalInterface%n" +
            "    public interface Setup<T extends %1$s, S extends Setup<T, S>> extends %2$ss.Setup<T, S> {%3$s%n" +
            "    }";

    private final String target;
    private final String ancestor;
    private final String methods;
    private final Set<Class<?>> dependencies;

    public SetupInterfaceSource(final Class<?> componentClass) {
        this.dependencies = new HashSet<>(Arrays.asList(componentClass));
        this.target = componentClass.getSimpleName();
        this.ancestor = componentClass.getSuperclass().getSimpleName();
        this.methods = Stream.of(componentClass.getMethods())
                             .filter(not(method -> Modifier.isStatic(method.getModifiers())))
                             .filter(not(Method::isSynthetic))
                             .filter(not(Method::isBridge))
                             .filter(not(method -> isDeprecated(method)))
                           //.filter(method -> componentClass.equals(method.getDeclaringClass())) // more specific ...
                             .filter(method -> Classes.isIntroducedBy(componentClass, method))
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

    private static boolean isDeprecated(final Method method) {
        return null != method.getAnnotation(Deprecated.class);
    }

    public final Set<Class<?>> getDependencies() {
        return dependencies;
    }

    @Override
    public final String toString() {
        return String.format(FORMAT, target, ancestor, methods);
    }

    public static void main(final String[] args) {
        final SetupInterfaceSource source = new SetupInterfaceSource(Container.class);
        source.getDependencies().forEach(System.out::println);
        System.out.println(source);
    }
}
