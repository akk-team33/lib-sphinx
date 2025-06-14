package de.team33.sphinx.generation.alpha.visual;

import de.team33.sphinx.generation.Classes;

import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class Generator {

    private static final Logger LOG = Logger.getLogger(Generator.class.getCanonicalName());
    private static final Path PACKAGE_PATH = Paths.get("sphinx-lib", "sphinx-alpha", "src", "main", "java", "de", "team33", "sphinx", "alpha", "visual")
                                                  .toAbsolutePath()
                                                  .normalize();
    public static final OpenOption[] OPEN_OPTIONS = {
            //StandardOpenOption.CREATE_NEW,
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING
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
            LOG.log(INFO, () -> "failed (already existing?): " + fileName + " (" + filePath + ")");
        }
    }
}
