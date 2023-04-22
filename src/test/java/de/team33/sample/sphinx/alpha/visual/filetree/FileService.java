package de.team33.sample.sphinx.alpha.visual.filetree;

import de.team33.patterns.execution.metis.SimpleAsyncExecutor;
import de.team33.patterns.notes.eris.Audience;
import de.team33.patterns.notes.eris.Channel;
import de.team33.patterns.notes.eris.ProtoService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService extends ProtoService<FileService> {

    private Path path = Paths.get(".").toAbsolutePath().normalize();

    public FileService() {
        super(new Audience(new SimpleAsyncExecutor()), FileService.class);
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
    public interface Channel<M> extends ProtoService.Channel<FileService, M> {

        Channel<Path> SET_PATH = FileService::getPath;
    }
}
