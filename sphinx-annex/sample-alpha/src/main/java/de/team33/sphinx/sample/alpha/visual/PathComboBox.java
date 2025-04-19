package de.team33.sphinx.sample.alpha.visual;

import de.team33.sphinx.sample.alpha.model.DirModel;
import de.team33.sphinx.sample.alpha.service.Adapter;

import javax.swing.*;
import java.nio.file.Path;

public class PathComboBox extends JComboBox<Path> {

    private PathComboBox(final Adapter<Path> adapter) {
        super(new DirModel(adapter));
    }

    public static PathComboBox connect(final Adapter<Path> adapter) {
        return new PathComboBox(adapter);
    }
}
