package de.team33.gen.sphinx.alpha.visual;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UtilityClass {

    private static final String METHOD1_FORMAT = "/**%n" +
            "     * Returns a new {@link Builder} for target instances of type {@link %1$s}.%n" +
            "     */%n" +
            "    public static Builder<%1$s, ?> builder() {%n" +
            "        return new Builder<>(%1$s::new, Builder.class);%n" +
            "    }%n%n    ";
    private static final String METHOD2_FORMAT = "/**%n" +
            "     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.%n" +
            "     * %n" +
            "     * @param <T> The final type of the target instances, at least {@link %1$s}.%n" +
            "     */%n" +
            "    public static <T extends %1$s> Builder<T, ?> builder(final Supplier<T> newTarget) {%n" +
            "        return new Builder<>(newTarget, Builder.class);%n" +
            "    }";
    private static final String CODE_FORMAT = "package de.team33.sphinx.alpha.visual;%n%n" +
            "import de.team33.patterns.building.elara.LateBuilder;%n" +
            "import java.util.function.Supplier;%n%n" +
            "%6$s%n%n" +
            "/**%n" +
            " * Utility class to handle {@link %1$s}s.%n" +
            " */%n" +
            "@SuppressWarnings(\"unused\")%n" +
            "public final class %1$ss {%n" +
            "%n" +
            "    %2$s%3$s%n" +
            "%n" +
            "    %4$s%n" +
            "%n" +
            "    %5$s%n" +
            "}%n";

    private final String subjectClassName;
    private final String builderMethod1;
    private final String builderMethod2;
    private final BuilderClass builderClass;
    private final SetupClass setupClass;
    private final String imports;

    public UtilityClass(final Class<?> componentClass) {
        this.setupClass = new SetupClass(componentClass);
        this.subjectClassName = componentClass.getSimpleName();
        this.builderClass = new BuilderClass(componentClass);
        this.builderMethod1 = hasDefaultConstructor(componentClass)
                ? String.format(METHOD1_FORMAT, subjectClassName)
                : "";
        this.builderMethod2 = String.format(METHOD2_FORMAT, subjectClassName);
        final Set<Class<?>> dependencies = new HashSet<>(setupClass.getDependencies());
        this.imports = dependencies.stream()
                                   .map(c -> c.isArray() ? c.getComponentType() : c)
                                   .filter(c -> !c.isPrimitive())
                                   .map(Class::getCanonicalName)
                                   .filter(s -> !s.startsWith("java.lang"))
                                   .sorted()
                                   .map(s -> String.format("import %s;", s))
                                   .collect(Collectors.joining(String.format("%n")));
    }

    private boolean hasDefaultConstructor(final Class<?> componentClass) {
        return Stream.of(componentClass.getConstructors())
                     .anyMatch(c -> c.getParameterCount() == 0);
    }

    @Override
    public String toString() {
        return String.format(CODE_FORMAT,
                             subjectClassName,
                             builderMethod1,
                             builderMethod2,
                             builderClass,
                             setupClass,
                             imports);
    }

    public String getName() {
        return subjectClassName + "s";
    }
}
