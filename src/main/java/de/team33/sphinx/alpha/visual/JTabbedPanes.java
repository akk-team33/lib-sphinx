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
    public static Builder<JTabbedPane, ?> builder() {
        return new Builder<>(JTabbedPane::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTabbedPane}.
     */
    public static <T extends JTabbedPane> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JTabbedPane}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTabbedPane}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JTabbedPane, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JTabbedPane}.
     * 
     * @param <T> The final type of the target instance, at least {@link JTabbedPane}.
     * @param <S> The final type of the Setup implementation.
     */
    @FunctionalInterface
    public interface Setup<T extends JTabbedPane, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JTabbedPane#add(Component)
         */
        default S add(final Component component) {
            return setup(result -> result.add(component));
        }

        /**
         * @see JTabbedPane#add(Component, Object)
         */
        default S add(final Component component, final Object constraints) {
            return setup(result -> result.add(component, constraints));
        }

        /**
         * @see JTabbedPane#add(Component, Object, int)
         */
        default S add(final Component component, final Object constraints, final int index) {
            return setup(result -> result.add(component, constraints, index));
        }

        /**
         * @see JTabbedPane#add(Component, int)
         */
        default S add(final Component component, final int index) {
            return setup(result -> result.add(component, index));
        }

        /**
         * @see JTabbedPane#add(String, Component)
         */
        default S add(final String title, final Component component) {
            return setup(result -> result.add(title, component));
        }

        /**
         * @see JTabbedPane#addTab(String, Component)
         */
        default S addTab(final String title, final Component component) {
            return setup(result -> result.addTab(title, component));
        }

        /**
         * @see JTabbedPane#addTab(String, Icon, Component)
         */
        default S addTab(final String title, final Icon icon, final Component component) {
            return setup(result -> result.addTab(title, icon, component));
        }

        /**
         * @see JTabbedPane#addTab(String, Icon, Component, String)
         */
        default S addTab(final String title, final Icon icon, final Component component, final String tip) {
            return setup(result -> result.addTab(title, icon, component, tip));
        }

        /**
         * @see JTabbedPane#remove(Component)
         */
        default S remove(final Component component) {
            return setup(result -> result.remove(component));
        }

        /**
         * @see JTabbedPane#remove(int)
         */
        default S remove(final int index) {
            return setup(result -> result.remove(index));
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
        default S removeTabAt(final int index) {
            return setup(result -> result.removeTabAt(index));
        }

        /**
         * @see JTabbedPane#setBackgroundAt(int, Color)
         */
        default S setBackgroundAt(final int index, final Color background) {
            return setup(result -> result.setBackgroundAt(index, background));
        }

        /**
         * @see JTabbedPane#setComponentAt(int, Component)
         */
        default S setComponentAt(final int index, final Component component) {
            return setup(result -> result.setComponentAt(index, component));
        }

        /**
         * @see JTabbedPane#setDisabledIconAt(int, Icon)
         */
        default S setDisabledIconAt(final int index, final Icon disabledIcon) {
            return setup(result -> result.setDisabledIconAt(index, disabledIcon));
        }

        /**
         * @see JTabbedPane#setDisplayedMnemonicIndexAt(int, int)
         */
        default S setDisplayedMnemonicIndexAt(final int tabIndex, final int mnemonicIndex) {
            return setup(result -> result.setDisplayedMnemonicIndexAt(tabIndex, mnemonicIndex));
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
        default S setForegroundAt(final int index, final Color foreground) {
            return setup(result -> result.setForegroundAt(index, foreground));
        }

        /**
         * @see JTabbedPane#setIconAt(int, Icon)
         */
        default S setIconAt(final int index, final Icon icon) {
            return setup(result -> result.setIconAt(index, icon));
        }

        /**
         * @see JTabbedPane#setMnemonicAt(int, int)
         */
        default S setMnemonicAt(final int tabIndex, final int mnemonic) {
            return setup(result -> result.setMnemonicAt(tabIndex, mnemonic));
        }

        /**
         * @see JTabbedPane#setModel(SingleSelectionModel)
         */
        default S setModel(final SingleSelectionModel model) {
            return setup(result -> result.setModel(model));
        }

        /**
         * @see JTabbedPane#setSelectedComponent(Component)
         */
        default S setSelectedComponent(final Component c) {
            return setup(result -> result.setSelectedComponent(c));
        }

        /**
         * @see JTabbedPane#setSelectedIndex(int)
         */
        default S setSelectedIndex(final int index) {
            return setup(result -> result.setSelectedIndex(index));
        }

        /**
         * @see JTabbedPane#setTabComponentAt(int, Component)
         */
        default S setTabComponentAt(final int index, final Component component) {
            return setup(result -> result.setTabComponentAt(index, component));
        }

        /**
         * @see JTabbedPane#setTabLayoutPolicy(int)
         */
        default S setTabLayoutPolicy(final int tabLayoutPolicy) {
            return setup(result -> result.setTabLayoutPolicy(tabLayoutPolicy));
        }

        /**
         * @see JTabbedPane#setTabPlacement(int)
         */
        default S setTabPlacement(final int tabPlacement) {
            return setup(result -> result.setTabPlacement(tabPlacement));
        }

        /**
         * @see JTabbedPane#setTitleAt(int, String)
         */
        default S setTitleAt(final int index, final String title) {
            return setup(result -> result.setTitleAt(index, title));
        }

        /**
         * @see JTabbedPane#setToolTipTextAt(int, String)
         */
        default S setToolTipTextAt(final int index, final String toolTipText) {
            return setup(result -> result.setToolTipTextAt(index, toolTipText));
        }

        /**
         * @see JTabbedPane#setUI(TabbedPaneUI)
         */
        default S setUI(final TabbedPaneUI ui) {
            return setup(result -> result.setUI(ui));
        }
    }
}
