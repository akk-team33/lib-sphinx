package de.team33.sphinx.alpha.visual.trial;

import de.team33.sphinx.alpha.activity.Event;
import de.team33.sphinx.alpha.option.BackedBounds;
import de.team33.sphinx.alpha.visual.JFrames;

import javax.swing.*;
import java.awt.*;
import java.util.prefs.Preferences;


@SuppressWarnings("UseOfSystemOutOrSystemErr")
final class BackedBoundsTrial {

    private static final Preferences PREFERENCES = Preferences.userRoot()
                                                              .node(BackedBoundsTrial.class.getPackage().getName());
    private static final Rectangle INITIAL_BOUNDS = new Rectangle(100, 100, 640, 480);

    private final JFrame frame;

    private BackedBoundsTrial(@SuppressWarnings("unused") final String[] args) {
        final Preferences prefs = PREFERENCES.node(BackedBoundsTrial.class.getSimpleName());
        final BackedBounds bounds = new BackedBounds(prefs, INITIAL_BOUNDS);
        this.frame = JFrames.builder()
                            .setTitle(BackedBoundsTrial.class.getCanonicalName())
                            .setup(bounds::setupFrame)

//                            .setLocation(bounds.getLocation())
//                            .setSize(bounds.getSize())
//                            .setBounds(bounds.getBounds())
//                            .setExtendedState(bounds.getState())
//
                            .on(Event.COMPONENT_MOVED, System.out::println)
//                            .on(Event.COMPONENT_MOVED, e -> bounds.setLocation(e.getComponent().getLocation()))
//                            .on(Event.COMPONENT_MOVED, e -> bounds.setBounds(e.getComponent().getBounds()))
//
                            .on(Event.COMPONENT_RESIZED, System.out::println)
//                            .on(Event.COMPONENT_RESIZED, e -> bounds.setSize(e.getComponent().getSize()))
//                            .on(Event.COMPONENT_RESIZED, e -> bounds.setBounds(e.getComponent().getBounds()))
//
                            .on(Event.WINDOW_STATE_CHANGED, System.out::println)
//                            .on(Event.WINDOW_STATE_CHANGED, e -> bounds.setState(e.getNewState()))

                            .setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
                            .build();
    }

    private void show() {
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> new BackedBoundsTrial(args).show());
    }
}
