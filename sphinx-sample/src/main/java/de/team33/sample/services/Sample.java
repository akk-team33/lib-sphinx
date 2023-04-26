package de.team33.sample.services;

import de.team33.patterns.execution.metis.SimpleAsyncExecutor;
import de.team33.patterns.notes.eris.Audience;
import de.team33.patterns.notes.eris.Channel;
import de.team33.sample.service.Emitter;

import java.nio.file.Path;
import java.util.function.Consumer;

public class Sample {

    private final Audience audience = new Audience(new SimpleAsyncExecutor());
    private Path path;

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    private <M> void add(final Channel<M> channel, final Consumer<M> listener) {
        audience.add(channel, listener);
    }

    private interface Adaption<T> extends de.team33.sample.services.Adaption<Sample, T>, Channel<T> {

        Adaption<Path> PATH_ADAPTION = sample -> Adapter.compose(sample::getPath,
                                                                 sample::setPath,
                                                                 listener -> sample.<Path>add(PATH_ADAPTION, listener));
    }
}
