package de.team33.sample.sphinx.alpha.visual.filetree;

import de.team33.sample.sphinx.alpha.service.DirectoryService;
import de.team33.sample.sphinx.alpha.visual.dirselect.TinyDirectorySample;
import de.team33.sphinx.alpha.activity.Event;
import de.team33.sphinx.alpha.option.BackedBounds;
import de.team33.sphinx.alpha.option.GridBag;
import de.team33.sphinx.alpha.visual.JFrames;
import de.team33.sphinx.alpha.visual.JLabels;
import de.team33.sphinx.alpha.visual.JPanels;
import de.team33.sphinx.alpha.visual.JSplitPanes;
import de.team33.sphinx.alpha.visual.JTextFields;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.prefs.Preferences;

public class FileTreeSample {

    private static final String APP_NODE = TinyDirectorySample.class.getPackage().getName();
    private static final Preferences PREFERENCES = Preferences.userRoot().node(APP_NODE);
    private static final String WIN_NODE = TinyDirectorySample.class.getSimpleName();
    private static final Rectangle SIZE0 = new Rectangle(0, 0, 640, 480);
    private static final GridBag.Constraints.Template GBC_TEMPLATE = GridBag.Constraints.builder()
                                                                                        .setGridX(0)
                                                                                        .setWeightX(1.0)
                                                                                        .setFill(GridBag.Fill.BOTH)
                                                                                        .setIPadXY(4)
                                                                                        .template();

    private final Preferences preferences;
    private final DirectoryService service;
    private final JFrame frame;

    public FileTreeSample() {
        preferences = PREFERENCES.node(WIN_NODE);
        service = new DirectoryService();
        frame = newFrame();
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> new FileTreeSample().run());
    }

    private void run() {
        SwingUtilities.invokeLater(() -> {
            service.reload();
            frame.setVisible(true);
        });
    }

    private JFrame newFrame() {
        return JFrames.builder()
                      .setTitle(TinyDirectorySample.class.getCanonicalName())
                      .setup(new BackedBounds(preferences, SIZE0)::setupFrame)
                      .setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
                      .setContentPane(newContentPane())
                      .build();
    }

    private JPanel newContentPane() {
        final JLabel label = JLabels.builder()
                                    .setText("* selected path *")
                                    .setup(lbl -> service.registry()
                                                         .add(DirectoryService.Channel.SET_PATH,
                                                              path -> lbl.setText(path.toString())))
                                    .build();
        final JTextField textField = JTextFields.builder()
                                                .setup(field -> service.registry()
                                                                       .add(DirectoryService.Channel.SET_PATH,
                                                                            path -> field.setText(path.toString())))
                                                .on(Event.FOCUS_LOST, event -> focusLost(event))
                                                .build();
        return JPanels.builder()
                      .setLayout(GridBag.layout())
                      .add(label, GBC_TEMPLATE.getY(0))
                      .add(textField, GBC_TEMPLATE.getY(1))
                      .add(newSplitPane(), GBC_TEMPLATE.getY(2, 1.0))
                      .build();
    }

    private void focusLost(final FocusEvent event) {
        Optional.of(event.getComponent())
                .filter(JTextField.class::isInstance)
                .map(JTextField.class::cast)
                .ifPresent(jTextField -> service.setPath(Paths.get(jTextField.getText())));
    }

    private JSplitPane newSplitPane() {
        return JSplitPanes.builder()
                          .setDividerLocation(0.5)
                          .add(new FileTreePane(service).component(), JSplitPane.LEFT)
                          .add(new JLabel("right"), JSplitPane.RIGHT)
                          .build();
    }
}
