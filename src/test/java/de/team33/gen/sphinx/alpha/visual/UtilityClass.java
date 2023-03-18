package de.team33.gen.sphinx.alpha.visual;

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
            "import de.team33.patterns.building.elara.LateBuilder;%n%n" +
            "import java.awt.*;%n" +
            "import javax.swing.*;%n%n" +
            "/**%n" +
            " * Utility class to handle {@link %1$s}s.%n" +
            " */%n" +
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

    public UtilityClass(final Class<?> componentClass) {
        this.setupClass = new SetupClass(componentClass);
        this.subjectClassName = componentClass.getSimpleName();
        this.builderClass = new BuilderClass(componentClass);
        this.builderMethod1 = String.format(METHOD1_FORMAT, subjectClassName);
        this.builderMethod2 = String.format(METHOD2_FORMAT, subjectClassName);
    }

    @Override
    public String toString() {
        return String.format(CODE_FORMAT,
                             subjectClassName,
                             builderMethod1,
                             builderMethod2,
                             builderClass,
                             setupClass);
    }

    public String getName() {
        return subjectClassName + "s";
    }
}
