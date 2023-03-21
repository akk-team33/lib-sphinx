package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.io.File;
import java.util.function.Supplier;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileView;

/**
 * Utility class to handle {@link JFileChooser}s.
 */
@SuppressWarnings("unused")
public final class JFileChoosers {

    private JFileChoosers() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JFileChooser}.
     */
    public static Builder<JFileChooser, ?> builder() {
        return new Builder<>(JFileChooser::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JFileChooser}.
     */
    public static <T extends JFileChooser> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JFileChooser}.
     * 
     * @param <T> The final type of the target instances, at least {@link JFileChooser}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JFileChooser, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JFileChooser}.
     * 
     * @param <T> The final type of the target instance, at least {@link JFileChooser}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JFileChooser, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JFileChooser#addChoosableFileFilter(FileFilter)
         */
        default S addChoosableFileFilter(final FileFilter filter) {
            return setup(result -> result.addChoosableFileFilter(filter));
        }

        /**
         * @see JFileChooser#removeChoosableFileFilter(FileFilter)
         */
        default S removeChoosableFileFilter(final FileFilter f) {
            return setup(result -> result.removeChoosableFileFilter(f));
        }

        /**
         * @see JFileChooser#setAcceptAllFileFilterUsed(boolean)
         */
        default S setAcceptAllFileFilterUsed(final boolean b) {
            return setup(result -> result.setAcceptAllFileFilterUsed(b));
        }

        /**
         * @see JFileChooser#setAccessory(JComponent)
         */
        default S setAccessory(final JComponent newAccessory) {
            return setup(result -> result.setAccessory(newAccessory));
        }

        /**
         * @see JFileChooser#setApproveButtonMnemonic(char)
         */
        default S setApproveButtonMnemonic(final char mnemonic) {
            return setup(result -> result.setApproveButtonMnemonic(mnemonic));
        }

        /**
         * @see JFileChooser#setApproveButtonMnemonic(int)
         */
        default S setApproveButtonMnemonic(final int mnemonic) {
            return setup(result -> result.setApproveButtonMnemonic(mnemonic));
        }

        /**
         * @see JFileChooser#setApproveButtonText(String)
         */
        default S setApproveButtonText(final String approveButtonText) {
            return setup(result -> result.setApproveButtonText(approveButtonText));
        }

        /**
         * @see JFileChooser#setApproveButtonToolTipText(String)
         */
        default S setApproveButtonToolTipText(final String toolTipText) {
            return setup(result -> result.setApproveButtonToolTipText(toolTipText));
        }

        /**
         * @see JFileChooser#setControlButtonsAreShown(boolean)
         */
        default S setControlButtonsAreShown(final boolean b) {
            return setup(result -> result.setControlButtonsAreShown(b));
        }

        /**
         * @see JFileChooser#setCurrentDirectory(File)
         */
        default S setCurrentDirectory(final File dir) {
            return setup(result -> result.setCurrentDirectory(dir));
        }

        /**
         * @see JFileChooser#setDialogTitle(String)
         */
        default S setDialogTitle(final String dialogTitle) {
            return setup(result -> result.setDialogTitle(dialogTitle));
        }

        /**
         * @see JFileChooser#setDialogType(int)
         */
        default S setDialogType(final int dialogType) {
            return setup(result -> result.setDialogType(dialogType));
        }

        /**
         * @see JFileChooser#setDragEnabled(boolean)
         */
        default S setDragEnabled(final boolean b) {
            return setup(result -> result.setDragEnabled(b));
        }

        /**
         * @see JFileChooser#setFileFilter(FileFilter)
         */
        default S setFileFilter(final FileFilter filter) {
            return setup(result -> result.setFileFilter(filter));
        }

        /**
         * @see JFileChooser#setFileHidingEnabled(boolean)
         */
        default S setFileHidingEnabled(final boolean b) {
            return setup(result -> result.setFileHidingEnabled(b));
        }

        /**
         * @see JFileChooser#setFileSelectionMode(int)
         */
        default S setFileSelectionMode(final int mode) {
            return setup(result -> result.setFileSelectionMode(mode));
        }

        /**
         * @see JFileChooser#setFileSystemView(FileSystemView)
         */
        default S setFileSystemView(final FileSystemView fsv) {
            return setup(result -> result.setFileSystemView(fsv));
        }

        /**
         * @see JFileChooser#setFileView(FileView)
         */
        default S setFileView(final FileView fileView) {
            return setup(result -> result.setFileView(fileView));
        }

        /**
         * @see JFileChooser#setMultiSelectionEnabled(boolean)
         */
        default S setMultiSelectionEnabled(final boolean b) {
            return setup(result -> result.setMultiSelectionEnabled(b));
        }

        /**
         * @see JFileChooser#setSelectedFile(File)
         */
        default S setSelectedFile(final File file) {
            return setup(result -> result.setSelectedFile(file));
        }

        /**
         * @see JFileChooser#setSelectedFiles(File[])
         */
        default S setSelectedFiles(final java.io.File[] selectedFiles) {
            return setup(result -> result.setSelectedFiles(selectedFiles));
        }
    }
}
