package de.team33.sample.sphinx.alpha.visual.dirselect;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("WeakerAccess")
public class TinyDirectoryService {

    private final Object monitor = new Object();
    private List<Consumer<Path>> listeners = Collections.emptyList();
    private volatile Path path = Paths.get(".").toAbsolutePath().normalize();

    public final void addListener(final Consumer<Path> listener) {
        synchronized (monitor) {
            final List<Consumer<Path>> newListeners = new ArrayList<>(listeners.size() + 1);
            newListeners.addAll(listeners);
            newListeners.add(listener);
            listeners = newListeners;
        }
    }

    private List<Consumer<Path>> getListeners() {
        synchronized (monitor) {
            return listeners;
        }
    }

    private void firePath() {
        fire(getListeners(), path);
    }

    private static <M> void fire(final Iterable<? extends Consumer<M>> listeners, final M message) {
        listeners.forEach(consumer -> consumer.accept(message));
    }

    public final void setPath(final Path path) {
        this.path = path.toAbsolutePath().normalize();
        firePath();
    }

    public final Path getPath() {
        return path;
    }

    public final List<Path> list() {
        return Stream.concat(parents(path), content(path).stream())
                     .collect(Collectors.toList());
    }

    private static List<Path> content(final Path path) {
        try (final Stream<Path> stream = Files.list(path)) {
            return stream.filter(Files::isDirectory)
                         .collect(Collectors.toList());
        } catch (final IOException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    private static Stream<Path> parents(final Path path) {
        return (null == path) ? Stream.empty() : Stream.concat(parents(path.getParent()), Stream.of(path));
    }

    public final void reload() {
        firePath();
    }
}
