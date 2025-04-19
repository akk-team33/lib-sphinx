package de.team33.sphinx.sample.alpha;

import de.team33.patterns.execution.metis.SimpleAsyncExecutor;
import de.team33.patterns.notes.eris.Audience;
import de.team33.patterns.notes.eris.ProtoService;
import de.team33.sphinx.sample.alpha.service.Adapter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SampleService extends ProtoService<SampleService> {

    private Path path = Paths.get(".").toAbsolutePath().normalize();

    public final Adapter<Path> pathAdapter = Adapter.compose(this::setPath,
                                                             listener -> registry().add(Channel.SET_PATH, listener));

    public SampleService() {
        super(new Audience(new SimpleAsyncExecutor()), SampleService.class);
    }

    public final Path getPath() {
        return path;
    }

    public final void setPath(final Path path) {
        if (Files.isDirectory(path)) {
            this.path = path.toAbsolutePath().normalize();
        }
        fire(Channel.SET_PATH);
    }

    public final void reload() {
        fire(Channel.SET_PATH);
    }

    @FunctionalInterface
    public interface Channel<M> extends ProtoService.Channel<SampleService, M> {

        Channel<Path> SET_PATH = SampleService::getPath;
    }
}
