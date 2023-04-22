package de.team33.sample.sphinx.alpha.visual.dirselect;

import de.team33.sample.sphinx.alpha.service.DirectoryService;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class TinyDirectoryModel extends AbstractListModel<Path> implements ComboBoxModel<Path> {

    private final DirectoryService service;
    private List<Path> paths = Collections.emptyList();

    TinyDirectoryModel(final DirectoryService service) {
        this.service = service;
        service.registry().add(DirectoryService.Channel.SET_PATH, path -> {
            this.paths = newPaths(path);
            fireContentsChanged(this, 0, Integer.MAX_VALUE);
        });
    }

    private List<Path> newPaths(final Path path) {
        return Stream.concat(parentPaths(path), childPaths(path).stream())
                     .collect(Collectors.toList());
    }

    private Stream<Path> parentPaths(final Path path) {
        return (null == path) ? Stream.empty() : Stream.concat(parentPaths(path.getParent()), Stream.of(path));
    }

    private List<Path> childPaths(final Path path) {
        try (final Stream<Path> stream = Files.list(path)) {
            return stream.filter(Files::isDirectory)
                         .sorted(Comparator.comparing(path1 -> path1.getFileName().toString()))
                         .collect(Collectors.toList());
        } catch (IOException e) {
            // TODO: log exception
            return Collections.emptyList();
        }
    }

    @Override
    public final int getSize() {
        return paths.size();
    }

    @Override
    public final Path getElementAt(final int index) {
        return paths.get(index);
    }

    @Override
    public final void setSelectedItem(final Object anItem) {
        if (anItem instanceof Path) {
            final Path path = (Path) anItem;
            service.setPath(path);
        }
    }

    @Override
    public final Object getSelectedItem() {
        return service.getPath();
    }
}
