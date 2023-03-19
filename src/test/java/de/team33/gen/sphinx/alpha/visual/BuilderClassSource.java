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
            "     * @param <B> The final type of the Builder implementation.%n" +
            "     */%n" +
            "    public static class Builder<T extends %1$s, B extends Builder<T, B>>%n" +
            "            extends LateBuilder<T, B> implements Setup<T, B> {%n%n" +
            "        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {%n" +
            "            super(newResult, builderClass);%n" +
            "        }%n" +
            "    }";

    private final String targetClassName;

    public BuilderClassSource(final Class<?> componentClass) {
        this.targetClassName = componentClass.getSimpleName();
    }

    @Override
    public String toString() {
        return format(CODE_FORMAT, targetClassName);
    }

    public static void main(String[] args) {
        final BuilderClassSource source = new BuilderClassSource(Container.class);
        System.out.println(source);
    }
}
