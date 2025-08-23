package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileView;
import java.io.File;
import java.util.function.Supplier;

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
    public static Builder<JFileChooser> builder() {
        return new Builder<>(JFileChooser::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JFileChooser}.
     */
    public static <T extends JFileChooser> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JFileChooser}.
     */
    public static <T extends JFileChooser> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link JFileChooser}.
     * 
     * @param <T> The final type of the target instances, at least {@link JFileChooser}.
     */
    public static final class Builder<T extends JFileChooser>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JFileChooser}.
     * 
     * @param <T> The final type of the target instance, at least {@link JFileChooser}.
     */
    public static final class Charger<T extends JFileChooser>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JFileChooser}.
     * 
     * @param <T> The final type of the target instance, at least {@link JFileChooser}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JFileChooser, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JFileChooser#addChoosableFileFilter(FileFilter)
         */
        default S addChoosableFileFilter(final FileFilter arg0) {
            return setup(result -> result.addChoosableFileFilter(arg0));
        }

        /**
         * @see JFileChooser#removeChoosableFileFilter(FileFilter)
         */
        default S removeChoosableFileFilter(final FileFilter arg0) {
            return setup(result -> result.removeChoosableFileFilter(arg0));
        }

        /**
         * @see JFileChooser#setAcceptAllFileFilterUsed(boolean)
         */
        default S setAcceptAllFileFilterUsed(final boolean arg0) {
            return setup(result -> result.setAcceptAllFileFilterUsed(arg0));
        }

        /**
         * @see JFileChooser#setAccessory(JComponent)
         */
        default S setAccessory(final JComponent arg0) {
            return setup(result -> result.setAccessory(arg0));
        }

        /**
         * @see JFileChooser#setApproveButtonMnemonic(char)
         */
        default S setApproveButtonMnemonic(final char arg0) {
            return setup(result -> result.setApproveButtonMnemonic(arg0));
        }

        /**
         * @see JFileChooser#setApproveButtonMnemonic(int)
         */
        default S setApproveButtonMnemonic(final int arg0) {
            return setup(result -> result.setApproveButtonMnemonic(arg0));
        }

        /**
         * @see JFileChooser#setApproveButtonText(String)
         */
        default S setApproveButtonText(final String arg0) {
            return setup(result -> result.setApproveButtonText(arg0));
        }

        /**
         * @see JFileChooser#setApproveButtonToolTipText(String)
         */
        default S setApproveButtonToolTipText(final String arg0) {
            return setup(result -> result.setApproveButtonToolTipText(arg0));
        }

        /**
         * @see JFileChooser#setControlButtonsAreShown(boolean)
         */
        default S setControlButtonsAreShown(final boolean arg0) {
            return setup(result -> result.setControlButtonsAreShown(arg0));
        }

        /**
         * @see JFileChooser#setCurrentDirectory(File)
         */
        default S setCurrentDirectory(final File arg0) {
            return setup(result -> result.setCurrentDirectory(arg0));
        }

        /**
         * @see JFileChooser#setDialogTitle(String)
         */
        default S setDialogTitle(final String arg0) {
            return setup(result -> result.setDialogTitle(arg0));
        }

        /**
         * @see JFileChooser#setDialogType(int)
         */
        default S setDialogType(final int arg0) {
            return setup(result -> result.setDialogType(arg0));
        }

        /**
         * @see JFileChooser#setDragEnabled(boolean)
         */
        default S setDragEnabled(final boolean arg0) {
            return setup(result -> result.setDragEnabled(arg0));
        }

        /**
         * @see JFileChooser#setFileFilter(FileFilter)
         */
        default S setFileFilter(final FileFilter arg0) {
            return setup(result -> result.setFileFilter(arg0));
        }

        /**
         * @see JFileChooser#setFileHidingEnabled(boolean)
         */
        default S setFileHidingEnabled(final boolean arg0) {
            return setup(result -> result.setFileHidingEnabled(arg0));
        }

        /**
         * @see JFileChooser#setFileSelectionMode(int)
         */
        default S setFileSelectionMode(final int arg0) {
            return setup(result -> result.setFileSelectionMode(arg0));
        }

        /**
         * @see JFileChooser#setFileSystemView(FileSystemView)
         */
        default S setFileSystemView(final FileSystemView arg0) {
            return setup(result -> result.setFileSystemView(arg0));
        }

        /**
         * @see JFileChooser#setFileView(FileView)
         */
        default S setFileView(final FileView arg0) {
            return setup(result -> result.setFileView(arg0));
        }

        /**
         * @see JFileChooser#setMultiSelectionEnabled(boolean)
         */
        default S setMultiSelectionEnabled(final boolean arg0) {
            return setup(result -> result.setMultiSelectionEnabled(arg0));
        }

        /**
         * @see JFileChooser#setSelectedFile(File)
         */
        default S setSelectedFile(final File arg0) {
            return setup(result -> result.setSelectedFile(arg0));
        }

        /**
         * @see JFileChooser#setSelectedFiles(File[])
         */
        default S setSelectedFiles(final java.io.File[] arg0) {
            return setup(result -> result.setSelectedFiles(arg0));
        }
    }
}
