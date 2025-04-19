package de.team33.sphinx.sample.alpha.services;

import de.team33.patterns.execution.metis.SimpleAsyncExecutor;
import de.team33.patterns.notes.eris.Audience;
import de.team33.patterns.notes.eris.Channel;

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
}
