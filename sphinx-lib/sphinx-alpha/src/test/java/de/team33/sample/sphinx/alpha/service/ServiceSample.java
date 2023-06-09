package de.team33.sample.sphinx.alpha.service;

import de.team33.patterns.execution.metis.SimpleAsyncExecutor;
import de.team33.patterns.notes.eris.Audience;
import de.team33.patterns.notes.eris.ProtoService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServiceSample extends ProtoService<ServiceSample> {

    private Path path = Paths.get(".").toAbsolutePath().normalize();

    public ServiceSample() {
        super(new Audience(new SimpleAsyncExecutor()), ServiceSample.class);
    }

    public Adapter<Path> pathAdapter() {
        return Adapter.compose(this::setPath, listener -> registry().add(Channel.SET_PATH, listener));
    }

    public final void reload() {
        fire(Channel.SET_PATH);
    }

    public final Path getPath() {
        return path;
    }

    public final void setPath(final Path path) {
        if (Files.exists(path)) {
            this.path = path.toAbsolutePath().normalize();
        }
        fire(Channel.SET_PATH);
    }

    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Channel<M> extends ProtoService.Channel<ServiceSample, M> {

        Channel<Path> SET_PATH = ServiceSample::getPath;
    }
}
