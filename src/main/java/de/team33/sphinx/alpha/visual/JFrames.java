package de.team33.sphinx.alpha.visual;

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

    public static <T extends JFrame> Builder<T, ?> builder(final Supplier<T> newResult) {
        return new Builder<>(newResult, Builder.class);
    }

    public static class Builder<T extends JFrame, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    public interface Setup<T extends JFrame, B> extends Components.Setup<T, B> {

        default B setDefaultCloseOperation(final int closeOperation) {
            return setup(target -> target.setDefaultCloseOperation(closeOperation));
        }
    }
}
