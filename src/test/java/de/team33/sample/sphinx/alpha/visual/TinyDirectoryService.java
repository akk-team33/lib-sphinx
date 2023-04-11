package de.team33.sample.sphinx.alpha.visual;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TinyDirectoryService {

    private Path path = Paths.get(".").toAbsolutePath().normalize();

    public final void setPath(final Path path) {
        this.path = path.toAbsolutePath().normalize();
    }

    public final Path getPath() {
        return path;
    }

    public final List<Path> list() {
        return Stream.concat(upper(path), lower(path).stream())
                     .collect(Collectors.toList());
    }

    private static List<Path> lower(final Path path) {
        try (final Stream<Path> stream = Files.list(path)) {
            return stream.filter(Files::isDirectory)
                         .collect(Collectors.toList());
        } catch (final IOException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    private static Stream<Path> upper(final Path path) {
        return (null == path) ? Stream.empty() : Stream.concat(upper(path.getParent()), Stream.of(path));
    }
}
