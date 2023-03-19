package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Insets;
import java.util.function.Supplier;
import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.plaf.TextUI;
import javax.swing.text.Caret;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.Keymap;
import javax.swing.text.NavigationFilter;

/**
 * Utility class to handle {@link JTextComponent}s.
 */
@SuppressWarnings("unused")
public final class JTextComponents {

    private JTextComponents() {
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTextComponent}.
     */
    public static <T extends JTextComponent> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JTextComponent}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTextComponent}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JTextComponent, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JTextComponent}.
     * 
     * @param <T> The final type of the target instance, at least {@link JTextComponent}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JTextComponent, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JTextComponent#setCaret(Caret)
         */
        default S setCaret(final Caret arg0) {
            return setup(result -> result.setCaret(arg0));
        }

        /**
         * @see JTextComponent#setCaretColor(Color)
         */
        default S setCaretColor(final Color arg0) {
            return setup(result -> result.setCaretColor(arg0));
        }

        /**
         * @see JTextComponent#setCaretPosition(int)
         */
        default S setCaretPosition(final int arg0) {
            return setup(result -> result.setCaretPosition(arg0));
        }

        /**
         * @see JTextComponent#setComponentOrientation(ComponentOrientation)
         */
        default S setComponentOrientation(final ComponentOrientation arg0) {
            return setup(result -> result.setComponentOrientation(arg0));
        }

        /**
         * @see JTextComponent#setDisabledTextColor(Color)
         */
        default S setDisabledTextColor(final Color arg0) {
            return setup(result -> result.setDisabledTextColor(arg0));
        }

        /**
         * @see JTextComponent#setDocument(Document)
         */
        default S setDocument(final Document arg0) {
            return setup(result -> result.setDocument(arg0));
        }

        /**
         * @see JTextComponent#setDragEnabled(boolean)
         */
        default S setDragEnabled(final boolean arg0) {
            return setup(result -> result.setDragEnabled(arg0));
        }

        /**
         * @see JTextComponent#setDropMode(DropMode)
         */
        default S setDropMode(final DropMode arg0) {
            return setup(result -> result.setDropMode(arg0));
        }

        /**
         * @see JTextComponent#setEditable(boolean)
         */
        default S setEditable(final boolean arg0) {
            return setup(result -> result.setEditable(arg0));
        }

        /**
         * @see JTextComponent#setFocusAccelerator(char)
         */
        default S setFocusAccelerator(final char arg0) {
            return setup(result -> result.setFocusAccelerator(arg0));
        }

        /**
         * @see JTextComponent#setHighlighter(Highlighter)
         */
        default S setHighlighter(final Highlighter arg0) {
            return setup(result -> result.setHighlighter(arg0));
        }

        /**
         * @see JTextComponent#setKeymap(Keymap)
         */
        default S setKeymap(final Keymap arg0) {
            return setup(result -> result.setKeymap(arg0));
        }

        /**
         * @see JTextComponent#setMargin(Insets)
         */
        default S setMargin(final Insets arg0) {
            return setup(result -> result.setMargin(arg0));
        }

        /**
         * @see JTextComponent#setNavigationFilter(NavigationFilter)
         */
        default S setNavigationFilter(final NavigationFilter arg0) {
            return setup(result -> result.setNavigationFilter(arg0));
        }

        /**
         * @see JTextComponent#setSelectedTextColor(Color)
         */
        default S setSelectedTextColor(final Color arg0) {
            return setup(result -> result.setSelectedTextColor(arg0));
        }

        /**
         * @see JTextComponent#setSelectionColor(Color)
         */
        default S setSelectionColor(final Color arg0) {
            return setup(result -> result.setSelectionColor(arg0));
        }

        /**
         * @see JTextComponent#setSelectionEnd(int)
         */
        default S setSelectionEnd(final int arg0) {
            return setup(result -> result.setSelectionEnd(arg0));
        }

        /**
         * @see JTextComponent#setSelectionStart(int)
         */
        default S setSelectionStart(final int arg0) {
            return setup(result -> result.setSelectionStart(arg0));
        }

        /**
         * @see JTextComponent#setText(String)
         */
        default S setText(final String arg0) {
            return setup(result -> result.setText(arg0));
        }

        /**
         * @see JTextComponent#setUI(TextUI)
         */
        default S setUI(final TextUI arg0) {
            return setup(result -> result.setUI(arg0));
        }
    }
}
