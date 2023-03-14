package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;

/**
 * Utility class to handle {@link JFrame}s.
 */
public final class JFrames {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder
            extends LateBuilder<JFrame, Builder>
            implements Setup<JFrame, Builder>,
                       Components.Setup<JFrame, Builder> {

        private Builder() {
            super(JFrame::new, Builder.class);
        }
    }

    public interface Setup<T extends JFrame, B> extends de.team33.patterns.building.elara.Setup<T, B> {

        default B setDefaultCloseOperation(final int closeOperation) {
            return setup(target -> target.setDefaultCloseOperation(closeOperation));
        }
    }
}
