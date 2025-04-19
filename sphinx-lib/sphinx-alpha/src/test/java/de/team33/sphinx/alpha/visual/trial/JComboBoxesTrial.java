package de.team33.sphinx.alpha.visual.trial;

import de.team33.sphinx.alpha.model.ComboListModel;
import de.team33.sphinx.alpha.visual.JComboBoxes;
import de.team33.sphinx.alpha.visual.JFrames;

import javax.swing.*;
import java.awt.*;
import java.nio.file.AccessMode;
import java.util.logging.Logger;


class JComboBoxesTrial {

    private static final GridBagConstraints GBC_COMBOBOX = newGBConstraints(0, 0.0);
    private static final GridBagConstraints GBC_ACCBOX = newGBConstraints(1, 0.0);
    private static final GridBagConstraints GBC_JPANEL = newGBConstraints(2, 1.0);
    private static Logger LOG = Logger.getLogger(JComboBoxesTrial.class.getCanonicalName());

    private final JFrame frame;
    private String selected = "unknown";
    private AccessMode accessMode;

    public JComboBoxesTrial(final String[] args) {
        final ComboBoxModel<String> model = ComboListModel.ofItems("Abc", "Def", "Ghi", "Jkl", "Mno", "Pqr", "Stu")
                                                          .setBacking(this::getSelected,
                                                                      this::setSelected);
        final JComboBox<String> comboBox = JComboBoxes.builder(model).build();
        final ComboBoxModel<AccessMode> accModes = ComboListModel.of(AccessMode.class)
                                                                 .setBacking(this::getAccessMode,
                                                                             this::setAccessMode);
        final JComboBox<AccessMode> accBox = JComboBoxes.builder(accModes).build();
        this.frame = JFrames.builder()
                            .setLayout(new GridBagLayout())
                            .add(comboBox, GBC_COMBOBOX)
                            .add(accBox, GBC_ACCBOX)
                            .add(new JPanel(), GBC_JPANEL)
                            .setLocation(100, 100)
                            .setSize(640, 480)
                            .setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE)
                            .setVisible(true)
                            .build();
    }

    private void setAccessMode(final AccessMode mode) {
        this.accessMode = mode;
    }

    private AccessMode getAccessMode() {
        return accessMode;
    }

    private static GridBagConstraints newGBConstraints(final int gridY, final double weightY) {
        return new GridBagConstraints(0, gridY, 1, 1, 1.0, weightY, 17, 1, new Insets(1, 1, 1, 1), 1, 1);
    }

    private void setSelected(final String selected) {
        LOG.info(() -> "setSelected(\"" + selected + "\")");
        this.selected = selected;
    }

    private String getSelected() {
        LOG.info(() -> "getSelected() -> \"" + selected + "\"");
        return selected;
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> new JComboBoxesTrial(args));
    }
}
