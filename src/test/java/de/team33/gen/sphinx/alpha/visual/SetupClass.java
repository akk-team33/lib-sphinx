package de.team33.gen.sphinx.alpha.visual;

import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.util.stream.Collectors.joining;

public class SetupClass {

    private static final String SPACE = format("%n%n        ");
    private static final String INTRO_FORMAT = "/**%n" +
            "     * Utility interface to set up a target instance of {@link %1$s}.%n" +
            "     * %n" +
            "     * @param <T> The final type of the target instance, at least {@link %1$s}.%n" +
            "     * @param <S> The final type of the Setup implementation.%n" +
            "     */%n" +
            "    public interface Setup<T extends %1$s, S extends Setup<T, S>> extends %2$s.Setup<T, S> {" + SPACE;
    private static final String TAIL = format("%n    }");

    private final String componentClassName;
    private final String superUtilityClassName;
    private final List<SetupDefaultMethod> methods;
    private final Set<Class<?>> dependencies = new HashSet<>();

    public SetupClass(final Class<?> componentClass) {
        componentClassName = componentClass.getSimpleName();
        superUtilityClassName = componentClass.getSuperclass().getSimpleName() + "s";
        methods = Stream.of(componentClass.getMethods())
                        .filter(method -> !Modifier.isStatic(method.getModifiers()))
                        .filter(method -> method.getDeclaringClass().equals(componentClass))
                        .filter(method -> Stream.of("set", "add", "remove")
                                                .anyMatch(prefix -> method.getName().startsWith(prefix)))
                        .filter(method -> !method.getName().endsWith("Listener"))
                        .map(SetupDefaultMethod::new)
                        .collect(Collectors.toList());
        dependencies.add(componentClass);
        methods.forEach(method -> dependencies.addAll(method.getDependencies()));
    }

    @Override
    public String toString() {
        return methods.stream()
                      .map(SetupDefaultMethod::toString)
                      .collect(joining(SPACE,
                                       format(INTRO_FORMAT,
                                              componentClassName,
                                              superUtilityClassName),
                                       TAIL));
    }

    public Set<Class<?>> getDependencies() {
        return dependencies;
    }
}
