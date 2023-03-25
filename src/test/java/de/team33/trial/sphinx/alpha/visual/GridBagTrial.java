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

import static de.team33.sphinx.alpha.option.GridBag.Anchor.BASELINE;
import static de.team33.sphinx.alpha.option.GridBag.Constraints.template;
import static de.team33.sphinx.alpha.option.GridBag.Fill.BOTH;
import static de.team33.sphinx.alpha.option.GridBag.Fill.NONE;
import static de.team33.sphinx.alpha.option.GridBag.insets;


class GridBagTrial {

    private static final String APP_NODE = GridBagTrial.class.getPackage().getName();
    private static final Preferences PREFERENCES = Preferences.userRoot().node(APP_NODE);
    private static final String WIN_NODE = GridBagTrial.class.getSimpleName();
    private static final Rectangle SIZE0 = new Rectangle(0, 0, 640, 480);
    private static final GridBag.Constraints.Template GBC_TEMPLATE = template(BASELINE, BOTH, insets(2), 4);
    private static final GridBagConstraints GBC_VERT_0 = GBC_TEMPLATE.vertical(0);
    private static final GridBagConstraints GBC_VERT_1 = GBC_TEMPLATE.vertical(1);
    private static final GridBagConstraints GBC_VERT_2 = GBC_TEMPLATE.vertical(2);
    private static final GridBagConstraints GBC_VERT_3 = GBC_TEMPLATE.vertical(3);
    private static final GridBagConstraints GBC_BOTTOM = GBC_TEMPLATE.vertical(4, 1.0);
    private static final GridBagConstraints GBC_STATUS = GBC_TEMPLATE.vertical(5);
    private static final GridBagConstraints GBC_HOR_0 = GBC_TEMPLATE.horizontal(0);
    private static final GridBagConstraints GBC_HOR_1 = GBC_TEMPLATE.horizontal(1, 0.2);
    private static final GridBagConstraints GBC_HOR_2 = GBC_TEMPLATE.horizontal(2, 0.8);
    private static final GridBagConstraints GBC_HOR_3 = GBC_TEMPLATE.horizontal(3);


    private final JFrame frame;

    public GridBagTrial(final String[] args) {
        final Preferences preferences = PREFERENCES.node(WIN_NODE);
        this.frame = JFrames.builder()
                            .setup(new BackedBounds(preferences, SIZE0)::setupFrame)
                            .setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE)
                            .setLayout(GridBag.layout())
                            .add(newJLabel("Label 1"), GBC_VERT_0)
                            .add(newJLabel("Label 2"), GBC_VERT_1)
                            .add(newJLabel("Label 3"), GBC_VERT_2)
                            .add(newJLabel("Label 4"), GBC_VERT_3)
                            .add(new JPanel(), GBC_BOTTOM)
                            .add(new JPanel(), GBC_BOTTOM)
                            .add(newStatusPane(), GBC_STATUS)
                            .build();
    }

    private JPanel newStatusPane() {
        return JPanels.builder()
                      .setLayout(GridBag.layout())
                      .add(newJLabel("Status 1"), GBC_HOR_0)
                      .add(newJLabel("Status 2"), GBC_HOR_1)
                      .add(newJLabel("Status 3"), GBC_HOR_2)
                      .add(newJLabel("Status 4"), GBC_HOR_3)
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
