package de.team33.gen.sphinx.alpha.visual;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Generator {

    private static final Logger LOG = Logger.getLogger(Generator.class.getCanonicalName());

    private static final List<Class<?>> CANDIDATES = Arrays.asList(JDesktopPane.class,
                                                                   JTableHeader.class,
                                                                   JTextArea.class,
                                                                   JOptionPane.class,
                                                                   JProgressBar.class,
                                                                   JTabbedPane.class,
                                                                   JToolBar.class,
                                                                   JTextField.class,
                                                                   JPopupMenu.class,
                                                                   JTextComponent.class,
                                                                   JDialog.class,
                                                                   JColorChooser.class,
                                                                   JMenuItem.class,
                                                                   JComponent.class,
                                                                   JSlider.class,
                                                                   //JComboBox.class, skip for now
                                                                   JTree.class,
                                                                   JRootPane.class,
                                                                   //JLayer.class, skip for now
                                                                   JSplitPane.class,
                                                                   JPasswordField.class,
                                                                   JLabel.class,
                                                                   JPanel.class,
                                                                   JButton.class,
                                                                   JSpinner.class,
                                                                   JWindow.class,
                                                                   JFormattedTextField.class,
                                                                   JToggleButton.class,
                                                                   JScrollPane.class,
                                                                   JCheckBox.class,
                                                                   JScrollBar.class,
                                                                   JLayeredPane.class,
                                                                   JSeparator.class,
                                                                   JRadioButton.class,
                                                                   // JList.class, skip for now
                                                                   JInternalFrame.class,
                                                                   JRadioButtonMenuItem.class,
                                                                   JTextPane.class,
                                                                   JViewport.class,
                                                                   JToolTip.class,
                                                                   JTable.class,
                                                                   JMenuBar.class,
                                                                   JEditorPane.class,
                                                                   JFileChooser.class,
                                                                   JMenu.class,
                                                                   JCheckBoxMenuItem.class,
                                                                   JFrame.class);
    private static final Path PACKAGE_PATH = Paths.get("src", "main", "java", "de", "team33", "sphinx", "alpha", "visual")
                                                  .toAbsolutePath()
                                                  .normalize();
    public static final OpenOption[] OPEN_OPTIONS = {
            // StandardOpenOption.CREATE_NEW,
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING
    }; // <-- overwrite or not?

    public static void main(String[] args) {
        CANDIDATES.stream()
                  .flatMap(Generator::ancestors)
                  .distinct()
                  .filter(c -> !c.equals(Component.class)) // skip anyway!
                  .filter(Component.class::isAssignableFrom)
                  .map(ComponentUtilitySource::new)
                  //.forEach(System.out::println);
                  .forEach(Generator::write);
    }

    private static void write(final ComponentUtilitySource source) {
        final String fileName = source.getName() + ".java";
        final Path filePath = PACKAGE_PATH.resolve(fileName);
        try {
            Files.write(filePath, source.toString().getBytes(StandardCharsets.UTF_8), OPEN_OPTIONS);
        } catch (IOException e) {
            LOG.info(() -> "failed (already existing?): " + fileName + " (" + filePath + ")");
        }
    }

    private static Stream<Class<?>> ancestors(final Class<?> subject) {
        return (null == subject)
                ? Stream.empty()
                : Stream.concat(ancestors(subject.getSuperclass()),
                                Stream.of(subject));
    }
}
