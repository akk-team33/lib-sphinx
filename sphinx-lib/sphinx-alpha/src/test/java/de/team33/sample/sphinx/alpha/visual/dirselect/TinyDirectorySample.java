package de.team33.sample.sphinx.alpha.visual.dirselect;

import de.team33.sample.sphinx.alpha.service.ServiceSample;
import de.team33.sphinx.alpha.activity.Event;
import de.team33.sphinx.alpha.option.BackedBounds;
import de.team33.sphinx.alpha.option.GridBag;
import de.team33.sphinx.alpha.visual.JButtons;
import de.team33.sphinx.alpha.visual.JComboBoxes;
import de.team33.sphinx.alpha.visual.JFrames;
import de.team33.sphinx.alpha.visual.JLabels;
import de.team33.sphinx.alpha.visual.JPanels;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.awt.Rectangle;
import java.nio.file.Path;
import java.util.prefs.Preferences;

public final class TinyDirectorySample {

    private static final String APP_NODE = TinyDirectorySample.class.getPackage().getName();
    private static final Preferences PREFERENCES = Preferences.userRoot().node(APP_NODE);
    private static final String WIN_NODE = TinyDirectorySample.class.getSimpleName();
    private static final Rectangle SIZE0 = new Rectangle(0, 0, 640, 480);
    private static final GridBag.Constraints.Template GBC_TEMPLATE = GridBag.Constraints.builder()
                                                                                        .setGridX(0)
                                                                                        .setWeightX(1.0)
                                                                                        .setFill(GridBag.Fill.BOTH)
                                                                                        .template();

    private final ServiceSample service;
    private final Visual visual = new Visual();
    private final Action action = new Action();
    private final Reaction reaction = new Reaction();

    private TinyDirectorySample(final ServiceSample service) {
        this.service = service;
    }

    public static void main(final String[] args) {
        final ServiceSample service = new ServiceSample();
        SwingUtilities.invokeLater(() -> new TinyDirectorySample(service).run());
    }

    private void run() {
        final Preferences preferences = PREFERENCES.node(WIN_NODE);
        final JFrame frame = visual.newFrame(preferences);
        SwingUtilities.invokeLater(() -> {
            frame.setVisible(true);
            service.reload();
        });
    }

    private class Visual {

        private JFrame newFrame(final Preferences preferences) {
            return JFrames.builder()
                          .setTitle(TinyDirectorySample.class.getCanonicalName())
                          .setup(new BackedBounds(preferences, SIZE0)::setupFrame)
                          .setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
                          .setContentPane(newContentPane())
                          .build();
        }

        private JPanel newContentPane() {
            final JComboBox<Path> comboBox = JComboBoxes.builder(new TinyDirectoryModel(service))
                                                        .setEditable(true)
                                                        .on(Event.FOCUS_GAINED, System.out::println)
                                                        .build();
            final JLabel label = JLabels.builder()
                                        .setText("- empty -")
                                        .setup(jLabel -> service.registry().add(ServiceSample.Channel.SET_PATH,
                                                                                path -> jLabel.setText(path.toString())))
                                        .build();
            final JButton jButton = JButtons.builder()
                                            .setText("Anwenden")
                                            .setDefaultCapable(true)
                                            .on(Event.ACTION_PERFORMED, System.out::println)
                                            .build();
            return JPanels.builder()
                          .setLayout(GridBag.layout())
                          .add(comboBox, GBC_TEMPLATE.getY(0))
                          .add(label, GBC_TEMPLATE.getY(1))
                          .add(new JPanel(), GBC_TEMPLATE.getY(2, 1.0))
                          .add(jButton, GBC_TEMPLATE.getY(3))
                          .build();
        }
    }

    private class Action {
    }

    private class Reaction {
    }
}
