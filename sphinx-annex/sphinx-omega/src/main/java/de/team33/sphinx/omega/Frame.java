package de.team33.sphinx.omega;

import javax.swing.*;

public class Frame {

    private final JFrame backing = new JFrame();

    private Frame thisAfter(final Runnable runnable) {
        runnable.run();
        return this;
    }

    public final boolean isVisible() {
        return backing.isVisible();
    }

    @SuppressWarnings("UnusedReturnValue")
    public final Frame setVisible(final boolean visible) {
        return thisAfter(() -> backing.setVisible(visible));
    }
}
