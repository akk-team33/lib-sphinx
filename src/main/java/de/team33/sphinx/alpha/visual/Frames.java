package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import de.team33.sphinx.alpha.activity.Event;
import de.team33.sphinx.alpha.option.PreferredBounds;

import java.awt.*;
import java.util.Optional;
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

        default B setTitle(final String title) {
            return setup(t -> t.setTitle(title));
        }

        default B setExtendedState(final int state) {
            return setup(t -> t.setExtendedState(state));
        }

        default B setPreferredBounds(final PreferredBounds bounds) {
            return setBounds(bounds.getRectangle()).setExtendedState(bounds.getExtendedState())
                                                   .on(Event.WINDOW_CLOSING, windowEvent -> {
                                                       Optional.of(windowEvent.getWindow())
                                                               .filter(Frame.class::isInstance).map(Frame.class::cast)
                                                               .ifPresent(frame -> bounds.store(frame.getBounds(), frame.getExtendedState()));
                                                   });
        }
    }
}
