package de.team33.sample.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import de.team33.patterns.building.elara.Setup;
import de.team33.sample.service.Emitter;
import de.team33.sphinx.alpha.option.BackedBounds;
import de.team33.sphinx.alpha.visual.JFrames;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;

public class DirSelectFrame extends JFrame {

    private final String suffix;

    private DirSelectFrame(final String suffix) {
        this.suffix = suffix;
    }

    public static Builder builder(final String suffix) {
        return new Builder(suffix);
    }

    private void setPath(final Path path) {
        setTitle(path + " - " + suffix);
    }

    public static final class Builder
            extends LateBuilder<DirSelectFrame, Builder>
            implements JFrames.Setup<DirSelectFrame, Builder> {

        private Builder(final String suffix) {
            super(() -> new DirSelectFrame(suffix), Builder.class);
        }

        public final Builder connect(final Emitter<Path> emitter) {
            return setup(dirSelectFrame -> emitter.connect(dirSelectFrame::setPath));
        }

        public final Builder connect(final BackedBounds backedBounds) {
            return setup(backedBounds::setupFrame);
        }
    }
}
