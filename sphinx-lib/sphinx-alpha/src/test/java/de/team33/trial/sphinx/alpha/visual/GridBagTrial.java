package de.team33.trial.sphinx.alpha.visual;

import de.team33.sphinx.alpha.option.BackedBounds;
import de.team33.sphinx.alpha.option.GridBag;
import de.team33.sphinx.alpha.visual.JFrames;
import de.team33.sphinx.alpha.visual.JLabels;
import de.team33.sphinx.alpha.visual.JPanels;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.prefs.Preferences;

import static de.team33.sphinx.alpha.option.GridBag.Anchor.CENTER;
import static de.team33.sphinx.alpha.option.GridBag.Constraints.builder;
import static de.team33.sphinx.alpha.option.GridBag.Fill.BOTH;
import static de.team33.sphinx.alpha.option.GridBag.insets;


class GridBagTrial {

    private static final String APP_NODE = GridBagTrial.class.getPackage().getName();
    private static final Preferences PREFERENCES = Preferences.userRoot().node(APP_NODE);
    private static final String WIN_NODE = GridBagTrial.class.getSimpleName();
    private static final Rectangle SIZE0 = new Rectangle(0, 0, 640, 480);

    private static final GridBag.Constraints.Template GBC_00 = builder().setAnchor(CENTER)
                                                                        .setFill(BOTH)
                                                                        .setInsets(insets(4))
                                                                        .setIPadXY(4)
                                                                        .template();
    private static final GridBag.Constraints.Template GBC_X0 = GBC_00.builder()
                                                                     .setGridX(0)
                                                                     .setWeightX(1.0)
                                                                     .template();
    private static final GridBag.Constraints.Template GBC_Y0 = GBC_00.builder()
                                                                     .setGridY(0)
                                                                     .setWeightY(1.0)
                                                                     .template();


    private final JFrame frame;

    public GridBagTrial(final String[] args) {
        final Preferences preferences = PREFERENCES.node(WIN_NODE);
        this.frame = JFrames.builder()
                            .setup(new BackedBounds(preferences, SIZE0)::setupFrame)
                            .setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE)
                            .setLayout(GridBag.layout())
                            .add(newJLabel("Label 1"), GBC_X0.getY(0))
                            .add(newJLabel("Label 2"), GBC_X0.getY(1))
                            .add(newJLabel("Label 3"), GBC_X0.getY(2))
                            .add(newJLabel("Label 4"), GBC_X0.getY(3))
                            .add(new JPanel(), GBC_X0.getY(4, 1.0))
                            .add(newStatusPane(), GBC_X0.getY(5))
                            .build();
    }

    private JPanel newStatusPane() {
        return JPanels.builder()
                      .setLayout(GridBag.layout())
                      .add(newJLabel("Status 1"), GBC_Y0.getX(0))
                      .add(newJLabel("Status 2"), GBC_Y0.getX(1, 0.2))
                      .add(newJLabel("Status 3"), GBC_Y0.getX(2, 0.8))
                      .add(newJLabel("Status 4"), GBC_Y0.getX(3))
                      .build();
    }

    private JLabel newJLabel(final String text) {
        return JLabels.builder()
                      .setBorder(new BevelBorder(BevelBorder.LOWERED))
                      .setText(text)
                      .build();
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> new GridBagTrial(args).show());
    }

    private void show() {
        frame.setVisible(true);
    }
}
