package de.team33.sample.sphinx.alpha.visual.dirselect;

import de.team33.patterns.lazy.narvi.Lazy;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

class TinyDirectoryModel extends AbstractListModel<Path> implements ComboBoxModel<Path> {

    private final TinyDirectoryService service;
    private Lazy<List<Path>> paths = Lazy.init(Collections::emptyList);

    TinyDirectoryModel(final TinyDirectoryService service) {
        this.service = service;
        service.addListener(path -> {
            this.paths = lazyPaths(this);
            fireContentsChanged(this, 0, Integer.MAX_VALUE);
        });
    }

    private static Lazy<List<Path>> lazyPaths(final TinyDirectoryModel model) {
        return Lazy.init(model.service::list);
    }

    @Override
    public final int getSize() {
        return paths.get().size();
    }

    @Override
    public final Path getElementAt(final int index) {
        return paths.get().get(index);
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
