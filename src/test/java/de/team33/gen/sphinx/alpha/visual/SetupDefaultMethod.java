package de.team33.gen.sphinx.alpha.visual;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SetupDefaultMethod {

    public static final String CODE_FORMAT = "/**%n" +
            "         * @see %4$s#%1$s(%5$s)%n" +
            "         */%n" +
            "        default S %1$s(%2$s) {%n" +
            "            return setup(result -> result.%1$s(%3$s));%n" +
            "        }";

    private final String name;
    private final String formalParameters;
    private final String actualParameters;
    private final String declaring;
    private final String paramTypes;
    private final Set<Class<?>> dependencies;

    public SetupDefaultMethod(final Method method) {
        this.declaring = method.getDeclaringClass().getSimpleName();
        this.name = method.getName();
        this.formalParameters = Stream.of(method.getParameters())
                                      .map(param -> String.format("final %s %s",
                                                                  param.getType().getSimpleName(),
                                                                  param.getName()))
                                      .collect(Collectors.joining(", "));
        this.actualParameters = Stream.of(method.getParameters())
                                      .map(Parameter::getName)
                                      .collect(Collectors.joining(", "));
        this.paramTypes = Stream.of(method.getParameters())
                                .map(param -> param.getType().getSimpleName())
                                .collect(Collectors.joining(", "));
        this.dependencies = Stream.of(method.getParameters())
                                  .map(Parameter::getType)
                                  .collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return String.format(CODE_FORMAT, name, formalParameters, actualParameters, declaring, paramTypes);
    }

    public Set<Class<?>> getDependencies() {
        return dependencies;
    }
}
