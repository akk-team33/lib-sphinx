package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Color;
import java.awt.Component;
import java.util.function.Supplier;
import javax.swing.Icon;
import javax.swing.JTabbedPane;
import javax.swing.SingleSelectionModel;
import javax.swing.plaf.TabbedPaneUI;

/**
 * Utility class to handle {@link JTabbedPane}s.
 */
@SuppressWarnings("unused")
public final class JTabbedPanes {

    private JTabbedPanes() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JTabbedPane}.
     */
    public static Builder<JTabbedPane> builder() {
        return new Builder<>(JTabbedPane::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTabbedPane}.
     */
    public static <T extends JTabbedPane> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JTabbedPane}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTabbedPane}.
     */
    public static final class Builder<T extends JTabbedPane>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JTabbedPane}.
     * 
     * @param <T> The final type of the target instance, at least {@link JTabbedPane}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings({"ClassNameSameAsAncestorName", "ClassWithTooManyMethods"})
    @FunctionalInterface
    public interface Setup<T extends JTabbedPane, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JTabbedPane#add(Component)
         */
        default S add(final Component arg0) {
            return setup(result -> result.add(arg0));
        }

        /**
         * @see JTabbedPane#add(Component, Object)
         */
        default S add(final Component arg0, final Object arg1) {
            return setup(result -> result.add(arg0, arg1));
        }

        /**
         * @see JTabbedPane#add(Component, Object, int)
         */
        default S add(final Component arg0, final Object arg1, final int arg2) {
            return setup(result -> result.add(arg0, arg1, arg2));
        }

        /**
         * @see JTabbedPane#add(Component, int)
         */
        default S add(final Component arg0, final int arg1) {
            return setup(result -> result.add(arg0, arg1));
        }

        /**
         * @see JTabbedPane#add(String, Component)
         */
        default S add(final String arg0, final Component arg1) {
            return setup(result -> result.add(arg0, arg1));
        }

        /**
         * @see JTabbedPane#addTab(String, Component)
         */
        default S addTab(final String arg0, final Component arg1) {
            return setup(result -> result.addTab(arg0, arg1));
        }

        /**
         * @see JTabbedPane#addTab(String, Icon, Component)
         */
        default S addTab(final String arg0, final Icon arg1, final Component arg2) {
            return setup(result -> result.addTab(arg0, arg1, arg2));
        }

        /**
         * @see JTabbedPane#addTab(String, Icon, Component, String)
         */
        default S addTab(final String arg0, final Icon arg1, final Component arg2, final String arg3) {
            return setup(result -> result.addTab(arg0, arg1, arg2, arg3));
        }

        /**
         * @see JTabbedPane#remove(Component)
         */
        default S remove(final Component arg0) {
            return setup(result -> result.remove(arg0));
        }

        /**
         * @see JTabbedPane#remove(int)
         */
        default S remove(final int arg0) {
            return setup(result -> result.remove(arg0));
        }

        /**
         * @see JTabbedPane#removeAll()
         */
        default S removeAll() {
            return setup(JTabbedPane::removeAll);
        }

        /**
         * @see JTabbedPane#removeTabAt(int)
         */
        default S removeTabAt(final int arg0) {
            return setup(result -> result.removeTabAt(arg0));
        }

        /**
         * @see JTabbedPane#setBackgroundAt(int, Color)
         */
        default S setBackgroundAt(final int arg0, final Color arg1) {
            return setup(result -> result.setBackgroundAt(arg0, arg1));
        }

        /**
         * @see JTabbedPane#setComponentAt(int, Component)
         */
        default S setComponentAt(final int arg0, final Component arg1) {
            return setup(result -> result.setComponentAt(arg0, arg1));
        }

        /**
         * @see JTabbedPane#setDisabledIconAt(int, Icon)
         */
        default S setDisabledIconAt(final int arg0, final Icon arg1) {
            return setup(result -> result.setDisabledIconAt(arg0, arg1));
        }

        /**
         * @see JTabbedPane#setDisplayedMnemonicIndexAt(int, int)
         */
        default S setDisplayedMnemonicIndexAt(final int arg0, final int arg1) {
            return setup(result -> result.setDisplayedMnemonicIndexAt(arg0, arg1));
        }

        /**
         * @see JTabbedPane#setEnabledAt(int, boolean)
         */
        default S setEnabledAt(final int index, final boolean enabled) {
            return setup(result -> result.setEnabledAt(index, enabled));
        }

        /**
         * @see JTabbedPane#setForegroundAt(int, Color)
         */
        default S setForegroundAt(final int arg0, final Color arg1) {
            return setup(result -> result.setForegroundAt(arg0, arg1));
        }

        /**
         * @see JTabbedPane#setIconAt(int, Icon)
         */
        default S setIconAt(final int arg0, final Icon arg1) {
            return setup(result -> result.setIconAt(arg0, arg1));
        }

        /**
         * @see JTabbedPane#setMnemonicAt(int, int)
         */
        default S setMnemonicAt(final int arg0, final int arg1) {
            return setup(result -> result.setMnemonicAt(arg0, arg1));
        }

        /**
         * @see JTabbedPane#setModel(SingleSelectionModel)
         */
        default S setModel(final SingleSelectionModel arg0) {
            return setup(result -> result.setModel(arg0));
        }

        /**
         * @see JTabbedPane#setSelectedComponent(Component)
         */
        default S setSelectedComponent(final Component arg0) {
            return setup(result -> result.setSelectedComponent(arg0));
        }

        /**
         * @see JTabbedPane#setSelectedIndex(int)
         */
        default S setSelectedIndex(final int arg0) {
            return setup(result -> result.setSelectedIndex(arg0));
        }

        /**
         * @see JTabbedPane#setTabComponentAt(int, Component)
         */
        default S setTabComponentAt(final int arg0, final Component arg1) {
            return setup(result -> result.setTabComponentAt(arg0, arg1));
        }

        /**
         * @see JTabbedPane#setTabLayoutPolicy(int)
         */
        default S setTabLayoutPolicy(final int arg0) {
            return setup(result -> result.setTabLayoutPolicy(arg0));
        }

        /**
         * @see JTabbedPane#setTabPlacement(int)
         */
        default S setTabPlacement(final int arg0) {
            return setup(result -> result.setTabPlacement(arg0));
        }

        /**
         * @see JTabbedPane#setTitleAt(int, String)
         */
        default S setTitleAt(final int arg0, final String arg1) {
            return setup(result -> result.setTitleAt(arg0, arg1));
        }

        /**
         * @see JTabbedPane#setToolTipTextAt(int, String)
         */
        default S setToolTipTextAt(final int arg0, final String arg1) {
            return setup(result -> result.setToolTipTextAt(arg0, arg1));
        }

        /**
         * @see JTabbedPane#setUI(TabbedPaneUI)
         */
        default S setUI(final TabbedPaneUI arg0) {
            return setup(result -> result.setUI(arg0));
        }
    }
}
