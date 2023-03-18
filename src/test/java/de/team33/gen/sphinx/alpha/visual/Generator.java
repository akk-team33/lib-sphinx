package de.team33.gen.sphinx.alpha.visual;

import javax.swing.*;
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

    private static final List<Class<?>> CANDIDATES = Arrays.asList(
            JFrame.class, JButton.class, JCheckBox.class, JComboBox.class, JDesktopPane.class, JDialog.class,
            JEditorPane.class, JFileChooser.class, JFormattedTextField.class, JLabel.class, JLayer.class,
            JLayeredPane.class, JList.class, JMenu.class, JMenuBar.class, JMenuItem.class, JOptionPane.class,
            JPanel.class, JPasswordField.class, JPopupMenu.class, JProgressBar.class);
    private static final Path PACKAGE_PATH = Paths.get("src", "main", "java", "de", "team33", "sphinx", "alpha", "visual")
                                                  .toAbsolutePath()
                                                  .normalize();
    public static final OpenOption[] OPEN_OPTIONS = {
            StandardOpenOption.CREATE_NEW};

    public static void main(String[] args) {
        CANDIDATES.stream()
                  .flatMap(Generator::ancestors)
                  .distinct()
                  .filter(Component.class::isAssignableFrom)
                  .map(UtilityClass::new)
                  .forEach(Generator::write);
    }

    private static void write(final UtilityClass utilityClass) {
        final String fileName = utilityClass.getName() + ".java";
        final Path filePath = PACKAGE_PATH.resolve(fileName);
        try {
            Files.write(filePath, utilityClass.toString().getBytes(StandardCharsets.UTF_8), OPEN_OPTIONS);
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
