package de.team33.sphinx.omega;

import javax.swing.*;

public abstract class GUIApplication {

    protected static void launch(final GUIApplication application) {
        SwingUtilities.invokeLater(application::run);
    }

    private void run() {
        newFrame().setVisible(true);
    }

    protected abstract Frame newFrame();
}
