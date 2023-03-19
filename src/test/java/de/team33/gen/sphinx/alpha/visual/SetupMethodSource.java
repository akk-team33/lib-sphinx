package de.team33.gen.sphinx.alpha.visual;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SetupMethodSource {

    private static final String FORMAT = //
            "%n%n" +
            "        /**%n" +
            "         * @see %1$s#%2$s(%3$s)%n" +
            "         */%n" +
            "        default S %2$s(%4$s) {%n" +
            "            return setup(result -> result.%2$s(%5$s));%n" +
            "        }";

    private final String target;
    private final String name;
    private final String parameterTypes;
    private final String formalParameters;
    private final String actualParameters;
    private final Set<Class<?>> dependencies = new HashSet<>();

    public SetupMethodSource(final Method method) {
        this.target = method.getDeclaringClass().getSimpleName();
        this.name = method.getName();
        this.parameterTypes = Stream.of(method.getParameterTypes())
                                    .peek(dependencies::add)
                                    .map(Class::getSimpleName)
                                    .collect(Collectors.joining(", "));
        this.formalParameters = Stream.of(method.getParameters())
                                      .map(parameter -> "final " + parameter)
                                      .map(s -> simplified(s, dependencies))
                                      .collect(Collectors.joining(", "));
        this.actualParameters = Stream.of(method.getParameters())
                                      .map(Parameter::getName)
                                      .collect(Collectors.joining(", "));
    }

    private static String simplified(final String parameter, final Set<Class<?>> dependencies) {
        String result = parameter;
        for (final Class<?> dependency : dependencies) {
            result = result.replace(dependency.getName(), dependency.getSimpleName());
        }
        return result;
    }

    public Set<Class<?>> getDependencies() {
        return dependencies;
    }

    public String getSignature() {
        return "S " + name + "(" + parameterTypes + ")";
    }

    @Override
    public String toString() {
        return String.format(FORMAT, target, name, parameterTypes, formalParameters, actualParameters);
    }

    public static void main(String[] args) throws NoSuchMethodException {
        final Method method = Container.class.getMethod("setFocusTraversalKeys", int.class, Set.class);
        final SetupMethodSource source = new SetupMethodSource(method);
        source.getDependencies().forEach(System.out::println);
        System.out.println(source);
    }
}
