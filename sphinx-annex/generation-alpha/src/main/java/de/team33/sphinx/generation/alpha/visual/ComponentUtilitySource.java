package de.team33.sphinx.generation.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComponentUtilitySource {

    private static final String METHOD1_FORMAT = //
            "%n%n" +
            "    /**%n" +
            "     * Returns a new {@link Builder} for target instances of type {@link %1$s}.%n" +
            "     */%n" +
            "    public static Builder<%1$s> builder() {%n" +
            "        return new Builder<>(%1$s::new, Builder.class);%n" +
            "    }";
    private static final String METHOD2_FORMAT = //
            "%n%n" +
            "    /**%n" +
            "     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.%n" +
            "     * %n" +
            "     * @param <T> The final type of the target instances, at least {@link %1$s}.%n" +
            "     */%n" +
            "    public static <T extends %1$s> Builder<T> builder(final Supplier<T> newTarget) {%n" +
            "        return new Builder<>(newTarget, Builder.class);%n" +
            "    }";
    private static final String METHOD3_FORMAT = //
            "%n%n" +
            "    /**%n" +
            "     * Returns a new {@link Charger} for a given target instance.%n" +
            "     * %n" +
            "     * @param <T> The final type of the target instance, at least {@link %1$s}.%n" +
            "     */%n" +
            "    public static <T extends %1$s> Charger<T> charger(final T target) {%n" +
            "        return new Charger<>(target, Charger.class);%n" +
            "    }";
    private static final String FORMAT = //
            "package de.team33.sphinx.alpha.visual;%n%n" +
            "%6$s%n%n" +
            "/**%n" +
            " * Utility class to handle {@link %1$s}s.%n" +
            " */%n" +
            "@SuppressWarnings(\"unused\")%n" +
            "public final class %7$s {%n" +
            "%n" +
            "    private %7$s() {%n" +
            "    }%2$s%3$s%9$s%4$s%8$s%5$s%n" +
            "}%n";

    private final String target;
    private final String name;
    private final String factoryMethod1;
    private final String factoryMethod2;
    private final String factoryMethod3;
    private final BuilderClassSource builderSource;
    private final ChargerClassSource chargerSource;
    private final SetupInterfaceSource setupSource;
    private final String imports;
    private final Set<Class<?>> dependencies;

    public ComponentUtilitySource(final Class<?> componentClass) {
        this.dependencies = new HashSet<>(Arrays.asList(LateBuilder.class, Supplier.class));
        this.target = componentClass.getSimpleName();
        this.name = target + (Stream.of("s", "S", "x", "X").anyMatch(target::endsWith) ? "es" : "s");
        this.factoryMethod1 = hasDefaultConstructor(componentClass)
                ? String.format(METHOD1_FORMAT, target)
                : "";
        this.factoryMethod2 = String.format(METHOD2_FORMAT, target);
        this.factoryMethod3 = String.format(METHOD3_FORMAT, target);
        this.builderSource = new BuilderClassSource(componentClass);
        this.chargerSource = new ChargerClassSource(componentClass);
        this.setupSource = new SetupInterfaceSource(componentClass);
        dependencies.addAll(setupSource.getDependencies());
        this.imports = dependencies.stream()
                                   .map(c -> c.isArray() ? c.getComponentType() : c)
                                   .filter(c -> !c.isPrimitive())
                                   .filter(c -> !"java.lang".equals(c.getPackage().getName()))
                                   .map(Class::getCanonicalName)
                                   .collect(Collectors.toCollection(TreeSet::new))
                                   .stream()
                                   .map(s -> String.format("import %s;", s))
                                   .collect(Collectors.joining(String.format("%n")));
    }

    private static boolean hasDefaultConstructor(final Class<?> componentClass) {
        return isConcrete(componentClass) && Stream.of(componentClass.getConstructors())
                                                   .anyMatch(c -> c.getParameterCount() == 0);
    }

    private static boolean isConcrete(final Class<?> componentClass) {
        return 0 == (componentClass.getModifiers() & Modifier.ABSTRACT);
    }

    public final String getName() {
        return name;
    }

    @Override
    public final String toString() {
        return String.format(FORMAT,
                             target,
                             factoryMethod1,
                             factoryMethod2,
                             builderSource,
                             setupSource,
                             imports,
                             name,
                             chargerSource,
                             factoryMethod3);
    }

    public static void main(final String[] args) {
        final ComponentUtilitySource source = new ComponentUtilitySource(JFrame.class);
        System.out.println(source);
    }
}
