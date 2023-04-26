package de.team33.sample.sphinx.alpha.visual;

import de.team33.sample.service.Adapter;
import de.team33.sample.sphinx.alpha.model.DirModel;

import javax.swing.JComboBox;
import java.nio.file.Path;

public class PathComboBox extends JComboBox<Path> {

    private PathComboBox(final Adapter<Path> adapter) {
        super(new DirModel(adapter));
    }

    public static PathComboBox connect(final Adapter<Path> adapter) {
        return new PathComboBox(adapter);
    }
}
