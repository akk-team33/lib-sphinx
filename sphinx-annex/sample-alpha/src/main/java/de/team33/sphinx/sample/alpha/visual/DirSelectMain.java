package de.team33.sphinx.sample.alpha.visual;

import de.team33.sphinx.alpha.option.BackedBounds;
import de.team33.sphinx.alpha.option.GridBag;
import de.team33.sphinx.alpha.visual.JPanels;
import de.team33.sphinx.sample.alpha.SampleService;

import javax.swing.*;
import java.awt.*;
import java.util.prefs.Preferences;

public class DirSelectMain {

    private static final String APP_NODE = DirSelectMain.class.getPackage().getName();
    private static final Preferences PREFERENCES = Preferences.userRoot().node(APP_NODE);
    private static final String WIN_NODE = DirSelectMain.class.getSimpleName();
    private static final Rectangle SIZE0 = new Rectangle(0, 0, 640, 480);
    private static final GridBag.Constraints.Template GBC_TEMPLATE = GridBag.Constraints.builder()
                                                                                        .setGridX(0)
                                                                                        .setWeightX(1.0)
                                                                                        .setFill(GridBag.Fill.BOTH)
                                                                                        .setIPadXY(4)
                                                                                        .template();

    private final Preferences preferences;
    private final SampleService service;
    private final JFrame frame;

    DirSelectMain() {
        preferences = PREFERENCES.node(WIN_NODE);
        service = new SampleService();
        frame = newFrame();
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> new DirSelectMain().run());
    }

    private void run() {
        SwingUtilities.invokeLater(() -> {
            service.reload();
            frame.setVisible(true);
        });
    }

    private JFrame newFrame() {
        return DirSelectFrame.builder(DirSelectMain.class.getSimpleName())
                             .connect(service.pathAdapter)
                             .connect(new BackedBounds(preferences, SIZE0))
                             .setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
                             .setContentPane(newContentPane())
                             .build();
    }

    private JPanel newContentPane() {
        return JPanels.builder()
                      .setLayout(GridBag.layout())
                      .add(PathLabel.connect(service.pathAdapter), GBC_TEMPLATE.getY(0))
                      .add(PathField.connect(service.pathAdapter), GBC_TEMPLATE.getY(1))
                      .add(PathComboBox.connect(service.pathAdapter), GBC_TEMPLATE.getY(2))
                      .add(new JPanel(), GBC_TEMPLATE.getY(3, 1.0))
                      .build();
    }
}
