package de.team33.gen.sphinx.alpha.visual;

import de.team33.gen.sphinx.alpha.Classes;

import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Generator {

    private static final Logger LOG = Logger.getLogger(Generator.class.getCanonicalName());
    private static final Path PACKAGE_PATH = Paths.get("src", "main", "java", "de", "team33", "sphinx", "alpha", "visual")
                                                  .toAbsolutePath()
                                                  .normalize();
    public static final OpenOption[] OPEN_OPTIONS = {
            StandardOpenOption.CREATE_NEW,
            // StandardOpenOption.CREATE,
            // StandardOpenOption.TRUNCATE_EXISTING
    }; // <-- overwrite or not?

    public static void main(final String[] args) {
        Classes.stream()
               .filter(c -> !c.equals(Component.class)) // skip anyway!
               .filter(Component.class::isAssignableFrom)
               .map(ComponentUtilitySource::new)
               //.forEach(System.out::println);
               .forEach(Generator::write);
    }

    private static void write(final ComponentUtilitySource source) {
        final String fileName = source.getName() + ".java";
        final Path filePath = PACKAGE_PATH.resolve(fileName);
        try {
            Files.write(filePath, source.toString().getBytes(StandardCharsets.UTF_8), OPEN_OPTIONS);
        } catch (final IOException e) {
            LOG.info(() -> "failed (already existing?): " + fileName + " (" + filePath + ")");
        }
    }

    private static Stream<Class<?>> ancestors(final Class<?> subject) {
        return (null == subject)
                ? Stream.empty()
                : Stream.concat(ancestors(subject.getSuperclass()),
                                Stream.of(subject));
    }
}
