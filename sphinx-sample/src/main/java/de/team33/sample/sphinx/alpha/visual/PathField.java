package de.team33.sample.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import de.team33.sample.service.Adapter;
import de.team33.sample.service.Emitter;
import de.team33.sphinx.alpha.activity.Event;
import de.team33.sphinx.alpha.visual.JLabels;
import de.team33.sphinx.alpha.visual.JTextFields;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class PathField extends JTextField {

    public static PathField connect(final Adapter<Path> adapter) {
        return builder(adapter).build();
    }

    public static Builder builder(final Adapter<Path> adapter) {
        return new Builder().setText("* undefined *").connect(adapter);
    }

    private static Path getPath(final FocusEvent event) {
        return Optional.of(event.getComponent())
                       .filter(PathField.class::isInstance)
                       .map(PathField.class::cast)
                       .map(PathField::getText)
                       .map(Paths::get)
                       .orElse(null);
    }

    public static final class Builder
            extends LateBuilder<PathField, Builder>
            implements JTextFields.Setup<PathField, Builder> {

        private Builder() {
            super(PathField::new, Builder.class);
        }

        public final Builder connect(final Adapter<Path> adapter) {
            return this.setup(pathLabel -> adapter.connect(path -> pathLabel.setText(path.toString())))
                       .on(Event.FOCUS_LOST, event -> adapter.accept(getPath(event)));
        }
    }
}
