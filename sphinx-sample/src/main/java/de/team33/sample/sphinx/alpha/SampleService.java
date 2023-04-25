package de.team33.sample.sphinx.alpha;

import de.team33.patterns.execution.metis.SimpleAsyncExecutor;
import de.team33.patterns.notes.eris.Audience;
import de.team33.patterns.notes.eris.ProtoService;
import de.team33.sample.service.Adapter;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SampleService extends ProtoService<SampleService> {

    private Path path = Paths.get(".").toAbsolutePath().normalize();

    public SampleService() {
        super(new Audience(new SimpleAsyncExecutor()), SampleService.class);
    }

    private void setPath(final Path path) {
        this.path = path;
        fire(Channel.SET_PATH);
    }

    public Adapter<Path> pathAdapter() {
        return Adapter.compose(this::setPath, listener -> registry().add(Channel.SET_PATH, listener));
    }

    @FunctionalInterface
    public interface Channel<M> extends ProtoService.Channel<SampleService, M> {

        Channel<Path> SET_PATH = srvc -> srvc.path;
    }
}
