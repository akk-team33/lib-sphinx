package de.team33.sphinx.alpha.visible;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JFrame}s.
 */
public final class JFrames {

    public static Builder<JFrame, ?> builder() {
        return new Builder<>(JFrame::new, Builder.class);
    }

    public static class Builder<T extends JFrame, B extends Builder<T, B>>
            extends LateBuilder<T, B>
            implements Setup<T, B> {

        /**
         * Initializes a new instance.
         *
         * @param newResult    A {@link Supplier} method to retrieve a new instance of the result type.
         * @param builderClass The {@link Class} representation of the intended effective builder type.
         * @throws IllegalArgumentException if the specified builder class does not represent the instance to create.
         */
        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    public interface Setup<T extends JFrame, B> extends de.team33.patterns.building.elara.Setup<T, B> {

    }
}
