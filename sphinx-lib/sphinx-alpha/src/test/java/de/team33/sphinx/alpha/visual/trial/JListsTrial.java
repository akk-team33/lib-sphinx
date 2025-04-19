package de.team33.sphinx.alpha.visual.trial;

import de.team33.sphinx.alpha.model.ComboListModel;
import de.team33.sphinx.alpha.visual.JFrames;
import de.team33.sphinx.alpha.visual.JLists;

import javax.swing.*;
import java.awt.*;
import java.nio.file.AccessMode;
import java.util.logging.Logger;


class JListsTrial {

    private static final GridBagConstraints GBC_JLIST1 = newGBConstraints(0, 0.0);
    private static final GridBagConstraints GBC_JLIST2 = newGBConstraints(1, 0.0);
    private static final GridBagConstraints GBC_JPANEL = newGBConstraints(2, 1.0);
    private static Logger LOG = Logger.getLogger(JListsTrial.class.getCanonicalName());

    private final JFrame frame;
    private String selected = "unknown";
    private AccessMode accessMode;

    public JListsTrial(final String[] args) {
        final ListModel<String> model = ComboListModel.ofItems("Abc", "Def", "Ghi", "Jkl", "Mno", "Pqr", "Stu")
                                                          .setBacking(this::getSelected,
                                                                      this::setSelected);
        final JList<String> comboBox = JLists.builder(model).build();
        final ListModel<AccessMode> accModes = ComboListModel.of(AccessMode.class)
                                                                 .setBacking(this::getAccessMode,
                                                                             this::setAccessMode);
        final JList<AccessMode> accBox = JLists.builder(accModes).build();
        this.frame = JFrames.builder()
                            .setLayout(new GridBagLayout())
                            .add(comboBox, GBC_JLIST1)
                            .add(accBox, GBC_JLIST2)
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
        SwingUtilities.invokeLater(() -> new JListsTrial(args));
    }
}
