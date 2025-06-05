package de.team33.sphinx.generation;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.text.JTextComponent;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Classes {

    public static final List<Class<?>> CANDIDATES = Arrays.asList(JDesktopPane.class,
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
                                                                  JComboBox.class, // skip for now?
                                                                  JTree.class,
                                                                  JRootPane.class,
                                                                  JLayer.class, // skip for now?
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
                                                                  JList.class, // skip for now?
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

    public static Stream<Class<?>> stream() {
        return CANDIDATES.stream()
                         .flatMap(Classes::ancestors)
                         .distinct();
    }

    public static Stream<Class<?>> ancestors(final Class<?> subject) {
        return (null == subject)
                ? Stream.empty()
                : Stream.concat(ancestors(subject.getSuperclass()),
                                Stream.of(subject));
    }

    public static boolean isIntroducedBy(final Class<?> componentClass, final Method method) {
        final Set<Class<?>> declaring = Classes.ancestors(componentClass)
                                               .filter(c -> isDeclaring(c, method))
                                               .collect(Collectors.toSet());
        return (1 == declaring.size()) && declaring.contains(componentClass);
    }

    private static boolean isDeclaring(final Class<?> componentClass, final Method method) {
        try {
            return null != componentClass.getMethod(method.getName(), method.getParameterTypes());
        } catch (final NoSuchMethodException e) {
            return false;
        }
    }
}
