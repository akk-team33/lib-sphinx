package de.team33.gen.sphinx.alpha.visual;

import java.awt.*;

import static java.lang.String.format;

public class BuilderClassSource {

    private static final String CODE_FORMAT = //
            "%n%n" +
            "    /**%n" +
            "     * Builder implementation to build target instances of {@link %1$s}.%n" +
            "     * %n" +
            "     * @param <T> The final type of the target instances, at least {@link %1$s}.%n" +
            "     */%n" +
            "    public static final class Builder<T extends %1$s>%n" +
            "            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {%n%n" +
            "        @SuppressWarnings({\"rawtypes\", \"unchecked\"})%n" +
            "        private Builder(final Supplier<T> newResult, final Class builderClass) {%n" +
            "            super(newResult, builderClass);%n" +
            "        }%n" +
            "    }";

    private final String targetClassName;

    public BuilderClassSource(final Class<?> componentClass) {
        this.targetClassName = componentClass.getSimpleName();
    }

    @Override
    public final String toString() {
        return format(CODE_FORMAT, targetClassName);
    }

    public static void main(final String[] args) {
        final BuilderClassSource source = new BuilderClassSource(Container.class);
        System.out.println(source);
    }
}
