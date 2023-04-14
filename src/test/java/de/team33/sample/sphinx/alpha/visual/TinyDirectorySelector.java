package de.team33.sample.sphinx.alpha.visual;

import de.team33.sphinx.alpha.option.BackedBounds;
import de.team33.sphinx.alpha.option.GridBag;
import de.team33.sphinx.alpha.visual.JComboBoxes;
import de.team33.sphinx.alpha.visual.JFrames;
import de.team33.sphinx.alpha.visual.JPanels;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.awt.Rectangle;
import java.nio.file.Path;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.prefs.Preferences;

public final class TinyDirectorySelector {

    private static final String APP_NODE = TinyDirectorySelector.class.getPackage().getName();
    private static final Preferences PREFERENCES = Preferences.userRoot().node(APP_NODE);
    private static final String WIN_NODE = TinyDirectorySelector.class.getSimpleName();
    private static final Rectangle SIZE0 = new Rectangle(0, 0, 640, 480);
    private static final GridBag.Constraints.Template GBC_TEMPLATE = GridBag.Constraints.builder()
                                                                                        .setGridX(0)
                                                                                        .setWeightX(1.0)
                                                                                        .setFill(GridBag.Fill.BOTH)
                                                                                        .template();

    private final TinyDirectoryService service;
    private final Visual visual = new Visual();
    private final Action action = new Action();
    private final Reaction reaction = new Reaction();

    private TinyDirectorySelector(final TinyDirectoryService service) {
        this.service = service;
    }

    public static void main(final String[] args) {
        final TinyDirectoryService service = new TinyDirectoryService();
        SwingUtilities.invokeLater(() -> new TinyDirectorySelector(service).run());
    }

    private void run() {
        final Preferences preferences = PREFERENCES.node(WIN_NODE);
        final JFrame frame = visual.newFrame(preferences);
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }

    private class Visual {

        private JFrame newFrame(final Preferences preferences) {
            return JFrames.builder()
                          .setTitle(TinyDirectorySelector.class.getCanonicalName())
                          .setup(new BackedBounds(preferences, SIZE0)::setupFrame)
                          .setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
                          .setContentPane(newContentPane())
                          .build();
        }

        private JPanel newContentPane() {
            return JPanels.builder()
                          .setLayout(GridBag.layout())
                          .add(newSelector(), GBC_TEMPLATE.getY(0))
                          .add(new JLabel("- empty -"), GBC_TEMPLATE.getY(1))
                          .add(new JPanel(), GBC_TEMPLATE.getY(2, 1.0))
                          .build();
        }

        private JComboBox<Path> newSelector() {
            return JComboBoxes.builder(new PathModel())
                              .build();
        }
    }

    private class Action {
    }

    private class Reaction {
    }

    private class PathModel implements ComboBoxModel<Path> {

        private final List<ListDataListener> listeners = Collections.synchronizedList(new LinkedList<>());

        @Override
        public final void setSelectedItem(final Object anItem) {
            if (anItem instanceof Path) {
                final Path path = (Path) anItem;
                service.setPath(path);
            }
            listeners.forEach(this::update);
        }

        private void update(final ListDataListener listener) {
            listener.contentsChanged(new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, Integer.MAX_VALUE));
        }

        @Override
        public final Object getSelectedItem() {
            return service.getPath();
        }

        @Override
        public final int getSize() {
            return service.list().size();
        }

        @Override
        public final Path getElementAt(final int index) {
            return service.list().get(index);
        }

        @Override
        public final void addListDataListener(final ListDataListener l) {
            listeners.add(l);
        }

        @Override
        public final void removeListDataListener(final ListDataListener l) {
            listeners.removeAll(Collections.singletonList(l));
        }
    }
}
