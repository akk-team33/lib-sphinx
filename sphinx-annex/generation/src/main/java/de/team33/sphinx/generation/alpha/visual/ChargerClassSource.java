package de.team33.sphinx.generation.alpha.visual;

import java.awt.*;

import static java.lang.String.format;

public class ChargerClassSource {

    private static final String CODE_FORMAT = //
            "%n%n" +
            "    /**%n" +
            "     * Charger implementation to charge target instances of {@link %1$s}.%n" +
            "     * %n" +
            "     * @param <T> The final type of the target instance, at least {@link %1$s}.%n" +
            "     */%n" +
            "    public static final class Charger<T extends %1$s>%n" +
            "            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>%n" +
            "            implements Setup<T, Charger<T>> {%n%n" +
            "        @SuppressWarnings({\"rawtypes\", \"unchecked\"})%n" +
            "        private Charger(final T target, final Class chargerClass) {%n" +
            "            super(target, chargerClass);%n" +
            "        }%n" +
            "    }";

    private final String targetClassName;

    public ChargerClassSource(final Class<?> componentClass) {
        this.targetClassName = componentClass.getSimpleName();
    }

    @Override
    public final String toString() {
        return format(CODE_FORMAT, targetClassName);
    }

    public static void main(final String[] args) {
        final ChargerClassSource source = new ChargerClassSource(Container.class);
        System.out.println(source);
    }
}
