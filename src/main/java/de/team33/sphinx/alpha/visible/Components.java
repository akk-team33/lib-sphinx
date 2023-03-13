package de.team33.sphinx.alpha.visible;

import java.awt.*;

/**
 * Utility class to handle {@link Component}s.
 */
public final class Components {

    public interface Setup<T extends Component, B> extends de.team33.patterns.building.elara.Setup<T, B> {

        default B setVisible(final boolean visible) {
            return setup(t -> t.setVisible(visible));
        }

        default B setLocation(final int x, final int y) {
            return setup(t -> t.setLocation(x, y));
        }

        default B setLocation(final Point point) {
            return setup(t -> t.setLocation(point));
        }

        default B setSize(final int width, final int height) {
            return setup(t -> t.setSize(width, height));
        }

        default B setSize(final Dimension dimension) {
            return setup(t -> t.setSize(dimension));
        }

        default B setBounds(final int x, final int y, final int width, final int height) {
            return setup(t -> t.setBounds(x, y, width, height));
        }

        default B setBounds(final Rectangle rectangle) {
            return setup(t -> t.setBounds(rectangle));
        }
    }
}
