package de.team33.sphinx.generation.alpha.option;

import java.awt.*;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;

public class GridBagAnchor {

    private static final String FORMAT = "%n" +
            "            /**%n" +
            "             * @see GridBagConstraints#%1$s%n" +
            "             */%n" +
            "            %1$s(GridBagConstraints.%1$s),";

    public static void main(String[] args) {
        Stream.of(GridBagConstraints.class.getFields())
              .filter(field -> Modifier.isStatic(field.getModifiers()))
              .map(field -> String.format(FORMAT, field.getName()))
              .forEach(System.out::println);
    }
}
