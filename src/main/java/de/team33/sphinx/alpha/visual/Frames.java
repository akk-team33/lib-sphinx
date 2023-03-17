package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import de.team33.sphinx.alpha.activity.Event;
import de.team33.sphinx.alpha.option.PreferredBounds;

import java.awt.*;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link Frame}s.
 */
public final class Frames {

    public static Builder<Frame, ?> builder() {
        return new Builder<>(Frame::new, Builder.class);
    }

    public static <T extends Frame> Builder<T, ?> builder(final Supplier<T> newResult) {
        return new Builder<>(newResult, Builder.class);
    }

    public static class Builder<T extends Frame, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    public interface Setup<T extends Frame, B extends Setup<T, B>> extends Components.Setup<T, B> {

        default B setPreferredBounds(final PreferredBounds bounds) {
            return this.setBounds(bounds.getRectangle())
                       .setExtendedState(bounds.getExtendedState())
                       .on(Event.WINDOW_CLOSING, bounds::onClosing);
        }

        default B setTitle(String title) {
            return setup(frame -> frame.setTitle(title));
        }

        default B setIconImage(Image image) {
            return setup(frame -> frame.setIconImage(image));
        }

        default B setMenuBar(MenuBar mb) {
            return setup(frame -> frame.setMenuBar(mb));
        }

        default B setResizable(boolean resizable) {
            return setup(frame -> frame.setResizable(resizable));
        }

        default B setState(int state) {
            return setup(frame -> frame.setState(state));
        }

        default B setExtendedState(int state) {
            return setup(frame -> frame.setExtendedState(state));
        }

        default B setMaximizedBounds(Rectangle bounds) {
            return setup(frame -> frame.setMaximizedBounds(bounds));
        }

        default B setUndecorated(boolean undecorated) {
            return setup(frame -> frame.setUndecorated(undecorated));
        }

        default B setOpacity(float opacity) {
            return setup(frame -> frame.setOpacity(opacity));
        }

        default B setShape(Shape shape) {
            return setup(frame -> frame.setShape(shape));
        }

        default B setBackground(Color bgColor) {
            return setup(frame -> frame.setBackground(bgColor));
        }

        default B remove(MenuComponent m) {
            return setup(frame -> frame.remove(m));
        }
    }
}
