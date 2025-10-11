package de.team33.sphinx.omega.publics;

import de.team33.sphinx.omega.Frame;
import de.team33.sphinx.omega.GUIApplication;

class GUIApplicationTrial extends GUIApplication {

    @SuppressWarnings("unused")
    private GUIApplicationTrial(final String[] args) {
    }

    public static void main(String[] args) {
        launch(new GUIApplicationTrial(args));
    }

    @Override
    protected Frame newFrame() {
        return new Frame();
    }
}