package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import java.awt.*;
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

    public interface Setup<T extends JFrame, B extends Setup<T, B>> extends Frames.Setup<T, B> {

        default B setDefaultCloseOperation(int operation) {
            return setup(jFrame -> jFrame.setDefaultCloseOperation(operation));
        }

        default B setTransferHandler(TransferHandler newHandler) {
            return setup(jFrame -> jFrame.setTransferHandler(newHandler));
        }

        default B setJMenuBar(JMenuBar menubar) {
            return setup(jFrame -> jFrame.setJMenuBar(menubar));
        }

        default B remove(Component comp) {
            return setup(jFrame -> jFrame.remove(comp));
        }

        default B setLayout(LayoutManager manager) {
            return setup(jFrame -> jFrame.setLayout(manager));
        }

        default B setIconImage(Image image) {
            return setup(jFrame -> jFrame.setIconImage(image));
        }

        default B setContentPane(Container contentPane) {
            return setup(jFrame -> jFrame.setContentPane(contentPane));
        }

        default B setLayeredPane(JLayeredPane layeredPane) {
            return setup(jFrame -> jFrame.setLayeredPane(layeredPane));
        }

        default B setGlassPane(Component glassPane) {
            return setup(jFrame -> jFrame.setGlassPane(glassPane));
        }
    }
}
