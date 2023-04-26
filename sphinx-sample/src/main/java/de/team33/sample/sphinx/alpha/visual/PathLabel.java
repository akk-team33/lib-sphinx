package de.team33.sample.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import de.team33.sample.service.Emitter;
import de.team33.sphinx.alpha.visual.JLabels;

import javax.swing.*;
import java.nio.file.Path;

public class PathLabel extends JLabel {

    public static PathLabel connect(final Emitter<Path> emitter) {
        return builder(emitter).build();
    }

    public static Builder builder(final Emitter<Path> emitter) {
        return new Builder().setText("* undefined *").connect(emitter);
    }

    public static class Builder extends LateBuilder<PathLabel, Builder> implements JLabels.Setup<PathLabel, Builder> {

        private Builder() {
            super(PathLabel::new, Builder.class);
        }

        public final Builder connect(final Emitter<Path> emitter) {
            return setup(pathLabel -> emitter.connect(path -> pathLabel.setText(path.toString())));
        }
    }
}
